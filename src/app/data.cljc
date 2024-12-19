(ns app.data)

(def problems
  [{:id         1
    :title       "Nothing but the Truth"
    :tests       ["(= __ true)"]
    :description "Complete the expression so
it will evaluate to true." 
    :difficulty "elementary" 
    :tags []}

   {:id         2
    :title       "Simple Math"
    :tests       ["(= (- 10 (* 2 3)) __)"]
    :description "Innermost forms are evaluated first." 
    :difficulty "elementary" 
    :tags []}

   {:id         3
    :title       "Strings"
    :tests       ["(= __ (.toUpperCase \"hello world\"))"]
    :description "Clojure strings are Java strings,
so you can use Java string methods on them." 
    :difficulty "elementary" 
    :tags []}

   {:id         4
    :title       "Evaluation"
    :tests       ["(= __ (* 2 3 4 5 6 7 8 9))"]
    :description "Practice: 
                  Copy the form `(* 2 3 4 ...)` into the blank,
                  place the cursor right after the `)` 
                  and press `Alt + Enter` to evaluate the form to get the answer." 
    :difficulty "elementary" 
    :tags []}

   {:id         5 
    :title       "Lists"
    :tests       ["(= (list __) '(:a :b :c))"]
    :description "Lists can be constructed with either
a function or a quoted form." 
    :difficulty "elementary" 
    :tags []}

   {:id         6
    :title       "conj on lists"
    :tests       ["(= __ (conj '(2 3 4) 1))"
                  "(= __ (conj '(3 4) 2 1))"]
    :description "When operating on a list,
the conj function will return a new list
with one or more items \"added\" to the front." 
    :difficulty "elementary" 
    :tags []}

   {:id          7 
    :title       "Vectors"
    :tests       ["(= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))"]
    :description "Vectors can be constructed several ways.
You can compare them with lists." 
    :difficulty "elementary" 
    :tags []}

   {:id         8
    :title       "conj on vectors"
    :tests       ["(= __ (conj [1 2 3] 4))"
                  "(= __ (conj [1 2] 3 4))"]
    :description "When operating on a Vector,
the conj function will return a new vector
with one or more items \"added\" to the end." 
    :difficulty "elementary" 
    :tags []}

   {:id         9
    :title       "Sets"
    :tests       ["(= __ (set '(:a :a :b :c :c :c :c :d :d)))"
                  "(= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))"]
    :description "Sets are collections of unique values." 
    :difficulty "elementary" 
    :tags []}

   {:id 10 :title "conj on sets"
    :tests ["(= #{1 2 3 4} (conj #{1 4 3} __))"]
    :description "When operating on a set,
the conj function returns a new set with one or more keys \"added\"." 
    :difficulty "elementary" 
    :tags []}

   {:id 11 :title "Maps"
    :tests ["(= __ ((hash-map :a 10, :b 20, :c 30) :b))"
            "(= __ (:b {:a 10, :b 20, :c 30}))"]
    :description "Maps store key-value pairs.
Both maps and keywords can be used as lookup functions.
Commas are whitespace." 
    :difficulty "elementary" 
    :tags []}

   {:id 12 :title "conj on maps"
    :tests ["(= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))"]
    :description "When operating on a map,
the conj function returns a new map
with one or more key-value pairs \"added\"." 
    :difficulty "elementary" 
    :tags []}

   {:id         13
    :title       "Sequences: first, second, last"
    :tests       ["(= __ (first '(3 2 1)))"
                  "(= __ (second [2 3 4]))"
                  "(= __ (last (list 1 2 3)))"]
    :description "All Clojure collections support sequencing.
You can operate on sequences with functions
like first, second, and last." 
    :difficulty "elementary" 
    :tags []}

   {:id         14
    :title       "rest"
    :tests       ["(= __ (rest [10 20 30 40]))"]
    :description "The rest function will return all the items
of a sequence except the first." 
    :difficulty "elementary" 
    :tags []}
 
   {:id         15
    :title       "pop from a List"
    :tests       ["(= __ (pop '(3 2 1)))"]
    :description "The pop function removes the first element
from a list."
    :difficulty "elementary"
    :tags []}

   {:id         16
    :title       "pop from a Vector"
    :tests       ["(= __ (pop [4 5 6]))"]
    :description "The pop function removes the last element
from a vector."
    :difficulty "elementary"
    :tags []}

   {:id         17
    :title       "nth Access in Collections"
    :tests       ["(= __ (nth [10 20 30 40 50] 3))"]
    :description "The nth function retrieves an element
at a specific index in a collection."
    :difficulty "elementary"
    :tags []}

   {:id         18
    :title       "get from a Map"
    :tests       ["(= __ (get {:a 10 :b 20 :c 30} :b))"]
    :description "The get function retrieves the value
associated with a given key in a map."
    :difficulty "elementary"
    :tags []}

   {:id         19
    :title       "Associating and Dissociating Keys"
    :tests       ["(= __ (assoc {:a 1} :b 2))"
                  "(= __ (dissoc {:a 1 :b 2 :c 3} :c))"]
    :description "The assoc function adds or updates a key-value pair,
while dissoc removes a key from a map."
    :difficulty "elementary"
    :tags []}

   {:id         20 
    :title       "Concatenating Sequences"
    :tests       ["(= __ (concat [1 2] '(3 4)))"]
    :description "The concat function combines multiple sequences
into a single lazy sequence."
    :difficulty "elementary"
    :tags []}

   {:id         21
    :title       "Merge Maps"
    :tests       ["(= __ (merge {:a 1} {:b 2}))"]
    :description "The merge function combines multiple maps into one,
with later maps overriding earlier ones."
    :difficulty "elementary"
    :tags []}

   {:id         22
    :title       "Basic Arithmetic"
    :tests       ["(= __ (inc 5))"
                  "(= __ (dec 7))"
                  "(= __ (max 3 6))"
                  "(= __ (min 6 15))"]
    :description "Arithmetic functions include inc, dec, max, and min."
    :difficulty "elementary"
    :tags []}

   {:id         23
    :title       "Basic Test Functions"
    :tests       ["(= __ (zero? 0))"
                  "(= __ (pos? 5))"
                  "(= __ (number? 42))"
                  "(= __ (nil? nil))"
                  "(= __ (keyword? :kkk))"
                  "(= __ (string? \"hello\"))"]
    :description "Test functions can evaluate properties of values."
    :difficulty "elementary"
    :tags []}

   {:id         24
    :title       "Working with Keywords"
    :tests       ["(= __ (keyword? (keyword \"key\")))"
                  "(= __ (string? (name :key)))"]
    :description "Keywords are immutable and unique identifiers.
They can be converted to strings and strings can also be converted to keyword."
    :difficulty "elementary"
    :tags []}

   {:id         25
    :title       "Strings: Combining and Substrings"
    :tests       ["(= __ (str \"Hello\" \" \" \"World!\"))"
                  "(= __ (subs \"Hello World! Clojure\" 0 12))"
                  "(= __ (clojure.string/trim \"  Hello World!  \"))"
                  ]
    :description "The str function concatenates strings,
and subs extracts substrings. The trim function removes whitespace
 from both ends of string."
    :difficulty "elementary"
    :tags []}

   {:id         26
    :title       "String Test Functions"
    :tests       ["(= __ (clojure.string/starts-with? \"hello\" \"he\"))"
                  "(= __ (clojure.string/ends-with? \"hello\" \"llo\"))"
                  "(= __ (clojure.string/includes? \"hello\" \"ll\"))"]
    :description "String functions like starts-with?, ends-with? and includes? are helper to compare substr"   
    :difficulty "elementary"
    :tags []}

   {:id         27
    :title       "Collection Predicates"
    :tests       ["(= __ (coll? [1 2 3]))"
                  "(= __ (vector? [1 2 3]))"
                  "(= __ (list? '(1 2 3)))"
                  "(= __ (set? #{1 2 3}))"
                  "(= __ (map? {:a 1 :b 2}))"]
    :description "Use predicates to test the type of a collection."
    :difficulty "elementary"
    :tags []}

   {:id         28
    :title       "Empty"
    :tests       ["(= __ (empty? [3 4 5]))"]
    :description "The empty? function checks if a collection is empty."
    :difficulty "elementary"
    :tags []}

   {:id         29
    :title       "Count"
    :tests       ["(= __ (count '(1 2 3)))"
                  "(= __ (count [1 2 3]))"
                  "(= __ (count #{:a :b :c}))"
                  "(= __ (count {:a 1 :b 2 :c 3}))"]
    :description "count returns the number of elements."
    :difficulty "elementary"
    :tags []}

   {:id         30
    :title       "Transforming Collections"
    :tests       ["(= __ (into [] '(1 2 3)))"]
    :description "The into function transfers elements
from one collection to another, maintaining the target type."
    :difficulty "elementary"
    :tags []}

   {:id         31
    :title       "Parsing Strings to Long"
    :tests       ["(= __ (clojure.edn/read-string \"123\"))"]
    :description "The clojure.edn/read-string can parse string into Long, Double, or other types"
    :difficulty "elementary"
    :tags []}
    ;; To Here, Estimation of time is 50 minutes
    ;; Functions and control starts here
])
