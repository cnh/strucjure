[1 nil]
[(1 2 3) nil]
[(1 2 3) (4)]
#<Exception java.lang.Exception: Match failed>
(fn [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!) a (strucjure.view/new-mutable!)] [(clojure.core/let [:strucjure.regression/gensym (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 1)) :strucjure.regression/gensym)] nil :strucjure.regression/gensym) (strucjure.view/get-remaining!)]))
#{a}
#{a}
[2 nil]
#<Exception java.lang.Exception: Match failed>
(fn [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!)] [(strucjure.view/check (clojure.core/or (clojure.core/nil? :strucjure.regression/gensym) (clojure.core/seq? :strucjure.regression/gensym)) (clojure.core/let [:strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym)] (clojure.core/cons (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 1)) :strucjure.regression/gensym))) (clojure.core/let [:strucjure.regression/gensym (clojure.core/next :strucjure.regression/gensym)] (clojure.core/cons (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 2)) :strucjure.regression/gensym))) (clojure.core/let [:strucjure.regression/gensym (clojure.core/next :strucjure.regression/gensym)] (strucjure.view/check-remaining! true :strucjure.regression/gensym nil))))))) (strucjure.view/get-remaining!)]))
[(1 2) nil]
#<Exception java.lang.Exception: Match failed>
[(1 2) (3)]
#<Exception java.lang.Exception: Match failed>
#<Exception java.lang.Exception: Match failed>
[nil nil]
[nil (1 2)]
[nil nil]
[nil nil]
[nil (2)]
[(1 1) nil]
[(1 1) (2)]
[(1 2 1 2) (3)]
[(1 1 1) nil]
(fn [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!)] [(strucjure.view/check (clojure.core/or (clojure.core/nil? :strucjure.regression/gensym) (clojure.core/instance? clojure.lang.Seqable :strucjure.regression/gensym)) (clojure.core/loop [:strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym) :strucjure.regression/gensym [] :strucjure.regression/gensym 0] (clojure.core/let [:strucjure.regression/gensym (strucjure.view/on-fail (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 1)) :strucjure.regression/gensym))) strucjure.view/failure)] (if (strucjure.view/failure? :strucjure.regression/gensym) (do nil (strucjure.view/check-remaining! true :strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym))) (recur (clojure.core/next :strucjure.regression/gensym) (clojure.core/conj :strucjure.regression/gensym :strucjure.regression/gensym) (clojure.core/inc :strucjure.regression/gensym)))))) (strucjure.view/get-remaining!)]))
(fn [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!)] [(do (strucjure.view/check (clojure.core/or (clojure.core/nil? :strucjure.regression/gensym) (clojure.core/instance? clojure.lang.Seqable :strucjure.regression/gensym)) (clojure.core/loop [:strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym) :strucjure.regression/gensym [] :strucjure.regression/gensym 0] (clojure.core/let [:strucjure.regression/gensym (strucjure.view/on-fail (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 1)) :strucjure.regression/gensym))) strucjure.view/failure)] (if (strucjure.view/failure? :strucjure.regression/gensym) (do nil (strucjure.view/check-remaining! true :strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym))) (recur (clojure.core/next :strucjure.regression/gensym) (clojure.core/conj :strucjure.regression/gensym :strucjure.regression/gensym) (clojure.core/inc :strucjure.regression/gensym)))))) (strucjure.view/call-fnk :strucjure.regression/fn)) (strucjure.view/get-remaining!)]))
(fn [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!) a (strucjure.view/new-mutable!)] [(do (clojure.core/let [:strucjure.regression/gensym (strucjure.view/check (clojure.core/or (clojure.core/nil? :strucjure.regression/gensym) (clojure.core/instance? clojure.lang.Seqable :strucjure.regression/gensym)) (clojure.core/loop [:strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym) :strucjure.regression/gensym [] :strucjure.regression/gensym 0] (clojure.core/let [:strucjure.regression/gensym (strucjure.view/on-fail (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 1)) :strucjure.regression/gensym))) strucjure.view/failure)] (if (strucjure.view/failure? :strucjure.regression/gensym) (do nil (strucjure.view/check-remaining! true :strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym))) (recur (clojure.core/next :strucjure.regression/gensym) (clojure.core/conj :strucjure.regression/gensym :strucjure.regression/gensym) (clojure.core/inc :strucjure.regression/gensym))))))] (strucjure.view/set-mutable! a :strucjure.regression/gensym) :strucjure.regression/gensym) (strucjure.view/call-fnk :strucjure.regression/fn)) (strucjure.view/get-remaining!)]))
{:foo true}
#<Exception java.lang.Exception: Match failed>
[[1 2] nil]
[[1 2] (3)]
#<Exception java.lang.Exception: Match failed>
[(1 2 3) nil]
[([:foo 1] [:bar (& * 3)]) nil]
[([:foo 1] [:bar (& * 3)]) nil]
[[:foo 1] nil]
[[:a (1 2)] nil]
^{:ns #<Namespace strucjure.regression.sandbox>, :name eg-num, :file "NO_SOURCE_PATH"} #'strucjure.regression.sandbox/eg-num
^{:ns #<Namespace strucjure.regression.sandbox>, :name eg-num-out, :file "NO_SOURCE_PATH"} #'strucjure.regression.sandbox/eg-num-out
^{:ns #<Namespace strucjure.regression.sandbox>, :name num, :file "NO_SOURCE_PATH"} #'strucjure.regression.sandbox/num
[0 nil]
#<Exception java.lang.Exception: Match failed>
[1 nil]
[2 nil]
#<Exception java.lang.Exception: Match failed>
#strucjure.pattern.Name{:name zero, :pattern #strucjure.pattern.Node{:name zero}}
#strucjure.pattern.Name{:name zero, :pattern #strucjure.pattern.Node{:name zero}}
{num #strucjure.pattern.Or{:patterns (#strucjure.pattern.Name{:name zero, :pattern #strucjure.pattern.Node{:name zero}} #strucjure.pattern.Name{:name succ, :pattern #strucjure.pattern.Node{:name succ}})}, zero zero, succ (succ #strucjure.pattern.Name{:name x, :pattern #strucjure.pattern.Name{:name num, :pattern #strucjure.pattern.Node{:name num}}})}
(fn [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!)] [(strucjure.view/check (:strucjure.regression/fn :strucjure.regression/gensym) :strucjure.regression/gensym) (strucjure.view/get-remaining!)]))
[(quote 1) (quote 2) (strucjure.pattern/->Rest (strucjure.sugar/zero-or-more (quote 3)))]
[1 2 #strucjure.pattern.Rest{:pattern #strucjure.pattern.Repeated{:min-count nil, :max-count nil, :pattern 3}}]
[nil nil]
[[] nil]
[1 2 #strucjure.pattern.Rest{:pattern #strucjure.pattern.Name{:name x, :pattern #strucjure.pattern.Repeated{:min-count nil, :max-count nil, :pattern 3}}}]
[1 2 #strucjure.pattern.Rest{:pattern #strucjure.pattern.Name{:name x, :pattern #strucjure.pattern.Repeated{:min-count nil, :max-count nil, :pattern 3}}}]
{:foo 1, :bar (#strucjure.pattern.Rest{:pattern #strucjure.pattern.Repeated{:min-count nil, :max-count nil, :pattern 3}})}
[1 2 #strucjure.pattern.Or{:patterns [3 4]}]
[1 2 #strucjure.pattern.Name{:name x, :pattern #strucjure.pattern.Node{:name foo}}]
[[1 2] nil]
[[1 2 3 3 3] nil]
[[1 2 3 3 3] (4)]
[1 2 #strucjure.pattern.Name{:name x, :pattern #strucjure.pattern.Any{}}]
[(quote 1) (quote 2) (strucjure.pattern/->Rest (strucjure.pattern/->Name (quote x) (strucjure.pattern/->Any)))]
[(quote 1) (quote 2) (strucjure.pattern/->Rest (strucjure.pattern/->Name (quote x) (strucjure.pattern/->Any)))]
[(3 4) nil]
[(3 4) nil]
#strucjure.pattern.Output{:pattern [1 2 #strucjure.pattern.Rest{:pattern #strucjure.pattern.Name{:name rest, :pattern #strucjure.pattern.Repeated{:min-count nil, :max-count nil, :pattern 3}}}], :fnk :strucjure.regression/fn}
(fn [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!) rest (strucjure.view/new-mutable!)] [(do (strucjure.view/check (clojure.core/vector? :strucjure.regression/gensym) (clojure.core/vec (clojure.core/let [:strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym)] (clojure.core/cons (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 1)) :strucjure.regression/gensym))) (clojure.core/let [:strucjure.regression/gensym (clojure.core/next :strucjure.regression/gensym)] (clojure.core/cons (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 2)) :strucjure.regression/gensym))) (clojure.core/let [:strucjure.regression/gensym (clojure.core/next :strucjure.regression/gensym)] (clojure.core/concat (clojure.core/let [:strucjure.regression/gensym (strucjure.view/check (clojure.core/or (clojure.core/nil? :strucjure.regression/gensym) (clojure.core/instance? clojure.lang.Seqable :strucjure.regression/gensym)) (clojure.core/loop [:strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym) :strucjure.regression/gensym [] :strucjure.regression/gensym 0] (clojure.core/let [:strucjure.regression/gensym (strucjure.view/on-fail (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 3)) :strucjure.regression/gensym))) strucjure.view/failure)] (if (strucjure.view/failure? :strucjure.regression/gensym) (do nil (strucjure.view/check-remaining! true :strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym))) (recur (clojure.core/next :strucjure.regression/gensym) (clojure.core/conj :strucjure.regression/gensym :strucjure.regression/gensym) (clojure.core/inc :strucjure.regression/gensym))))))] (strucjure.view/set-mutable! rest :strucjure.regression/gensym) :strucjure.regression/gensym) (clojure.core/let [:strucjure.regression/gensym (strucjure.view/swap-remaining! nil)] (strucjure.view/check-remaining! true :strucjure.regression/gensym nil)))))))))) (strucjure.view/call-fnk :strucjure.regression/fn)) (strucjure.view/get-remaining!)]))
[(3 3 3) nil]
#strucjure.pattern.Or{:patterns [[(->Name (quote succ) (->View (quote succ))) (->Name (quote zero) (->View (quote zero)))]]}
(clojure.core/list (quote 1) (quote 2) (quote 3))
(clojure.core/list (quote succ))
^{:ns #<Namespace strucjure.regression.sandbox>, :name num-graph, :file "NO_SOURCE_PATH"} #'strucjure.regression.sandbox/num-graph
^{:ns #<Namespace strucjure.regression.sandbox>, :name num-out, :file "NO_SOURCE_PATH"} #'strucjure.regression.sandbox/num-out
(strucjure.graph/with-named-inner-nodes (strucjure.graph/with-named-outer-nodes (strucjure.sugar/with-nodes [foo] {(quote foo) (strucjure.sugar/pattern (clojure.core/unquote foo))})))
^{:ns #<Namespace strucjure.regression.sandbox>, :name num, :file "NO_SOURCE_PATH"} #'strucjure.regression.sandbox/num
[0 nil]
[2 nil]
#<Exception java.lang.Exception: Match failed>
#<Exception java.lang.Exception: Match failed>
(fn [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!)] [(do (:strucjure.regression/fn "[1 2 3]" :strucjure.regression/gensym) (try (clojure.core/let [:strucjure.regression/gensym (clojure.core/binding [strucjure.debug/*depth* (clojure.core/inc strucjure.debug/*depth*)] (strucjure.view/check (clojure.core/vector? :strucjure.regression/gensym) (clojure.core/vec (clojure.core/let [:strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym)] (clojure.core/cons (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (do (:strucjure.regression/fn "1" :strucjure.regression/gensym) (try (clojure.core/let [:strucjure.regression/gensym (clojure.core/binding [strucjure.debug/*depth* (clojure.core/inc strucjure.debug/*depth*)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 1)) :strucjure.regression/gensym))] (:strucjure.regression/fn "1" :strucjure.regression/gensym (strucjure.view/get-remaining!)) :strucjure.regression/gensym) (catch java.lang.Exception :strucjure.regression/gensym (:strucjure.regression/fn "1" :strucjure.regression/gensym) (throw :strucjure.regression/gensym)))))) (clojure.core/let [:strucjure.regression/gensym (clojure.core/next :strucjure.regression/gensym)] (clojure.core/cons (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (do (:strucjure.regression/fn "2" :strucjure.regression/gensym) (try (clojure.core/let [:strucjure.regression/gensym (clojure.core/binding [strucjure.debug/*depth* (clojure.core/inc strucjure.debug/*depth*)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 2)) :strucjure.regression/gensym))] (:strucjure.regression/fn "2" :strucjure.regression/gensym (strucjure.view/get-remaining!)) :strucjure.regression/gensym) (catch java.lang.Exception :strucjure.regression/gensym (:strucjure.regression/fn "2" :strucjure.regression/gensym) (throw :strucjure.regression/gensym)))))) (clojure.core/let [:strucjure.regression/gensym (clojure.core/next :strucjure.regression/gensym)] (clojure.core/cons (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (do (:strucjure.regression/fn "3" :strucjure.regression/gensym) (try (clojure.core/let [:strucjure.regression/gensym (clojure.core/binding [strucjure.debug/*depth* (clojure.core/inc strucjure.debug/*depth*)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 3)) :strucjure.regression/gensym))] (:strucjure.regression/fn "3" :strucjure.regression/gensym (strucjure.view/get-remaining!)) :strucjure.regression/gensym) (catch java.lang.Exception :strucjure.regression/gensym (:strucjure.regression/fn "3" :strucjure.regression/gensym) (throw :strucjure.regression/gensym)))))) (clojure.core/let [:strucjure.regression/gensym (clojure.core/next :strucjure.regression/gensym)] (strucjure.view/check-remaining! true :strucjure.regression/gensym nil)))))))))))] (:strucjure.regression/fn "[1 2 3]" :strucjure.regression/gensym (strucjure.view/get-remaining!)) :strucjure.regression/gensym) (catch java.lang.Exception :strucjure.regression/gensym (:strucjure.regression/fn "[1 2 3]" :strucjure.regression/gensym) (throw :strucjure.regression/gensym)))) (strucjure.view/get-remaining!)]))
[[1 2 3] nil]
[{:1 2, :3 [3 5]} nil]
(fn [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!)] [(clojure.core/let [[:strucjure.regression/gensym :strucjure.regression/gensym] ((clojure.core/letfn [(:strucjure.regression/gensym [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!) zero (strucjure.view/new-mutable!) succ (strucjure.view/new-mutable!) num (strucjure.view/new-mutable!)] [(clojure.core/let [:strucjure.regression/gensym (strucjure.view/on-fail (clojure.core/let [:strucjure.regression/gensym (clojure.core/let [[:strucjure.regression/gensym :strucjure.regression/gensym] (:strucjure.regression/gensym :strucjure.regression/gensym)] (strucjure.view/check-remaining! true :strucjure.regression/gensym :strucjure.regression/gensym))] nil :strucjure.regression/gensym) (do (strucjure.view/set-remaining! nil) (clojure.core/let [:strucjure.regression/gensym (clojure.core/let [[:strucjure.regression/gensym :strucjure.regression/gensym] (:strucjure.regression/gensym :strucjure.regression/gensym)] (strucjure.view/check-remaining! true :strucjure.regression/gensym :strucjure.regression/gensym))] nil :strucjure.regression/gensym)))] nil :strucjure.regression/gensym) (strucjure.view/get-remaining!)])) (:strucjure.regression/gensym [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!) succ (strucjure.view/new-mutable!) x (strucjure.view/new-mutable!) num (strucjure.view/new-mutable!)] [(do (clojure.core/let [:strucjure.regression/gensym (strucjure.view/check (clojure.core/or (clojure.core/nil? :strucjure.regression/gensym) (clojure.core/seq? :strucjure.regression/gensym)) (clojure.core/let [:strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym)] (clojure.core/cons (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote ^{:used-here #{x}, :bound-here #{}} succ)) :strucjure.regression/gensym))) (clojure.core/let [:strucjure.regression/gensym (clojure.core/next :strucjure.regression/gensym)] (clojure.core/cons (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (clojure.core/let [:strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/let [[:strucjure.regression/gensym :strucjure.regression/gensym] (:strucjure.regression/gensym :strucjure.regression/gensym)] (strucjure.view/check-remaining! false :strucjure.regression/gensym :strucjure.regression/gensym))] nil :strucjure.regression/gensym)] (strucjure.view/set-mutable! x :strucjure.regression/gensym) :strucjure.regression/gensym))) (clojure.core/let [:strucjure.regression/gensym (clojure.core/next :strucjure.regression/gensym)] (strucjure.view/check-remaining! true :strucjure.regression/gensym nil)))))))] nil :strucjure.regression/gensym) (strucjure.view/call-fnk :strucjure.regression/fn)) (strucjure.view/get-remaining!)])) (:strucjure.regression/gensym [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!) zero (strucjure.view/new-mutable!)] [(do (clojure.core/let [:strucjure.regression/gensym (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote ^{:used-here #{}, :bound-here #{}} zero)) :strucjure.regression/gensym)] nil :strucjure.regression/gensym) (strucjure.view/call-fnk :strucjure.regression/fn)) (strucjure.view/get-remaining!)]))] :strucjure.regression/gensym) :strucjure.regression/gensym)] (strucjure.view/check-remaining! true :strucjure.regression/gensym :strucjure.regression/gensym)) (strucjure.view/get-remaining!)]))
(clojure.core/letfn [(:strucjure.regression/gensym [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!) zero (strucjure.view/new-mutable!) succ (strucjure.view/new-mutable!) num (strucjure.view/new-mutable!)] [(clojure.core/let [:strucjure.regression/gensym (strucjure.view/on-fail (clojure.core/let [:strucjure.regression/gensym (clojure.core/let [[:strucjure.regression/gensym :strucjure.regression/gensym] (:strucjure.regression/gensym :strucjure.regression/gensym)] (strucjure.view/check-remaining! true :strucjure.regression/gensym :strucjure.regression/gensym))] nil :strucjure.regression/gensym) (do (strucjure.view/set-remaining! nil) (clojure.core/let [:strucjure.regression/gensym (clojure.core/let [[:strucjure.regression/gensym :strucjure.regression/gensym] (:strucjure.regression/gensym :strucjure.regression/gensym)] (strucjure.view/check-remaining! true :strucjure.regression/gensym :strucjure.regression/gensym))] nil :strucjure.regression/gensym)))] nil :strucjure.regression/gensym) (strucjure.view/get-remaining!)])) (:strucjure.regression/gensym [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!) succ (strucjure.view/new-mutable!) x (strucjure.view/new-mutable!) num (strucjure.view/new-mutable!)] [(do (clojure.core/let [:strucjure.regression/gensym (strucjure.view/check (clojure.core/or (clojure.core/nil? :strucjure.regression/gensym) (clojure.core/seq? :strucjure.regression/gensym)) (clojure.core/let [:strucjure.regression/gensym (clojure.core/seq :strucjure.regression/gensym)] (clojure.core/cons (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote ^{:used-here #{x}, :bound-here #{}} succ)) :strucjure.regression/gensym))) (clojure.core/let [:strucjure.regression/gensym (clojure.core/next :strucjure.regression/gensym)] (clojure.core/cons (strucjure.view/check :strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/first :strucjure.regression/gensym)] (clojure.core/let [:strucjure.regression/gensym (clojure.core/let [:strucjure.regression/gensym (clojure.core/let [[:strucjure.regression/gensym :strucjure.regression/gensym] (:strucjure.regression/gensym :strucjure.regression/gensym)] (strucjure.view/check-remaining! false :strucjure.regression/gensym :strucjure.regression/gensym))] nil :strucjure.regression/gensym)] (strucjure.view/set-mutable! x :strucjure.regression/gensym) :strucjure.regression/gensym))) (clojure.core/let [:strucjure.regression/gensym (clojure.core/next :strucjure.regression/gensym)] (strucjure.view/check-remaining! true :strucjure.regression/gensym nil)))))))] nil :strucjure.regression/gensym) (strucjure.view/call-fnk :strucjure.regression/fn)) (strucjure.view/get-remaining!)])) (:strucjure.regression/gensym [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!) zero (strucjure.view/new-mutable!)] [(do (clojure.core/let [:strucjure.regression/gensym (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote ^{:used-here #{}, :bound-here #{}} zero)) :strucjure.regression/gensym)] nil :strucjure.regression/gensym) (strucjure.view/call-fnk :strucjure.regression/fn)) (strucjure.view/get-remaining!)]))] :strucjure.regression/gensym)
[2 nil]
(let* [:strucjure.regression/gensym ((fn [:strucjure.regression/gensym] (clojure.core/let [&remaining (strucjure.view/new-mutable!)] [(do (strucjure.view/check (clojure.core/= :strucjure.regression/gensym (quote 1)) :strucjure.regression/gensym) (strucjure.view/call-fnk :strucjure.regression/fn)) (strucjure.view/get-remaining!)])) 1) :strucjure.regression/gensym (clojure.core/nth :strucjure.regression/gensym 0 nil) :strucjure.regression/gensym (clojure.core/nth :strucjure.regression/gensym 1 nil)] :strucjure.regression/gensym)
:ok
#<Exception java.lang.Exception: Match failed>
:ok
#<Exception java.lang.Exception: Match failed>
:ok
:ok
^{:ns #<Namespace strucjure.regression.sandbox>, :name x, :file "NO_SOURCE_PATH"} #'strucjure.regression.sandbox/x
:ok
#<Exception java.lang.Exception: Match failed>
3
(3)
[1 2 #strucjure.pattern.Repeated{:min-count nil, :max-count 1, :pattern 3}]
:strucjure.regression/fn
3
nil
[[1 1 1 2 3] nil]
[[1 1 1 3] nil]
#<Exception java.lang.Exception: Match failed>
#<Exception java.lang.Exception: Match failed>