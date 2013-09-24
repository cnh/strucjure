(ns strucjure.view
  (:refer-clojure :exclude [assert])
  (:require [plumbing.core :refer [aconcat for-map]]
            [strucjure.util :refer [with-syms assert fnk->pos-fn fnk->args extend-protocol-by-fn try-with-meta]]
            [strucjure.pattern :as pattern]
            [strucjure.graph :as graph])
  (:import [clojure.lang ISeq IPersistentVector IPersistentMap]
           [strucjure.pattern Any Is Rest Guard Name Repeated WithMeta Or And Seqable Output As Node NodeOf Trace]))

;; TODO only allowed remaining inside Rest?
;; TODO catch exceptions from output and guards etc
;; TODO optimise output
;; TODO optimise checks and sets
;; TODO when input is unchanged just return input, no need to allocate
;; TODO code review &remaining - it's bound to be wrong somewhere

(defprotocol View
  (view* [this meta input output? remaining?]
    "A clj form which either a) throws failure b) returns output.
     If output? is false, its output value will be ignored.
     At the start of the form, &remaining is nil.
     If remaining? is true, on success &remaining should be set if the pattern leaves any remaining.
     If remaining? is false, the form should fail if the pattern leaves any remaining and leave the value of &remaining unchanged."))

(defn view [pattern input output? remaining?]
  (view* pattern (meta pattern) input output? remaining?))

(defn pattern->view
  ([pattern output? remaining?]
     (pattern->view 'fn pattern output? remaining?))
  ([name pattern output? remaining?]
     (let [[pattern bound-here] (pattern/with-bound pattern)
           pattern (pattern/with-used pattern #{})]
       (pattern/check-used-not-bound pattern)
       (with-syms [input]
         `(~name [~input]
                 (let [~@(interleave (cons '&remaining bound-here) (repeat `(new-mutable!)))]
                   [~(view pattern input output? remaining?) (get-remaining!)]))))))

(defn cache-input [f pattern input output? remaining?]
  (with-syms [cached-input]
    `(let [~cached-input ~input]
       ~(f pattern cached-input output? remaining?))))

;; --- MUTABLE ---

(defmacro new-mutable! []
  `(new proteus.Containers$O nil))

(defmacro get-mutable! [sym]
  `(.x ~sym))

(defmacro set-mutable! [sym value]
  `(.set ~sym ~value))

(defmacro get-remaining! []
  `(get-mutable! ~'&remaining))

(defmacro set-remaining! [value]
  `(set-mutable! ~'&remaining ~value))

(defmacro swap-remaining! [value]
  `(let [remaining# (get-remaining!)]
     (set-remaining! ~value)
     remaining#))

(defmacro check-remaining! [remaining? value output]
  (if remaining?
    `(do (set-remaining! ~value) ~output)
    `(check (nil? ~value) ~output)))

(defmacro call-fnk [fnk]
  `(~(fnk->pos-fn fnk)
    ~@(for [arg (fnk->args fnk)] `(get-mutable! ~arg))))

;; --- FAILURE ---

(def failure
  (Exception. "Match failed"))

(defmacro fail []
  `(throw failure))

(defmacro failure? [exc]
  `(identical? failure ~exc))

(defmacro on-fail [t f]
  `(try ~t
        (catch Exception exc#
          (if (failure? exc#)
            ~f
            (throw exc#)))))

(defmacro trap-fail [body]
  `(try ~body
        (catch Exception exc#
          (if (failure? exc#)
            (throw (Exception. (str exc#)))
            (throw exc#)))))

(defmacro check [cond body]
  `(if ~cond ~body (fail)))

;; --- UTIL ---

(defn head->view [pattern input output? remaining?]
  `(check ~input ~(cache-input view pattern `(first ~input) output? remaining?)))

(defn seq->view [patterns input output? remaining?]
  (if-let [[pattern & patterns] (seq patterns)]
    (if (instance? Rest pattern)
      `(concat ~(view (:pattern pattern) input output? true)
               ~(cache-input seq->view patterns `(swap-remaining! nil) output? remaining?))
      `(cons ~(head->view pattern input output? false)
             ~(cache-input seq->view patterns `(next ~input) output? remaining?)))
    `(check-remaining! ~remaining? ~input ~nil)))

(defn map->view [key->pattern input output? remaining?]
  (if (empty? key->pattern)
    input
    `(assoc ~input
       ~@(aconcat (for [[key pattern] key->pattern]
                    [key (cache-input view pattern `(get ~input ~key) output? false)])))))

(defn or->view [patterns input output? remaining?]
  (if-let [[pattern & patterns] (seq patterns)]
    (if patterns
      `(on-fail ~(view pattern input output? remaining?)
                (do (set-remaining! nil)
                    ~(or->view patterns input output? remaining?)))
      (view pattern input output? remaining?))
    (assert nil "'Or' patterns may not be empty")))

(defn as->view [patterns input output? remaining?]
  (if-let [[pattern & patterns] (seq patterns)]
    (if patterns
      (cache-input as->view patterns (view pattern input output? remaining?) output? remaining?)
      (view pattern input output? remaining?))
    (assert nil "'Or' patterns may not be empty")))

(def node-gensym
  (gensym "node"))

(defn node-name [name]
  (symbol (str name "-" node-gensym)))

(defn graph->view [name graph]
  `(letfn [~@(for [[name pattern] graph] (pattern->view (node-name name) pattern true true))]
     ~(node-name name)))

;; --- VALUE PATTERNS ---

(extend-protocol-by-fn
 View
 (fn view* [this {:keys [used-here]} input output? remaining?]

   [nil]
   `(check (nil? ~input) nil)

   [Object]
   `(check (= ~input '~this) ~input)

   [ISeq]
   `(check (or (nil? ~input) (seq? ~input))
           ~(cache-input seq->view this `(seq ~input) output? remaining?))

   [IPersistentVector]
   `(check (vector? ~input)
           (vec ~(cache-input seq->view this `(seq ~input) output? remaining?)))

   [Seqable]
   `(check (or (nil? ~input) (instance? clojure.lang.Seqable ~input))
           ~(cache-input seq->view (:patterns this) `(seq ~input) output? remaining?))

   [IPersistentMap]
   `(check (map? ~input)
           ~(map->view this input output? remaining?))

   [Rest]
   (assert nil "Cannot compile Rest outside of a parsing context:" this)))

;; --- LOGIC PATTERNS ---

(extend-protocol-by-fn
 View
 (fn view* [{:keys [pattern patterns meta-pattern fn fnk name input-fn success-fn failure-fn var value graph min-count max-count]}
           {:keys [used-here]} input output? remaining?]

   [Any]
   input

   [Is]
   `(check (~fn ~input) ~input)

   [Guard]
   `(let [output# ~(view pattern input output? remaining?)]
      (check (call-fnk ~fnk) output#)
      output#)

   [Name]
   (with-syms [output]
     `(let [~output ~(view pattern input (or output? (used-here name)) remaining?)]
        ~(when (used-here name) `(set-mutable! ~name ~output))
        ~output))

   [Repeated]
   (with-syms [loop-input loop-output loop-count result]
     (let [body (if (instance? Rest pattern)
                  (view (:pattern pattern) loop-input output? true)
                  (head->view pattern loop-input output? false))
           recur (if (instance? Rest pattern)
                   `(recur (swap-remaining! nil) (into ~loop-output ~result) (inc ~loop-count))
                   `(recur (next ~loop-input) (conj ~loop-output ~result) (inc ~loop-count)))
           return `(do ~(when (instance? Rest pattern) `(set-remaining! nil))
                       (check-remaining! ~remaining? ~loop-input (seq ~loop-output)))
           max-check&body (if max-count
                            `(check (< ~loop-count ~max-count) ~body)
                            body)
           min-check&return (if min-count
                              `(check (>= ~loop-count ~min-count) ~return)
                              return)]

       `(check (or (nil? ~input) (instance? clojure.lang.Seqable ~input))
               (loop [~loop-input (seq ~input)
                      ~loop-output []
                      ~loop-count 0]
                 (let [~result (on-fail ~max-check&body failure)]
                   (if (failure? ~result)
                     ~min-check&return
                     ~recur))))))

   [WithMeta]
   `(try-with-meta ~(view pattern input output? remaining?)
                   ~(cache-input view meta-pattern `(meta ~input) output? false))

   [Or]
   (or->view patterns input output? remaining?)

   [And]
   `(do ~@(interleave (map #(view % input false remaining?) (butlast patterns))
                     (repeat (when remaining? `(set-remaining! false))))
       ~(view (last patterns) input output? remaining?))

   [Output]
   `(do ~(view pattern input false remaining?)
        (call-fnk ~fnk))

   [As]
   (as->view patterns input output? remaining?)

   [Node]
   (with-syms [output remaining]
     `(let [[~output ~remaining] (~(node-name name) ~input)]
        (check-remaining! ~remaining? ~remaining ~output)))

   [NodeOf]
   (with-syms [output remaining]
     `(let [[~output ~remaining] (~(graph->view name graph) ~input)]
        (check-remaining! ~remaining? ~remaining ~output)))

   [Trace]
   `(do (~input-fn ~name ~input)
        (try (let [output# (binding [strucjure.debug/*depth* (inc strucjure.debug/*depth*)]
                             ~(view pattern input output? remaining?))]
                (~success-fn ~name output# (get-remaining!))
                output#)
              (catch Exception exc#
                (~failure-fn ~name exc#)
                (throw exc#))))))
