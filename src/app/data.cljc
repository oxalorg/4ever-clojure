(ns app.data)

(def problems
  [{:_id         1
    :title       "Nothing but the Truth"
    :tests       ["(= __ true)"]
    :description "Complete the expression so
it will evaluate to true." 
    :difficulty "elementary" 
    :tags []}

   {:_id         2
    :title       "Simple Math"
    :tests       ["(= (- 10 (* 2 3)) __)"]
    :description "Innermost forms are evaluated first." 
    :difficulty "elementary" 
    :tags []}

   {:_id         3
    :title       "Strings"
    :tests       ["(= __ (.toUpperCase \"hello world\"))"]
    :description "Clojure strings are Java strings,
so you can use Java string methods on them." 
    :difficulty "elementary" 
    :tags []}

   {:_id         4
    :title       "Lists"
    :tests       ["(= (list __) '(:a :b :c))"]
    :description "Lists can be constructed with either
a function or a quoted form." 
    :difficulty "elementary" 
    :tags []}

   {:_id         5
    :title       "conj on lists"
    :tests       ["(= __ (conj '(2 3 4) 1))"
                  "(= __ (conj '(3 4) 2 1))"]
    :description "When operating on a list,
the conj function will return a new list
with one or more items \"added\" to the front." 
    :difficulty "elementary" 
    :tags []}

   {:_id 6 :title "Vectors"
    :tests ["(= [__] (list :a :b :c) (vec '(:a :b :c)) (vector :a :b :c))"]
    :description "Vectors can be constructed several ways.
You can compare them with lists." 
    :difficulty "elementary" 
    :tags []}

   {:_id         7
    :title       "conj on vectors"
    :tests       ["(= __ (conj [1 2 3] 4))"
                  "(= __ (conj [1 2] 3 4))"]
    :description "When operating on a Vector,
the conj function will return a new vector
with one or more items \"added\" to the end." 
    :difficulty "elementary" 
    :tags []}

   {:_id         8
    :title       "Sets"
    :tests       ["(= __ (set '(:a :a :b :c :c :c :c :d :d)))"
                  "(= __ (clojure.set/union #{:a :b :c} #{:b :c :d}))"]
    :description "Sets are collections of unique values." 
    :difficulty "elementary" 
    :tags []}

   {:_id 9 :title "conj on sets"
    :tests ["(= #{1 2 3 4} (conj #{1 4 3} __))"]
    :description "When operating on a set,
the conj function returns a new set with one or more keys \"added\"." 
    :difficulty "elementary" 
    :tags []}

   {:_id 10 :title "Maps"
    :tests ["(= __ ((hash-map :a 10, :b 20, :c 30) :b))"
            "(= __ (:b {:a 10, :b 20, :c 30}))"]
    :description "Maps store key-value pairs.
Both maps and keywords can be used as lookup functions.
Commas are whitespace." 
    :difficulty "elementary" 
    :tags []}

   {:_id 11 :title "conj on maps"
    :tests ["(= {:a 1, :b 2, :c 3} (conj {:a 1} __ [:c 3]))"]
    :description "When operating on a map,
the conj function returns a new map
with one or more key-value pairs \"added\"." 
    :difficulty "elementary" 
    :tags []}

   {:_id         12
    :title       "Sequences"
    :tests       ["(= __ (first '(3 2 1)))"
                  "(= __ (second [2 3 4]))"
                  "(= __ (last (list 1 2 3)))"]
    :description "All Clojure collections support sequencing.
You can operate on sequences with functions
like first, second, and last." 
    :difficulty "elementary" 
    :tags []}

   {:_id         13
    :title       "rest"
    :tests       ["(= __ (rest [10 20 30 40]))"]
    :description "The rest function will return all the items
of a sequence except the first." 
    :difficulty "elementary" 
    :tags []}

   {:_id         14
    :title       "Functions"
    :tests       ["(= __ ((fn add-five [x] (+ x 5)) 3))"
                  "(= __ ((fn [x] (+ x 5)) 3))"
                  "(= __ (#(+ % 5) 3))"
                  "(= __ ((partial + 5) 3))"]
    :description "Clojure has many different ways to create functions." 
    :difficulty "elementary" 
    :tags []}

   {:_id         15
    :title       "Double Down"
    :tests       ["(= (__ 2) 4)"
                  "(= (__ 3) 6)"
                  "(= (__ 11) 22)"
                  "(= (__ 7) 14)"]
    :description "Write a function which doubles a number." 
    :difficulty "elementary" 
    :tags []}

   {:_id         16
    :title       "Hello World"
    :tests       ["(= (__ \"Dave\") \"Hello, Dave!\")"
                  "(= (__ \"Jenn\") \"Hello, Jenn!\")"
                  "(= (__ \"Rhea\") \"Hello, Rhea!\")"]
    :description "Write a function which returns a personalized greeting." 
    :difficulty "elementary" 
    :tags []}

   {:_id         17
    :title       "map"
    :tests       ["(= __ (map #(+ % 5) '(1 2 3)))"]
    :description "The map function takes two arguments:
a function (f) and a sequence (s).
Map returns a new sequence consisting of
the result of applying f to each item of s.
Do not confuse the map function with the map data structure." 
    :difficulty "elementary" 
    :tags []}

   {:_id         18
    :title       "filter"
    :tests       ["(= __ (filter #(> % 5) '(3 4 5 6 7)))"]
    :description "The filter function takes two arguments:
a predicate function (f) and a sequence (s).
Filter returns a new sequence consisting
of all the items of s for which (f item) returns true." 
    :difficulty "elementary" 
    :tags []}

   {:_id         19
    :restricted  ["last"]
    :title       "Last Element"
    :tests       ["(= (__ [1 2 3 4 5]) 5)"
                  "(= (__ '(5 4 3)) 3)"
                  "(= (__ [\"b\" \"c\" \"d\"]) \"d\")"]
    :description "Write a function which returns
the last element in a sequence." 
    :difficulty "easy" 
    :tags ["seqs" "core-functions"]}

   {:_id         20
    :title       "Penultimate Element"
    :tests       ["(= (__ (list 1 2 3 4 5)) 4)"
                  "(= (__ [\"a\" \"b\" \"c\"]) \"b\")"
                  "(= (__ [[1 2] [3 4]]) [1 2])"]
    :description "Write a function which returns
the second to last element from a sequence." 
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         21
    :restricted  ["nth"]
    :title       "Nth Element"
    :tests       ["(= (__ '(4 5 6 7) 2) 6)"
                  "(= (__ [:a :b :c] 0) :a)"
                  "(= (__ [1 2 3 4] 1) 2)"
                  "(= (__ '([1 2] [3 4] [5 6]) 2) [5 6])"]
    :description "Write a function which returns
the Nth element from a sequence." 
    :difficulty "easy" 
    :tags ["seqs" "core-functions"]}

   {:_id         22
    :restricted  ["count"]
    :title       "Count a Sequence"
    :tests       ["(= (__ '(1 2 3 3 1)) 5)"
                  "(= (__ \"Hello World\") 11)"
                  "(= (__ [[1 2] [3 4] [5 6]]) 3)"
                  "(= (__ '(13)) 1)"
                  "(= (__ '(:a :b :c)) 3)"]
    :description "Write a function which returns
the total number of elements in a sequence."
    :difficulty "easy" 
    :tags ["seqs" "core-functions"]}

   {:_id         23
    :restricted  ["reverse"]
    :title       "Reverse a Sequence"
    :tests       ["(= (__ [1 2 3 4 5]) [5 4 3 2 1])"
                  "(= (__ (sorted-set 5 7 2 7)) '(7 5 2))"
                  "(= (__ [[1 2][3 4][5 6]]) [[5 6][3 4][1 2]])"]
    :description "Write a function which reverses a sequence."
    :difficulty "easy" 
    :tags ["seqs" "core-functions"]}

   {:_id         24
    :title       "Sum It All Up"
    :tests       ["(= (__ [1 2 3]) 6)"
                  "(= (__ (list 0 -2 5 5)) 8)"
                  "(= (__ #{4 2 1}) 7)"
                  "(= (__ '(0 0 -1)) -1)"
                  "(= (__ '(1 10 3)) 14)"]
    :description "Write a function which returns
the sum of a sequence of numbers."
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         25
    :title       "Find the odd numbers"
    :tests       ["(= (__ #{1 2 3 4 5}) '(1 3 5))"
                  "(= (__ [4 2 1 6]) '(1))"
                  "(= (__ [2 2 4 6]) '())"
                  "(= (__ [1 1 1 3]) '(1 1 1 3))"]
    :description "Write a function which returns
only the odd numbers from a sequence."
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         26
    :title       "Fibonacci Sequence"
    :tests       ["(= (__ 3) '(1 1 2))"
                  "(= (__ 6) '(1 1 2 3 5 8))"
                  "(= (__ 8) '(1 1 2 3 5 8 13 21))"]
    :description "Write a function which returns
the first X fibonacci numbers."
    :difficulty "easy" 
    :tags ["fibonacci" "seqs"]}

   {:_id         27
    :title       "Palindrome Detector"
    :tests       ["(false? (__ '(1 2 3 4 5)))"
                  "(true? (__ \"racecar\"))"
                  "(true? (__ [:foo :bar :foo]))"
                  "(true? (__ '(1 1 3 3 1 1)))"
                  "(false? (__ '(:a :b :c)))"]
    :description "Write a function which returns true
if the given sequence is a palindrome.

Hint: \"racecar\" does not equal '(\\r \\a \\c \\e \\c \\a \\r)"
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         28
    :restricted  ["flatten"]
    :title       "Flatten a Sequence"
    :tests       ["(= (__ '((1 2) 3 [4 [5 6]])) '(1 2 3 4 5 6))"
                  "(= (__ [\"a\" [\"b\"] \"c\"]) '(\"a\" \"b\" \"c\"))"
                  "(= (__ '((((:a))))) '(:a))"]
    :description "Write a function which flattens a sequence."
    :difficulty "easy" 
    :tags ["seqs" "core-functions"]}

   {:_id         29
    :title       "Get the Caps"
    :tests       ["(= (__ \"HeLlO, WoRlD!\") \"HLOWRD\")"
                  "(empty? (__ \"nothing\"))"
                  "(= (__ \"$#A(*&987Zf\") \"AZ\")"]
    :description "Write a function which takes a string
and returns a new string containing only the capital letters."
    :difficulty "easy" 
    :tags ["strings"]}

   {:_id         30
    :title       "Compress a Sequence"
    :tests       ["(= (apply str (__ \"Leeeeeerrroyyy\")) \"Leroy\")"
                  "(= (__ [1 1 2 3 3 2 2 3]) '(1 2 3 2 3))"
                  "(= (__ [[1 2] [1 2] [3 4] [1 2]]) '([1 2] [3 4] [1 2]))"]
    :description "Write a function which removes
consecutive duplicates from a sequence."
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         31
    :title       "Pack a Sequence"
    :tests       ["(= (__ [1 1 2 1 1 1 3 3]) '((1 1) (2) (1 1 1) (3 3)))"
                  "(= (__ [:a :a :b :b :c]) '((:a :a) (:b :b) (:c)))"
                  "(= (__ [[1 2] [1 2] [3 4]]) '(([1 2] [1 2]) ([3 4])))"]
    :description "Write a function which
packs consecutive duplicates into sub-lists."
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         32
    :title       "Duplicate a Sequence"
    :tests       ["(= (__ [1 2 3]) '(1 1 2 2 3 3))"
                  "(= (__ [:a :a :b :b]) '(:a :a :a :a :b :b :b :b))"
                  "(= (__ [[1 2] [3 4]]) '([1 2] [1 2] [3 4] [3 4]))"
                  "(= (__ [44 33]) [44 44 33 33])"]
    :description "Write a function which
duplicates each element of a sequence."
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         33
    :title       "Replicate a Sequence"
    :tests       ["(= (__ [1 2 3] 2) '(1 1 2 2 3 3))"
                  "(= (__ [:a :b] 4) '(:a :a :a :a :b :b :b :b))"
                  "(= (__ [4 5 6] 1) '(4 5 6))"
                  "(= (__ [[1 2] [3 4]] 2) '([1 2] [1 2] [3 4] [3 4]))"
                  "(= (__ [44 33] 2) [44 44 33 33])"]
    :description "Write a function which replicates each
element of a sequence a variable number of times."
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         34
    :restricted  ["range"]
    :title       "Implement range"
    :tests       ["(= (__ 1 4) '(1 2 3))"
                  "(= (__ -2 2) '(-2 -1 0 1))"
                  "(= (__ 5 8) '(5 6 7))"]
    :description "Write a function which creates a list
of all integers in a given range."
    :difficulty "easy" 
    :tags ["seqs" "core-functions"]}

   {:_id         35
    :title       "Local bindings"
    :tests       ["(= __ (let [x 5] (+ 2 x)))"
                  "(= __ (let [x 3, y 10] (- y x)))"
                  "(= __ (let [x 21] (let [y 3] (/ x y))))"]
    :description "Clojure lets you give local names
to values using the special let-form."
    :difficulty "elementary" 
    :tags ["syntax"]}

   {:_id         36
    :title       "Let it Be"
    :tests       ["(= 10 (let __ (+ x y)))"
                  "(= 4 (let __ (+ y z)))"
                  "(= 1 (let __ z))"]
    :description "Can you bind x, y, and z so that these are all true?"
    :difficulty "elementary" 
    :tags ["math" "syntax"]}

   {:_id         37
    :title       "Regular Expressions"
    :tests       ["(= __ (apply str (re-seq #\"[A-Z]+\" \"bA1B3Ce \")))"]
    :description "Regex patterns are supported with a special reader macro."
    :difficulty "elementary" 
    :tags ["regex" "syntax"]}

   {:_id         38
    :restricted  ["max" "max-key"]
    :title       "Maximum value"
    :tests       ["(= (__ 1 8 3 4) 8)"
                  "(= (__ 30 20) 30)" "(= (__ 45 67 11) 67)"]
    :description "Write a function which takes a variable number
of parameters and returns the maximum value."
    :difficulty "easy" 
    :tags ["core-functions"]}

   {:_id         39
    :restricted  ["interleave"]
    :title       "Interleave Two Seqs"
    :tests       ["(= (__ [1 2 3] [:a :b :c]) '(1 :a 2 :b 3 :c))"
                  "(= (__ [1 2] [3 4 5 6]) '(1 3 2 4))"
                  "(= (__ [1 2 3 4] [5]) [1 5])"
                  "(= (__ [30 20] [25 15]) [30 25 20 15])"]
    :description "Write a function which takes two sequences
and returns the first item from each,
then the second item from each, then the third, etc."
    :difficulty "easy" 
    :tags ["seqs" "core-functions"]}

   {:_id         40
    :restricted  ["interpose"]
    :title       "Interpose a Seq"
    :tests       ["(= (__ 0 [1 2 3]) [1 0 2 0 3])"
                  "(= (apply str (__ \", \" [\"one\" \"two\" \"three\"])) \"one, two, three\")"
                  "(= (__ :z [:a :b :c :d]) [:a :z :b :z :c :z :d])"]
    :description "Write a function which separates
the items of a sequence by an arbitrary value."
    :difficulty "easy" 
    :tags ["seqs" "core-functions"]}

   {:_id         41
    :title       "Drop Every Nth Item"
    :tests       ["(= (__ [1 2 3 4 5 6 7 8] 3) [1 2 4 5 7 8])"
                  "(= (__ [:a :b :c :d :e :f] 2) [:a :c :e])"
                  "(= (__ [1 2 3 4 5 6] 4) [1 2 3 5 6])"]
    :description "Write a function which
drops every Nth item from a sequence."
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         42
    :title       "Factorial Fun"
    :tests       ["(= (__ 1) 1)"
                  "(= (__ 3) 6)"
                  "(= (__ 5) 120)"
                  "(= (__ 8) 40320)"]
    :description "Write a function which calculates factorials."
    :difficulty "easy" 
    :tags ["math"]}

   {:_id         43
    :title       "Reverse Interleave"
    :tests       ["(= (__ [1 2 3 4 5 6] 2) '((1 3 5) (2 4 6)))"
                  "(= (__ (range 9) 3) '((0 3 6) (1 4 7) (2 5 8)))"
                  "(= (__ (range 10) 5) '((0 5) (1 6) (2 7) (3 8) (4 9)))"]
    :description "Write a function which reverses the
interleave process into x number of subsequences."
    :difficulty "medium" 
    :tags ["seqs"]}

   {:_id         44
    :title       "Rotate Sequence"
    :tests       ["(= (__ 2 [1 2 3 4 5]) '(3 4 5 1 2))"
                  "(= (__ -2 [1 2 3 4 5]) '(4 5 1 2 3))"
                  "(= (__ 6 [1 2 3 4 5]) '(2 3 4 5 1))"
                  "(= (__ 1 '(:a :b :c)) '(:b :c :a))"
                  "(= (__ -4 '(:a :b :c)) '(:c :a :b))"]
    :description "Write a function which
can rotate a sequence in either direction."
    :difficulty "medium" 
    :tags ["seqs"]}

   {:_id         45
    :title       "Intro to Iterate"
    :tests       ["(= __ (take 5 (iterate #(+ 3 %) 1)))"]
    :description "The iterate function can be used to produce
an infinite lazy sequence."
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         46
    :title       "Flipping out"
    :tests       ["(= 3 ((__ nth) 2 [1 2 3 4 5]))"
                  "(= true ((__ >) 7 8))"
                  "(= 4 ((__ quot) 2 8))"
                  "(= [1 2 3] ((__ take) [1 2 3 4 5] 3))"]
    :description "Write a higher-order function which
flips the order of the arguments of an input function."
    :difficulty "medium" 
    :tags ["higher-order-functions"]}

   {:_id         47
    :title       "Contain Yourself"
    :tests       ["(contains? #{4 5 6} __)"
                  "(contains? [1 1 1 1 1] __)"
                  "(contains? {4 :a 2 :b} __)"
                  "(not (contains? [1 2 4] __))"]
    :description "The contains? function checks if a KEY
is present in a given collection.
This often leads beginner clojurians to use it incorrectly
with numerically indexed collections like vectors and lists."
    :difficulty "easy" 
    :tags []}

   {:_id         48
    :title       "Intro to some"
    :tests       ["(= __ (some #{2 7 6} [5 6 7 8]))"
                  "(= __ (some #(when (even? %) %) [5 6 7 8]))"]
    :description "The some function takes
a predicate function and a collection.
It returns the first logical true value of (predicate x)
where x is an item in the collection."
    :difficulty "easy" 
    :tags []}

   {:_id         49
    :restricted  ["split-at"]
    :title       "Split a sequence"
    :tests       ["(= (__ 3 [1 2 3 4 5 6]) [[1 2 3] [4 5 6]])"
                  "(= (__ 1 [:a :b :c :d]) [[:a] [:b :c :d]])"
                  "(= (__ 2 [[1 2] [3 4] [5 6]]) [[[1 2] [3 4]] [[5 6]]])"]
    :description "Write a function which will
split a sequence into two parts."
    :difficulty "easy" 
    :tags ["seqs" "core-functions"]}

   {:_id         50
    :title       "Split by Type"
    :tests       ["(= (set (__ [1 :a 2 :b 3 :c])) #{[1 2 3] [:a :b :c]})"
                  "(= (set (__ [:a \"foo\"  \"bar\" :b])) #{[:a :b] [\"foo\" \"bar\"]})"
                  "(= (set (__ [[1 2] :a [3 4] 5 6 :b])) #{[[1 2] [3 4]] [:a :b] [5 6]})"]
    :description "Write a function which takes
a sequence consisting of items with different types
and splits them up into a set of homogeneous sub-sequences.
The internal order of each sub-sequence should be maintained,
but the sub-sequences themselves can be returned in any order
(this is why 'set' is used in the test cases)."
    :difficulty "medium" 
    :tags ["seqs"]}

   {:_id         51
    :title       "Advanced Destructuring"
    :tests       ["(= [1 2 [3 4 5] [1 2 3 4 5]] (let [[a b & c :as d] __] [a b c d]))"]
    :description "Here is an example of some
more sophisticated destructuring."
    :difficulty "easy" 
    :tags ["destructuring"]}

   {:_id         52
    :title       "Intro to Destructuring"
    :tests       ["(= [2 4] (let [[a b c d e f g] (range)] __))"]
    :description "Let bindings and function parameter lists
support destructuring."
    :difficulty "elementary" 
    :tags ["destructuring"]}

   {:_id         53
    :title       "Longest Increasing Sub-Seq"
    :tests       ["(= (__ [1 0 1 2 3 0 4 5]) [0 1 2 3])"
                  "(= (__ [5 6 1 3 2 7]) [5 6])"
                  "(= (__ [2 3 3 4 5]) [3 4 5])"
                  "(= (__ [7 6 5 4]) [])"]
    :description "Given a vector of integers,
find the longest consecutive sub-sequence of increasing numbers.
If two sub-sequences have the same length,
use the one that occurs first.
An increasing sub-sequence must have
a length of 2 or greater to qualify."
    :difficulty "hard" 
    :tags ["seqs"]}

   {:_id         54
    :restricted  ["partition" "partition-all"]
    :title       "Partition a Sequence"
    :tests       ["(= (__ 3 (range 9)) '((0 1 2) (3 4 5) (6 7 8)))"
                  "(= (__ 2 (range 8)) '((0 1) (2 3) (4 5) (6 7)))"
                  "(= (__ 3 (range 8)) '((0 1 2) (3 4 5)))"]
    :description "Write a function which returns
a sequence of lists of x items each.
Lists of less than x items should not be returned."
    :difficulty "medium" 
    :tags ["seqs" "core-functions"]}

   {:_id         55
    :restricted  ["frequencies"]
    :title       "Count Occurences"
    :tests       ["(= (__ [1 1 2 3 2 1 1]) {1 4, 2 2, 3 1})"
                  "(= (__ [:b :a :b :a :b]) {:a 2, :b 3})"
                  "(= (__ '([1 2] [1 3] [1 3])) {[1 2] 1, [1 3] 2})"]
    :description "Write a function which returns a map
containing the number of occurences
of each distinct item in a sequence."
    :difficulty "medium" 
    :tags ["seqs" "core-functions"]}

   {:_id         56
    :restricted  ["distinct"]
    :title       "Find Distinct Items"
    :tests       ["(= (__ [1 2 1 3 1 2 4]) [1 2 3 4])"
                  "(= (__ [:a :a :b :b :c :c]) [:a :b :c])"
                  "(= (__ '([2 4] [1 2] [1 3] [1 3])) '([2 4] [1 2] [1 3]))"
                  "(= (__ (range 50)) (range 50))"]
    :description "Write a function which
removes the duplicates from a sequence.
Order of the items must be maintained."
    :difficulty "medium" 
    :tags ["seqs" "core-functions"]}

   {:_id         57
    :title       "Simple Recursion"
    :tests       ["(= __ ((fn foo [x] (when (> x 0) (conj (foo (dec x)) x))) 5))"]
    :description "A recursive function is a function which calls itself.
This is one of the fundamental techniques
used in functional programming."
    :difficulty "elementary" 
    :tags ["recursion"]}

   {:_id         58
    :restricted  ["comp"]
    :title       "Function Composition"
    :tests       ["(= [3 2 1] ((__ rest reverse) [1 2 3 4]))"
                  "(= 5 ((__ (partial + 3) second) [1 2 3 4]))"
                  "(= true ((__ zero? #(mod % 8) +) 3 5 7 9))"
                  "(= \"HELLO\" ((__ #(.toUpperCase %) #(apply str %) take) 5 \"hello world\"))"]
    :description "Write a function which
allows you to create function compositions.
The parameter list should take a variable number of functions,
and create a function applies them from right-to-left."
    :difficulty "medium" 
    :tags ["higher-order-functions" "core-functions"]}

   {:_id         59
    :restricted  ["juxt"]
    :title       "Juxtaposition"
    :tests       ["(= [21 6 1] ((__ + max min) 2 3 5 1 6 4))"
                  "(= [\"HELLO\" 5] ((__ #(.toUpperCase %) count) \"hello\"))"
                  "(= [2 6 4] ((__ :a :c :b) {:a 2, :b 4, :c 6, :d 8 :e 10}))"]
    :description "Take a set of functions and return a new function
that takes a variable number of arguments and returns a sequence
containing the result of applying each function
left-to-right to the argument list."
    :difficulty "medium" 
    :tags ["higher-order-functions" "core-functions"]}

   {:_id         60
    :restricted  ["reductions"]
    :title       "Sequence Reductions"
    :tests       ["(= (take 5 (__ + (range))) [0 1 3 6 10])"
                  "(= (__ conj [1] [2 3 4]) [[1] [1 2] [1 2 3] [1 2 3 4]])"
                  "(= (last (__ * 2 [3 4 5])) (reduce * 2 [3 4 5]) 120)"]
    :description "Write a function which behaves like reduce,
but returns each intermediate value of the reduction.
Your function must accept either two or three arguments,
and the return sequence must be lazy."
    :difficulty "medium" 
    :tags ["seqs" "core-functions"]}

   {:_id         61
    :restricted  ["zipmap"]
    :title       "Map Construction"
    :tests       ["(= (__ [:a :b :c] [1 2 3]) {:a 1, :b 2, :c 3})"
                  "(= (__ [1 2 3 4] [\"one\" \"two\" \"three\"]) {1 \"one\", 2 \"two\", 3 \"three\"})"
                  "(= (__ [:foo :bar] [\"foo\" \"bar\" \"baz\"]) {:foo \"foo\", :bar \"bar\"})"]
    :description "Write a function which takes a vector of keys
and a vector of values and constructs a map from them."
    :difficulty "easy" 
    :tags ["core-functions"]}

   {:_id         62
    :restricted  ["iterate"]
    :title       "Re-implement Iteration"
    :tests       ["(= (take 5 (__ #(* 2 %) 1)) [1 2 4 8 16])"
                  "(= (take 100 (__ inc 0)) (take 100 (range)))"
                  "(= (take 9 (__ #(inc (mod % 3)) 1)) (take 9 (cycle [1 2 3])))"]
    :description "Given a side-effect free function f
and an initial value x
write a function which returns an infinite lazy sequence
of x, (f x), (f (f x)), (f (f (f x))), etc."
    :difficulty "easy" 
    :tags ["seqs" "core-functions"]}

   {:_id         63
    :restricted  ["group-by"]
    :title       "Group a Sequence"
    :tests       ["(= (__ #(> % 5) #{1 3 6 8}) {false [1 3], true [6 8]})"
                  "(= (__ #(apply / %) [[1 2] [2 4] [4 6] [3 6]])\n   {1/2 [[1 2] [2 4] [3 6]], 2/3 [[4 6]]})"
                  "(= (__ count [[1] [1 2] [3] [1 2 3] [2 3]])\n   {1 [[1] [3]], 2 [[1 2] [2 3]], 3 [[1 2 3]]})"]
    :description "Given a function f and a sequence s,
write a function which returns a map.
The keys should be the values of f applied to each item in s.
The value at each key should be a vector
of corresponding items in the order they appear in s."
    :difficulty "easy" 
    :tags ["core-functions"]}

   {:_id         64
    :title       "Intro to Reduce"
    :tests       ["(= 15 (reduce __ [1 2 3 4 5]))"
                  "(=  0 (reduce __ []))"
                  "(=  6 (reduce __ 1 [2 3]))"]
    :description "Reduce takes a 2 argument function
and an optional starting value.
It then applies the function to the first 2 items in the sequence
(or the starting value and the first element of the sequence).
In the next iteration the function will be called on
the previous return value and the next item from the sequence,
thus reducing the entire collection to one value.
Don't worry, it's not as complicated as it sounds."
    :difficulty "elementary" 
    :tags ["seqs"]}

   {:_id         65
    :title       "Black Box Testing"
    :description "Clojure has many collection types,
which act in subtly different ways.
The core functions typically convert them into
a uniform \"sequence\" type and work with them that way,
but it can be important to understand the behavioral
and performance differences so that you know
which kind is appropriate for your application.
Write a function which takes a collection and returns one of:
map, :set, :list, or :vector -
describing the type of collection it was given.
You won't be allowed to inspect their class
or use the built-in predicates like list? -
the point is to poke at them and understand their behavior."
    :tests       ["(= :map (__ {:a 1, :b 2}))"
                  "(= :list (__ (range (rand-int 20))))"
                  "(= :vector (__ [1 2 3 4 5 6]))"
                  "(= :set (__ #{10 (rand-int 5)}))"
                  "(= [:map :set :vector :list] (map __ [{} #{} [] ()]))"]
    :restricted  ["class" "type" "Class" "vector?" "sequential?" "list?" "seq?" "map?" "set?" "instance?" "getClass"] 
    :difficulty "medium" 
    :tags ["seqs" "testing"]}

   {:_id         66
    :title       "Greatest Common Divisor"
    :tests       ["(= (__ 2 4) 2)"
                  "(= (__ 10 5) 5)"
                  "(= (__ 5 7) 1)"
                  "(= (__ 1023 858) 33)"]
    :description "Given two integers, write a function which
returns the greatest common divisor."
    :difficulty "easy" 
    :tags []}

   {:_id         67
    :title       "Prime Numbers"
    :tests       ["(= (__ 2) [2 3])"
                  "(= (__ 5) [2 3 5 7 11])"
                  "(= (last (__ 100)) 541)"]
    :description "Write a function which returns the first x
number of prime numbers."
    :difficulty "medium" 
    :tags ["primes"]}

   {:_id         68
    :title       "Recurring Theme"
    :tests       ["(= __\n  (loop [x 5\n         result []]\n    (if (> x 0)\n      (recur (dec x) (conj result (+ 2 x)))\n      result)))"]
    :description "Clojure only has one
non-stack-consuming looping construct: recur.
Either a function or a loop can be used as the recursion point.
Either way, recur rebinds the bindings
of the recursion point to the values it is passed.
Recur must be called from the tail-position,
and calling it elsewhere will result in an error."
    :difficulty "elementary" 
    :tags ["recursion"]}

   {:_id         69
    :restricted  ["merge-with"]
    :title       "Merge with a Function"
    :tests       ["(= (__ * {:a 2, :b 3, :c 4} {:a 2} {:b 2} {:c 5})\n   {:a 4, :b 6, :c 20})"
                  "(= (__ - {1 10, 2 20} {1 3, 2 10, 3 15})\n   {1 7, 2 10, 3 15})"
                  "(= (__ concat {:a [3], :b [6]} {:a [4 5], :c [8 9]} {:b [7]})\n   {:a [3 4 5], :b [6 7], :c [8 9]})"]
    :description "Write a function which takes
a function f and a variable number of maps.
Your function should return a map
that consists of the rest of the maps conj-ed onto the first.
If a key occurs in more than one map,
the mapping(s) from the latter (left-to-right)
should be combined with the mapping in the result
by calling (f val-in-result val-in-latter)"
    :difficulty "medium" 
    :tags ["core-functions"]}

   {:_id         70
    :title       "Word Sorting"
    :tests       ["(= (__  \"Have a nice day.\")\n   [\"a\" \"day\" \"Have\" \"nice\"])"
                  "(= (__  \"Clojure is a fun language!\")\n   [\"a\" \"Clojure\" \"fun\" \"is\" \"language\"])"
                  "(= (__  \"Fools fall for foolish follies.\")\n   [\"fall\" \"follies\" \"foolish\" \"Fools\" \"for\"])"]
    :description "Write a function which splits a sentence up
into a sorted list of words.
Capitalization should not affect sort order
and punctuation should be ignored."
    :difficulty "medium" 
    :tags ["sorting"]}

   {:_id         71
    :title       "Rearranging Code: ->"
    :tests       ["(= (__ (sort (rest (reverse [2 5 4 1 3 6]))))\n   (-> [2 5 4 1 3 6] reverse rest sort __)\n   5)"]
    :description "The -> macro threads an expression x through a variable number of forms.
First, x is inserted as the second item in the first form,
making a list of it if it is not a list already.
Then the first form is inserted as the second item in the second form,
making a list of that form if necessary.
This process continues for all the forms.
Using -> can sometimes make your code more readable."
    :difficulty "elementary" 
    :tags []}

   {:_id         72
    :title       "Rearranging Code: ->>"
    :tests       ["(= (__ (map inc (take 3 (drop 2 [2 5 4 1 3 6]))))\n   (->> [2 5 4 1 3 6] (drop 2) (take 3) (map inc) (__))\n   11)"]
    :description "The ->> macro threads an expression x
through a variable number of forms.
First, x is inserted as the last item in the first form,
making a list of it if it is not a list already.
Then the first form is inserted as the last item in the second form,
making a list of that form if necessary.
This process continues for all the forms.
Using ->> can sometimes make your code more readable."
    :difficulty "elementary" 
    :tags []}

   {:_id         73
    :title       "Analyze a Tic-Tac-Toe Board"
    :tests       ["(= nil (__ [[:e :e :e]\n            [:e :e :e]\n            [:e :e :e]]))"
                  "(= :x (__ [[:x :e :o]\n           [:x :e :e]\n           [:x :e :o]]))"
                  "(= :o (__ [[:e :x :e]\n           [:o :o :o]\n           [:x :e :x]]))"
                  "(= nil (__ [[:x :e :o]\n            [:x :x :e]\n            [:o :x :o]]))"
                  "(= :x (__ [[:x :e :e]\n           [:o :x :e]\n           [:o :e :x]]))"
                  "(= :o (__ [[:x :e :o]\n           [:x :o :e]\n           [:o :e :x]]))"
                  "(= nil (__ [[:x :o :x]\n            [:x :o :x]\n            [:o :x :o]]))"]
    :description "A tic-tac-toe board is represented by
a two dimensional vector.
X is represented by :x, O is represented by :o,
and empty is represented by :e.
A player wins by placing three Xs or three Os
in a horizontal, vertical, or diagonal row.
Write a function which analyzes a tic-tac-toe board
and returns :x if X has won, :o if O has won,
and nil if neither player has won."
    :difficulty "hard" 
    :tags ["game"]}

   {:_id         74
    :title       "Filter Perfect Squares"
    :tests       ["(= (__ \"4,5,6,7,8,9\") \"4,9\")"
                  "(= (__ \"15,16,25,36,37\") \"16,25,36\")"]
    :description "Given a string of comma separated integers,
write a function which returns a new comma separated string
that only contains the numbers which are perfect squares."
    :difficulty "medium" 
    :tags []}

   {:_id         75
    :title       "Euler's Totient Function"
    :tests       ["(= (__ 1) 1)"
                  "(= (__ 10) (count '(1 3 7 9)) 4)"
                  "(= (__ 40) 16)" "(= (__ 99) 60)"]
    :description "Two numbers are coprime if their
greatest common divisor equals 1.
Euler's totient function f(x) is defined as
the number of positive integers less than x which are coprime to x.
The special case f(1) equals 1.
Write a function which calculates Euler's totient function."
    :difficulty "medium" 
    :tags []}

   {:_id         76
    :title       "Intro to Trampoline"
    :tests       ["(= __\n   (letfn\n     [(foo [x y] #(bar (conj x y) y))\n      (bar [x y] (if (> (last x) 10)\n                   x\n                   #(foo x (+ 2 y))))]\n     (trampoline foo [] 1)))"]
    :description "The trampoline function takes a function f
and a variable number of parameters.
Trampoline calls f with any parameters that were supplied.
If f returns a function, trampoline
calls that function with no arguments.
This is repeated, until the return value is not a function,
and then trampoline returns that non-function value.
This is useful for implementing mutually recursive algorithms
in a way that won't consume the stack."
    :difficulty "medium" 
    :tags ["recursion"]}

   {:_id         77
    :title       "Anagram Finder"
    :tests       ["(= (__ [\"meat\" \"mat\" \"team\" \"mate\" \"eat\"])\n   #{#{\"meat\" \"team\" \"mate\"}})"
                  "(= (__ [\"veer\" \"lake\" \"item\" \"kale\" \"mite\" \"ever\"])\n   #{#{\"veer\" \"ever\"} #{\"lake\" \"kale\"} #{\"mite\" \"item\"}})"]
    :description "Write a function which
finds all the anagrams in a vector of words.
A word x is an anagram of word y if all the letters in x
can be rearranged in a different order to form y.
Your function should return a set of sets,
where each sub-set is a group of words
which are anagrams of each other.
Each sub-set should have at least two words.
Words without any anagrams should not be included in the result."
    :difficulty "medium" 
    :tags []}

   {:_id         78
    :restricted  ["trampoline"]
    :title       "Reimplement Trampoline"
    :tests       ["(= (letfn [(triple [x] #(sub-two (* 3 x)))\n          (sub-two [x] #(stop?(- x 2)))\n          (stop? [x] (if (> x 50) x #(triple x)))]\n    (__ triple 2))\n  82)"
                  "(= (letfn [(my-even? [x] (if (zero? x) true #(my-odd? (dec x))))\n          (my-odd? [x] (if (zero? x) false #(my-even? (dec x))))]\n    (map (partial __ my-even?) (range 6)))\n  [true false true false true false])"]
    :description "Reimplement the function described in <a href=\"76\"> \"Intro to Trampoline\"</a>."
    :difficulty "medium" 
    :tags ["core-functions"]}

   {:_id         79
    :title       "Triangle Minimal Path"
    :tests       ["(= (__ [   [1]\n          [2 4]\n         [5 1 4]\n        [2 3 4 5]])\n   (+ 1 2 1 3)\n   7)"
                  "(= (__ [     [3]\n            [2 4]\n           [1 9 3]\n          [9 9 2 4]\n         [4 6 6 7 8]\n        [5 7 3 5 1 4]])\n   (+ 3 4 3 2 7 1)\n   20)"]
    :description "Write a function which calculates
the sum of the minimal path through a triangle.
The triangle is represented as a vector of vectors.
The path should start at the top of the triangle
and move to an adjacent number on the next row
until the bottom of the triangle is reached."
    :difficulty "hard" 
    :tags ["graph-theory"]}

   {:_id         80
    :title       "Perfect Numbers"
    :tests       ["(= (__ 6) true)"
                  "(= (__ 7) false)"
                  "(= (__ 496) true)"
                  "(= (__ 500) false)"
                  "(= (__ 8128) true)"]
    :description "A number is \"perfect\" if the sum of its divisors
equal the number itself.
6 is a perfect number because 1+2+3=6.
Write a function which returns true for perfect numbers
and false otherwise."
    :difficulty "medium" 
    :tags []}

   {:_id         81
    :restricted  ["intersection"]
    :title       "Set Intersection"
    :tests       ["(= (__ #{0 1 2 3} #{2 3 4 5}) #{2 3})"
                  "(= (__ #{0 1 2} #{3 4 5}) #{})"
                  "(= (__ #{:a :b :c :d} #{:c :e :a :f :d}) #{:a :c :d})"]
    :description "Write a function which returns
the intersection of two sets.
The intersection is the sub-set of items
that each set has in common."
    :difficulty "easy" 
    :tags ["set-theory"]}

   {:_id         82
    :title       "Word Chains"
    :tests       ["(= true (__ #{\"hat\" \"coat\" \"dog\" \"cat\" \"oat\" \"cot\" \"hot\" \"hog\"}))"
                  "(= false (__ #{\"cot\" \"hot\" \"bat\" \"fat\"}))"
                  "(= false (__ #{\"to\" \"top\" \"stop\" \"tops\" \"toss\"}))"
                  "(= true (__ #{\"spout\" \"do\" \"pot\" \"pout\" \"spot\" \"dot\"}))"
                  "(= true (__ #{\"share\" \"hares\" \"shares\" \"hare\" \"are\"}))"
                  "(= false (__ #{\"share\" \"hares\" \"hare\" \"are\"}))"]
    :description "A word chain consists of
a set of words ordered so that each word differs
by only one letter from the words directly before and after it.
The one letter difference can be either an insertion,
a deletion, or a substitution.

Here is an example word chain:

cat -> cot -> coat -> oat -> hat -> hot -> hog -> dog

Write a function which takes a sequence of words,
and returns true if they can be
arranged into one continous word chain,
and false if they cannot."
    :difficulty "hard" 
    :tags ["seqs"]}

   {:_id         83
    :title       "A Half-Truth"
    :tests       ["(= false (__ false false))"
                  "(= true (__ true false))"
                  "(= false (__ true))"
                  "(= true (__ false true false))"
                  "(= false (__ true true true))"
                  "(= true (__ true true true false))"]
    :description "Write a function which takes
a variable number of booleans.
Your function should return true if
some of the parameters are true,
but not all of the parameters are true.
Otherwise your function should return false."
    :difficulty "easy" 
    :tags []}

   {:_id         84
    :title  "Transitive Closure"
    :tests ["(let [divides #{[8 4] [9 3] [4 2] [27 9]}]\n  (= (__ divides) #{[4 2] [8 4] [8 2] [9 3] [27 9] [27 3]}))"
            "(let [more-legs\n      #{[\"cat\" \"man\"] [\"man\" \"snake\"] [\"spider\" \"cat\"]}]\n  (= (__ more-legs)\n     #{[\"cat\" \"man\"] [\"cat\" \"snake\"] [\"man\" \"snake\"]\n       [\"spider\" \"cat\"] [\"spider\" \"man\"] [\"spider\" \"snake\"]}))"
            "(let [progeny\n      #{[\"father\" \"son\"] [\"uncle\" \"cousin\"] [\"son\" \"grandson\"]}]\n  (= (__ progeny)\n     #{[\"father\" \"son\"] [\"father\" \"grandson\"]\n       [\"uncle\" \"cousin\"] [\"son\" \"grandson\"]}))"]
    :description "Write a function which generates
the transitive closure of a binary relation.
The relation will be represented as a set of 2 item vectors.",
    :difficulty "hard" 
    :tags ["set-theory"]}

   {:_id 85 :title "Power Set"
    :tests ["(= (__ #{1 :a}) #{#{1 :a} #{:a} #{} #{1}})"
            "(= (__ #{}) #{#{}})" "(= (__ #{1 2 3})\n   #{#{} #{1} #{2} #{3} #{1 2} #{1 3} #{2 3} #{1 2 3}})"
            "(= (count (__ (into #{} (range 10)))) 1024)"],
    :description "Write a function which generates the power set of a given set.
The power set of a set x is the set of all subsets of x,
including the empty set and x itself.",
    :difficulty "medium" 
    :tags ["set-theory"]}

   {:_id 86 :title "Happy numbers"
    :tests ["(= (__ 7) true)"
            "(= (__ 986543210) true)"
            "(= (__ 2) false)" "(= (__ 3) false)"],
    :description "Happy numbers are positive integers that
follow a particular formula:
take each individual digit, square it,
and then sum the squares to get a new number.
Repeat with the new number and eventually,
you might get to a number whose squared sum is 1.
This is a happy number.
An unhappy number (or sad number) is one that loops endlessly.
Write a function that determines if a number is happy or not.",
    :difficulty "medium" 
    :tags ["math"]}

   {:_id 87 :title "Create an Equation"
    :tests ["(= (__ 3 4 7) '(= (+ 3 4) 7))" "(= (__ 3 4 12) '(= (* 3 4) 12))" "(= (__ 3 4 14) nil)" "(= (__ 3 4 5 35) '(= (* (+ 3 4) 5) 35))" "(= (__ 3 4 5 60) '(= (+ (* 3 4) 5) 60))" "(= (__ 3 4 5 23) '(= (+ 3 (* 4 5)) 23))" "(= (__ 3 4 5 27) '(= (* 3 (+ 4 5)) 27))" "(= (__ 3 4 5 6) nil)" "(= (__ 1 2 10 100 2001) '(= (+ 1 (* 2 10 100)) 2001)" "(= (__ 1 2 10 100 1300) '(= (* (+ 1 2 10) 100) 1300)"],
    :description "Write a function which takes three or more integers.
Using these integers, your function should
generate clojure code representing an equation.
The following rules for the equation must be satisfied:\n
1. All integers must be used once and only once.\n
2. The order of the integers must be
   maintained when reading the equation left-to-right.\n
3. The only functions you may use are +, *, or =.\n
4. The equation must use the minimum number of parentheses.\n
5. If no satisfying equation exists, return nil.",
    :difficulty "" 
    :tags nil}

   {:_id 88 :title "Symmetric Difference"
    :tests ["(= (__ #{1 2 3 4 5 6} #{1 3 5 7}) #{2 4 6 7})"
            "(= (__ #{:a :b :c} #{}) #{:a :b :c})"
            "(= (__ #{} #{4 5 6}) #{4 5 6})"
            "(= (__ #{[1 2] [2 3]} #{[2 3] [3 4]}) #{[1 2] [3 4]})"]
    :description "Write a function which returns
the symmetric difference of two sets.
The symmetric difference is the set of items
belonging to one but not both of the two sets." 
    :difficulty "easy" 
    :tags ["set-theory"]}

   {:_id 89 :title "Graph Tour"
    :tests ["(= true (__ [[:a :b]]))"
            "(= false (__ [[:a :a] [:b :b]]))"
            "(= false (__ [[:a :b] [:a :b] [:a :c] [:c :a]
               [:a :d] [:b :d] [:c :d]]))"
            "(= true (__ [[1 2] [2 3] [3 4] [4 1]]))"
            "(= true (__ [[:a :b] [:a :c] [:c :b] [:a :e]
              [:b :e] [:a :d] [:b :d] [:c :e]
              [:d :e] [:c :f] [:d :f]]))"
            "(= false (__ [[1 2] [2 3] [2 4] [2 5]]))"]
    :description "Starting with a graph you must write a function
that returns true if it is possible to make
a tour of the graph in which every edge is visited exactly once.

The graph is represented by a vector of tuples,
where each tuple represents a single edge.

The rules are:

- You can start at any node.
- You must visit each edge exactly once.
- All edges are undirected." 
    :difficulty "hard" 
    :tags ["graph-theory"]}

   {:_id 90 :title "Cartesian Product"
    :tests ["(= (__ #{\"ace\" \"king\" \"queen\"} #{\"♠\" \"♥\" \"♦\" \"♣\"})
   #{[\"ace\"   \"♠\"] [\"ace\"   \"♥\"] [\"ace\"   \"♦\"] [\"ace\"   \"♣\"]
     [\"king\"  \"♠\"] [\"king\"  \"♥\"] [\"king\"  \"♦\"] [\"king\"  \"♣\"]
     [\"queen\" \"♠\"] [\"queen\" \"♥\"] [\"queen\" \"♦\"] [\"queen\" \"♣\"]})"
            "(= (__ #{1 2 3} #{4 5})
   #{[1 4] [2 4] [3 4] [1 5] [2 5] [3 5]})"
            "(= 300 (count (__ (into #{} (range 10))
                  (into #{} (range 30)))))"]
    :description "Write a function which calculates
the Cartesian product of two sets." 
    :difficulty "easy" 
    :tags ["set-theory"]}

   {:_id 91 :title "Graph Connectivity"
    :tests ["(= true (__ #{[:a :a]}))"
            "(= true (__ #{[:a :b]}))"
            "(= false (__ #{[1 2] [2 3] [3 1]
               [4 5] [5 6] [6 4]}))"
            "(= true (__ #{[1 2] [2 3] [3 1]
              [4 5] [5 6] [6 4] [3 4]}))"
            "(= false (__ #{[:a :b] [:b :c] [:c :d]
               [:x :y] [:d :a] [:b :e]}))"
            "(= true (__ #{[:a :b] [:b :c] [:c :d]
              [:x :y] [:d :a] [:b :e] [:x :a]}))"]
    :description "Given a graph, determine whether the graph is connected.
A connected graph is such that
a path exists between any two given nodes.

-Your function must return true if
 the graph is connected and false otherwise.

-You will be given a set of tuples
 representing the edges of a graph.
 Each member of a tuple being a vertex/node in the graph.

-Each edge is undirected (can be traversed either direction)." 
    :difficulty "hard" 
    :tags ["graph-theory"]}

   {:_id 92 :title "Read Roman numerals"
    :tests ["(= 14 (__ \"XIV\"))"
            "(= 827 (__ \"DCCCXXVII\"))"
            "(= 3999 (__ \"MMMCMXCIX\"))"
            "(= 48 (__ \"XLVIII\"))"]
    :description "Roman numerals are easy to recognize,
but not everyone knows all the rules necessary to work with them.
Write a function to parse a Roman-numeral string
and return the number it represents.

You can assume that the input will be well-formed,
in upper-case, and follow the subtractive principle.
You don't need to handle any numbers greater than MMMCMXCIX (3999),
the largest number representable with ordinary letters." 
    :difficulty "hard" 
    :tags ["strings" "math"]}

   {:_id 93 :title "Partially Flatten a Sequence"
    :tests ["(= (__ [[\"Do\"] [\"Nothing\"]])
   [[\"Do\"] [\"Nothing\"]])"
            "(= (__ [[[[:a :b]]] [[:c :d]] [:e :f]])
   [[:a :b] [:c :d] [:e :f]])"
            "(= (__ '((1 2)((3 4)((((5 6)))))))
   '((1 2)(3 4)(5 6)))"]
    :description "Write a function which
flattens any nested combination of sequential things
(lists, vectors, etc.),
but maintains the lowest level sequential items.
The result should be a sequence of sequences
with only one level of nesting." 
    :difficulty "medium" 
    :tags ["seqs"]}

   {:_id 94 :title "Game of Life"
    :tests ["(= (__ [\"      \"
        \" ##   \"
        \" ##   \"
        \"   ## \"
        \"   ## \"
        \"      \"])
   [\"      \"
    \" ##   \"
    \" #    \"
    \"    # \"
    \"   ## \"
    \"      \"])"
            "(= (__ [\"     \"
        \"     \"
        \" ### \"
        \"     \"
        \"     \"])
   [\"     \"
    \"  #  \"
    \"  #  \"
    \"  #  \"
    \"     \"])"
            "(= (__ [\"      \"
        \"      \"
        \"  ### \"
        \" ###  \"
        \"      \"
        \"      \"])
   [\"      \"
    \"   #  \"
    \" #  # \"
    \" #  # \"
    \"  #   \"
    \"      \"])"]
    :description "The game of life is a cellular automaton
devised by mathematician John Conway.

The 'board' consists of both live (#) and dead ( ) cells.
Each cell interacts with its eight neighbours
(horizontal, vertical, diagonal),
and its next state is dependent on the following rules:

1) Any live cell with fewer than two live neighbours dies,
   as if caused by under-population.
2) Any live cell with two or three live neighbours
   lives on to the next generation.
3) Any live cell with more than three live neighbours dies,
   as if by overcrowding.
4) Any dead cell with exactly three live neighbours
   becomes a live cell, as if by reproduction.

Write a function that accepts a board,
and returns a board representing the next generation of cells." 
    :difficulty "hard" 
    :tags ["game"]}

   {:_id 95 :title "To Tree, or not to Tree"
    :tests ["(= (__ '(:a (:b nil nil) nil))
   true)"
            "(= (__ '(:a (:b nil nil)))
   false)"
            "(= (__ [1 nil [2 [3 nil nil] [4 nil nil]]])
   true)"
            "(= (__ [1 [2 nil nil] [3 nil nil] [4 nil nil]])
   false)"
            "(= (__ [1 [2 [3 [4 nil nil] nil] nil] nil])
   true)"
            "(= (__ [1 [2 [3 [4 false nil] nil] nil] nil])
   false)"
            "(= (__ '(:a nil ()))
   false)"]
    :description "Write a predicate which checks whether or not
a given sequence represents a binary tree.
Each node in the tree must have a value,
a left child, and a right child." 
    :difficulty "easy" 
    :tags ["trees"]}

   {:_id 96 :title "Beauty is Symmetry"
    :tests ["(= (__ '(:a (:b nil nil) (:b nil nil))) true)"
            "(= (__ '(:a (:b nil nil) nil)) false)"
            "(= (__ '(:a (:b nil nil) (:c nil nil))) false)"
            "(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] [5 nil nil]]] nil]])
   true)"
            "(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [5 nil nil] [6 nil nil]]] nil]])
   false)"
            "(= (__ [1 [2 nil [3 [4 [5 nil nil] [6 nil nil]] nil]]
          [2 [3 nil [4 [6 nil nil] nil]] nil]])
   false)"]
    :description "Let us define a binary tree as \"symmetric\"
if the left half of the tree is
the mirror image of the right half of the tree.
Write a predicate to determine whether or not
a given binary tree is symmetric.
(see To Tree, or not to Tree for a reminder on
the tree representation we're using)." 
    :difficulty "easy" 
    :tags ["trees"]}

   {:_id 97 :title "Pascal's Triangle"
    :tests ["(= (__ 1) [1])"
            "(= (map __ (range 1 6))
   [     [1]
        [1 1]
       [1 2 1]
      [1 3 3 1]
     [1 4 6 4 1]])"
            "(= (__ 11)
   [1 10 45 120 210 252 210 120 45 10 1])"
            "(= (__ 11)
   [1 10 45 120 210 252 210 120 45 10 1])"]
    :description "Pascal's triangle is a triangle of numbers
computed using the following rules:

- The first row is 1.
- Each successive row is computed by
  adding together adjacent numbers in the row above,
and adding a 1 to the beginning and end of the row.

Write a function which returns
:the nth row of Pascal's Triangle." 
    :difficulty "easy" 
    :tags []}

   {:_id 98 :title "Equivalence Classes"
    :tests ["(= (__ #(* % %) #{-2 -1 0 1 2})
   #{#{0} #{1 -1} #{2 -2}})"
            "(= (__ #(rem % 3) #{0 1 2 3 4 5 })
   #{#{0 3} #{1 4} #{2 5}})"
            "(= (__ identity #{0 1 2 3 4})
   #{#{0} #{1} #{2} #{3} #{4}})"
            "(= (__ (constantly true) #{0 1 2 3 4})
   #{#{0 1 2 3 4}})"]
    :description "A function f defined on a domain D
induces an equivalence relation on D, as follows:
a is equivalent to b with respect to f
if and only if (f a) is equal to (f b).
Write a function with arguments f and D
that computes the equivalence classes of D with respect to f." 
    :difficulty "medium" 
    :tags []}

   {:_id 99 :title "Product Digits"
    :tests ["(= (__ 1 1) [1])"
            "(= (__ 99 9) [8 9 1])"
            "(= (__ 999 99) [9 8 9 0 1])"]
    :description "Write a function which multiplies two numbers
and returns the result as a sequence of its digits." 
    :difficulty "easy" 
    :tags ["math" "seqs"]}

   {:_id 100 :title "Least Common Multiple"
    :tests ["(== (__ 2 3) 6)"
            "(== (__ 5 3 7) 105)"
            "(== (__ 1/3 2/5) 2)"
            "(== (__ 3/4 1/6) 3/2)"
            "(== (__ 7 5/7 2 3/5) 210)"]
    :description "Write a function which calculates
the least common multiple.
Your function should accept a variable number
of positive integers or ratios." 
    :difficulty "easy" 
    :tags ["math"]}

   {:_id 101 :title "Levenshtein Distance"
    :tests ["(= (__ \"kitten\" \"sitting\") 3)"
            "(= (__ \"closure\" \"clojure\") (__ \"clojure\" \"closure\") 1)"
            "(= (__ \"xyx\" \"xyyyx\") 2)"
            "(= (__ \"\" \"123456\") 6)"
            "(= (__ \"Clojure\" \"Clojure\") (__ \"\" \"\") (__ [] []) 0)"
            "(= (__ [1 2 3 4] [0 2 3 4 5]) 2)"
            "(= (__ '(:a :b :c :d) '(:a :d)) 2)"
            "(= (__ \"ttttattttctg\" \"tcaaccctaccat\") 10)"
            "(= (__ \"gaattctaatctc\" \"caaacaaaaaattt\") 9)"]
    :description "Given two sequences x and y,
calculate the Levenshtein distance of x and y,
i. e. the minimum number of edits needed to transform x into y.
The allowed edits are:

- insert a single item
- delete a single item
- replace a single item with another item

WARNING: Some of the test cases may timeout
if you write an inefficient solution!" 
    :difficulty "hard" 
    :tags ["seqs"]}

   {:_id 102 :title "intoCamelCase"
    :tests ["(= (__ \"something\") \"something\")"
            "(= (__ \"multi-word-key\") \"multiWordKey\")"
            "(= (__ \"leaveMeAlone\") \"leaveMeAlone\")"]
    :description "When working with java,
you often need to create an object with fieldsLikeThis,
but you'd rather work with a hashmap
that has :keys-like-this until it's time to convert.
Write a function which takes
lower-case hyphen-separated strings
and converts them to camel-case strings." 
    :difficulty "medium" 
    :tags ["strings"]}

   {:_id 103 :title "Generating k-combinations"
    :tests ["(= (__ 1 #{4 5 6}) #{#{4} #{5} #{6}})"
            "(= (__ 10 #{4 5 6}) #{})"
            "(= (__ 2 #{0 1 2}) #{#{0 1} #{0 2} #{1 2}})"
            "(= (__ 3 #{0 1 2 3 4}) #{#{0 1 2} #{0 1 3} #{0 1 4} #{0 2 3} #{0 2 4}
                                     #{0 3 4} #{1 2 3} #{1 2 4} #{1 3 4} #{2 3 4}})"
            "(= (__ 4 #{[1 2 3] :a \"abc\" \"efg\"}) #{#{[1 2 3] :a \"abc\" \"efg\"}})"
            "(= (__ 2 #{[1 2 3] :a \"abc\" \"efg\"}) #{#{[1 2 3] :a} #{[1 2 3] \"abc\"} #{[1 2 3] \"efg\"}
                                                  #{:a \"abc\"} #{:a \"efg\"} #{\"abc\" \"efg\"}}))"]
    :description "Given a sequence S consisting of n elements
generate all k-combinations of S,
i.e. generate all possible sets consisting
of k distinct elements taken from S.
The number of k-combinations for a sequence
is equal to the binomial coefficient." 
    :difficulty "medium" 
    :tags ["seqs" "combinatorics"]}

   {:_id         104
    :title       "Write Roman Numerals"
    :tests       ["(= \"I\" (__ 1))"
                  "(= \"I\" (__ 1))"
                  "(= \"XXX\" (__ 30))"
                  "(= \"IV\" (__ 4))"
                  "(= \"CXL\" (__ 140))"
                  "(= \"DCCCXXVII\" (__ 827))"
                  "(= \"MMMCMXCIX\" (__ 3999))"
                  "(= \"XLVIII\" (__ 48))"]
    :description "This is the inverse of Problem 92, but much easier.
Given an integer smaller than 4000,
return the corresponding roman numeral in uppercase,
adhering to the subtractive principle." 
    :difficulty "medium" 
    :tags ["strings" "math"]}

   {:_id         105
    :title       "Identify keys and values"
    :description "Given an input sequence of keywords and numbers,
create a map such that each key in the map is a keyword,
and the value is a sequence of all the numbers (if any)
between it and the next keyword in the sequence."
    :tests       ["(= {} (__ []))"
                  "(= {:a [1]} (__ [:a 1]))"
                  "(= {:a [1]
                         :b [2]} (__ [:a 1, :b 2]))"
                  "(= {:a [1 2 3]
                         :b []
                         :c [4]} (__ [:a 1 2 3 :b :c 4]))"] 
    :difficulty "medium" 
    :tags ["maps" "seqs"]}

   {:_id         106
    :title       "Number Maze"
    :description "Given a pair of numbers, the start and end point,
find a path between the two using only three possible operations:

1. double
2. halve (odd numbers cannot be halved)
3. add 2

Find the shortest path through the “maze”.
Because there are multiple shortest paths,
you must return the length of the shortest path, not the path itself."
    :tests       ["(= 1 (__ 1 1))"
                  "(= 3 (__ 3 12))"
                  "(= 3 (__ 12 3))"
                  "(= 3 (__ 5 9))"
                  "(= 9 (__ 9 2))"
                  "(= 5 (__ 9 12))"] 
    :difficulty "hard" 
    :tags ["numbers"]}

   {:_id         107
    :title       "Simple closures"
    :description "Lexical scope and first-class functions
are two of the most basic building blocks
of a functional language like Clojure.
When you combine the two together,
you get something very powerful called lexical closures.
With these, you can exercise a great deal
of control over the lifetime of your local bindings,
saving their values for use later,
long after the code you're running now has finished.

It can be hard to follow in the abstract,
so let's build a simple closure.
Given a positive integer n,
return a function (f x) which computes xn.
Observe that the effect of this is to preserve the value of n
for use outside the scope in which it is defined.
"
    :tests       ["(= 256 ((__ 2) 16), ((__ 8) 2))"
                  "(= [1 8 27 64] (map (__ 3) [1 2 3 4]))"
                  "(= [1 2 4 8 16] (map #((__ %) 2) [0 1 2 3 4]))"] 
    :difficulty "easy" 
    :tags ["higher-order-functions" "math"]}

   {:_id         108
    :title       "Lazy Searching"
    :description "Given any number of sequences,
each sorted from smallest to largest,
find the smallest single number
which appears in all of the sequences.
The sequences may be infinite, so be careful to search lazily."
    :tests       ["(= 3 (__ [3 4 5]))"
                  "(= 4 (__ [1 2 3 4 5 6 7] [0.5 3/2 4 19]))"
                  "(= 64 (__ (map #(* % % %) (range))
                                 (filter #(zero? (bit-and % (dec %))) (range))
                                 (iterate inc 20)))"
                  "(= 7 (__ (range) (range 0 100 7/6) [2 3 5 7 11 13]))"] 
    :difficulty "medium" 
    :tags ["seqs" "sorting"]}

   {:_id         110
    :title       "Sequence of pronunciations"
    :description "Write a function that returns
a lazy sequence of \"pronunciations\" of a sequence of numbers.
A pronunciation of each element in the sequence
consists of the number of repeating identical numbers
and the number itself.
For example, [1 1] is pronounced as [2 1] (\"two ones\"),
which in turn is pronounced as [1 2 1 1] (\"one two, one one\") .
Your function should accept an initial sequence of numbers,
and return an infinite lazy sequence of pronunciations,
each element being a pronunciation of the previous element."
    :tests       ["(= [[1 1] [2 1] [1 2 1 1]] (take 3 (__ [1])))"
                  "(= [3 1 2 4] (first (__[1 1 1 4 4])))"
                  "(= [1 1 1 3 2 1 3 2 1 1] (nth (__ [1]) 6))"
                  "(= 338 (count (nth (__ [3 2]) 15)))"] 
    :difficulty "medium" 
    :tags ["seqs"]}

   {:_id         111
    :title       "Crossword puzzle"
    :description "Write a function that takes a string
and a partially-filled crossword puzzle board,
and determines if the input string
can be legally placed onto the board.

The crossword puzzle board consists of
a collection of partially-filled rows.
Empty spaces are denoted with an underscore (_),
unusable spaces are denoted with a hash symbol (#),
and pre-filled spaces have a character in place;
the whitespace characters are for legibility and should be ignored.

For a word to be legally placed on the board:

It may use empty spaces (underscores)
It may use but must not conflict with any pre-filled characters.
It must not use any unusable spaces (hashes).
There must be no empty spaces (underscores) or extra characters
before or after the word (the word may be
bound by unusable spaces though).
Characters are not case-sensitive.
Words may be placed vertically (proceeding top-down only),
or horizontally (proceeding left-right only)."
    :tests       ["(= true  (__ \"the\" [\"_ # _ _ e\"]))"
                  "(= false (__ \"the\" [\"c _ _ _\"                    \"d _ # e\"                    \"r y _ _\"]))"
                  "(= true  (__ \"joy\" [\"c _ _ _\"                    \"d _ # e\"                    \"r y _ _\"]))"
                  "(= false (__ \"joy\" [\"c o n j\"                    \"_ _ y _\"                    \"r _ _ #\"]))"
                  "(= true  (__ \"clojure\" [\"_ _ _ # j o y\"
                                          \"_ _ o _ _ _ _\"
                                           \"_ _ f _ # _ _\"]))"] 
    :difficulty "hard" 
    :tags ["game"]}

   {:_id         112
    :title       "Sequs Horribilis"
    :description "Create a function which takes
an integer and a nested collection of integers as arguments.
Analyze the elements of the input collection
and return a sequence which maintains the nested structure,
and which includes all elements starting from
the head whose sum is less than or equal to the input integer."
    :tests       ["(=  (__ 10 [1 2 [3 [4 5] 6] 7])    '(1 2 (3 (4))))"
                  "(=  (__ 30 [1 2 [3 [4 [5 [6 [7 8]] 9]] 10] 11])    '(1 2 (3 (4 (5 (6 (7)))))))"
                  "(=  (__ 9 (range))    '(0 1 2 3))"
                  "(=  (__ 1 [[[[[1]]]]])    '(((((1))))))"
                  "(=  (__ 0 [1 2 [3 [4 5] 6] 7])    '())"
                  "(=  (__ 0 [0 0 [0 [0]]])    '(0 0 (0 (0))))"
                  "(=  (__ 1 [-10 [1 [2 3 [4 5 [6 7 [8]]]]]])
                        '(-10 (1 (2 3 (4)))))"] 
    :difficulty "medium" 
    :tags ["seqs"]}

   {:_id         114
    :title       "Global take-while"
    :description "take-while is great for
filtering sequences, but it limited:
you can only examine a single item of the sequence at a time.
What if you need to keep track of
some state as you go over the sequence?

Write a function which accepts an integer n,
a predicate p, and a sequence.
It should return a lazy sequence of items in the list up to,
but not including, the nth item that satisfies the predicate."
    :tests       ["(= [2 3 5 7 11 13]
                       (__ 4 #(= 2 (mod % 3))
                            [2 3 5 7 11 13 17 19 23]))"
                  "(= [\"this\" \"is\" \"a\" \"sentence\"]
                       (__ 3 #(some #{\\i} %)
                            [\"this\" \"is\" \"a\" \"sentence\" \"i\" \"wrote\"]))"
                  "(= [\"this\" \"is\"]
                       (__ 1 #{\"a\"}
                            [\"this\" \"is\" \"a\" \"sentence\" \"i\" \"wrote\"]))"] 
    :difficulty "medium" 
    :tags ["seqs" "higher-order-functions"]}

   {:_id         115
    :title       "The Balance of N"
    :description "A balanced number is one whose component digits
have the same sum on the left and right halves of the number.
Write a function which accepts an integer n,
and returns true iff n is balanced."
    :tests       ["(= true (__ 11))"
                  "(= true (__ 121))"
                  "(= false (__ 123))"
                  "(= true (__ 0))"
                  "(= false (__ 88099))"
                  "(= true (__ 89098))"
                  "(= true (__ 89089))"
                  "(= (take 20 (filter __ (range)))
                       [0 1 2 3 4 5 6 7 8 9 11 22 33 44 55 66 77 88 99 101])"] 
    :difficulty "medium" 
    :tags ["math"]}

   {:_id         116
    :title       "Prime Sandwich"
    :description "A balanced prime is a prime number which is
also the mean of the primes directly before
and after it in the sequence of valid primes.
Create a function which takes an integer n,
and returns true iff it is a balanced prime."
    :tests ["(= false (__ 4))"
            "(= true (__ 563))"
            "(= 1103 (nth (filter __ (range)) 15))"] 
    :difficulty "medium" 
    :tags ["math"]}

   {:_id         117
    :title       "For Science!"
    :description "A mad scientist with tenure has created
an experiment tracking mice in a maze.
Several mazes have been randomly generated,
and you’ve been tasked with writing a program to determine
the mazes in which it’s possible for the mouse
to reach the cheesy endpoint.
Write a function which accepts a maze
in the form of a collection of rows,
each row is a string where:

* spaces represent areas where the mouse can walk freely
* hashes (#) represent walls where the mouse can not walk
* M represents the mouse’s starting point
* C represents the cheese which the mouse must reach
* The mouse is not allowed to travel diagonally
in the maze (only up/down/left/right),
nor can he escape the edge of the maze.
Your function must return true
iff the maze is solvable by the mouse."
    :tests       ["(= true  (__ [\"M   C\"]))"
                  "(= false (__ [\"M # C\"]))"
                  "(= true  (__ [\"#######\"
                                \"#     #\"
                                \"#  #  #\"
                                \"#M # C#\"
                                \"#######\"]))"
                  "(= false (__ [\"########\"
                                \"#M  #  #\"
                                \"#   #  #\"
                                \"# # #  #\"
                                \"#   #  #\"
                                \"#  #   #\"
                                \"#  # # #\"
                                \"#  #   #\"
                                \"#  #  C#\"
                                \"########\"]))"
                  "(= false (__ [\"M     \"
                                \"      \"
                                \"      \"
                                \"      \"
                                \"    ##\"
                                \"    #C\"]))"
                  "(= true  (__ [\"C######\"
                                \" #     \"
                                \" #   # \"
                                \" #   #M\"
                                \"     # \"]))"
                  "(= true  (__ [\"C# # # #\"
                                \"        \"
                                \"# # # # \"
                                \"        \"
                                \" # # # #\"
                                \"        \"
                                \"# # # #M\"]))"] 
    :difficulty "hard" 
    :tags ["game"]}
   {:_id         118
    :title       "Re-implement Map"
    :description "Map is one of the core elements
of a functional programming language.
Given a function f and an input sequence s,
return a lazy sequence of (f x) for each element x in s."
    :tests       ["(= [3 4 5 6 7]
                       (__ inc [2 3 4 5 6]))"
                  "(= (repeat 10 nil)
                       (__ (fn [_] nil) (range 10)))"
                  "(= [1000000 1000001]
                       (->> (__ inc (range))
                            (drop (dec 1000000))
                            (take 2)))"
                  "(= [1000000 1000001]
                       (->> (__ inc (range))
                            (drop (dec 1000000))
                            (take 2)))"] 
    :difficulty "easy" 
    :tags ["core-seqs"]}

   {:_id         119
    :title       "Win at Tic-Tac-Toe"
    :description "As in Problem 73, a tic-tac-toe board
is represented by a two dimensional vector.
X is represented by :x, O is represented by :o,
and empty is represented by :e.
Create a function that accepts a game piece and board as arguments,
and returns a set (possibly empty) of all valid board placements
of the game piece which would result in an immediate win.

Board coordinates should be as in calls to get-in.
For example, [0 1] is the topmost row, center position."
    :tests       ["(is (= (__ :x [[:o :e :e]
                               [:o :x :o]
                               [:x :x :e]])
                      #{[2 2] [0 1] [0 2]}))"
                  "(is (= (__ :x [[:x :o :o]
                               [:x :x :e]
                               [:e :o :e]])
                      #{[2 2] [1 2] [2 0]}))"
                  "(is (= (__ :x [[:x :e :x]
                               [:o :x :o]
                               [:e :o :e]])
                      #{[2 2] [0 1] [2 0]}))"
                  "(is (= (__ :x [[:x :x :o]
                               [:e :e :e]
                               [:e :e :e]])
                      #{}))"
                  "(is (= (__ :o [[:x :x :o]
                               [:o :e :o]
                               [:x :e :e]])
                      #{[2 2] [1 1]}))"] 
    :difficulty "hard" 
    :tags ["game"]}

   {:_id         120
    :title       "Sum of square of digits"
    :description "Write a function which takes
a collection of integers as an argument.
Return the count of how many elements are smaller than
the sum of their squared component digits.
For example: 10 is larger than 1 squared plus 0 squared;
whereas 15 is smaller than 1 squared plus 5 squared."
    :tests       ["(= 8 (__ (range 10)))"
                  "(= 19 (__ (range 30)))"
                  "(= 50 (__ (range 100)))"
                  "(= 50 (__ (range 1000)))"] 
    :difficulty "easy" 
    :tags ["math"]}

   {:_id         121
    :title       "Universal Computation Engine"
    :description "Given a mathematical formula in prefix notation,
return a function that calculates the value of the formula.
The formula can contain nested calculations using
the four basic mathematical operators, numeric constants,
and symbols representing variables.
The returned function has to accept a single parameter
containing the map of variable names to their values."
    :tests       ["(= 2 ((__ '(/ a b))
                         '{b 8
                           a 16}))"
                  "(= 8 ((__ '(+ a b 2))
                         '{a 2
                           b 4}))"
                  "(= [6 0 -4]
                      (map (__ '(* (+ 2 a)
                                    (- 10 b)))
                           '[{a 1
                              b 8}
                             {b 5
                              a -2}
                             {a 2
                              b 11}]))"
                  "(= 1 ((__ '(/ (+ x 2)
                                  (* 3 (+ y 1))))
                         '{x 4
                           y 1}))"] 
    :difficulty "medium" 
    :tags ["functions"]}

   {:_id         122
    :title       "Read a binary number"
    :description "Convert a binary number,
provided in the form of a string,
to its numerical value."
    :tests       ["(= 0     (__ \"0\"))"
                  "(= 7     (__ \"111\"))"
                  "(= 8     (__ \"1000\"))"
                  "(= 9     (__ \"1001\"))"
                  "(= 255   (__ \"11111111\"))"
                  "(= 1365  (__ \"10101010101\"))"
                  "(= 65535 (__ \"1111111111111111\"))"] 
    :difficulty "easy" 
    :tags []}

   {:_id         124
    :title       "Analyze Reversi"
    :description "Reversi is normally played on an 8 by 8 board.
In this problem, a 4 by 4 board is represented
as a two-dimensional vector
with black, white, and empty pieces represented
by ‘b, ‘w, and ‘e, respectively.
Create a function that accepts
a game board and color as arguments,
and returns a map of legal moves for that color.
Each key should be the coordinates of a legal move,
and its value a set of the coordinates
of the pieces flipped by that move.

Board coordinates should be as in calls to get-in.
For example, [0 1] is the topmost row,
second column from the left."
    :tests       ["(= {[1 3] #{[1 2]}
                       [0 2] #{[1 2]}
                       [3 1] #{[2 1]}
                       [2 0] #{[2 1]}}
                      (__ '[[e e e e]
                                 [e w b e]
                                 [e b w e]
                                 [e e e e]] 'w))"
                  "(= {[3 2] #{[2 2]}
                       [3 0] #{[2 1]}
                       [1 0] #{[1 1]}}
                      (__ '[[e e e e]
                                 [e w b e]
                                 [w w w e]
                                 [e e e e]] 'b))"
                  "(= {[0 3] #{[1 2]}
                       [1 3] #{[1 2]}
                       [3 3] #{[2 2]}
                       [2 3] #{[2 2]}}
                      (__ '[[e e e e]
                                 [e w b e]
                                 [w w b e]
                                 [e e b e]] 'w))"
                  "(= {[0 3] #{[2 1] [1 2]}
                       [1 3] #{[1 2]}
                       [2 3] #{[2 1] [2 2]}}
                      (__ '[[e e w e]
                                 [b b w e]
                                 [b w w e]
                                 [b w w w]] 'b))"
                  "(= {[0 3] #{[2 1] [1 2]}
                       [1 3] #{[1 2]}
                       [2 3] #{[2 1] [2 2]}}
                      (__ '[[e e w e]
                                 [b b w e]
                                 [b w w e]
                                 [b w w w]] 'b))"] 
    :difficulty "hard" 
    :tags ["game"]}

   {:_id         125
    :title       "Gus' Quinundrum"
    :description "Create a function of no arguments
which returns a string that is
an exact copy of the function itself.

Hint: Read up on quines if you get stuck
(this question is harder than it first appears);
but it’s worth the effort to solve it independently if you can!

Fun fact: Gus is the name of the 4Clojure dragon."
    :tests       ["(= (__ '(fn [x] (__ x x))
                            '(fn [x] (__ x x)))
                       ((fn [x] (__ x x))
                        '(fn [x] (__ x x))))"] 
    :difficulty "hard" 
    :tags ["logic" "fun" "brain-teaser"]}

   {:_id         126
    :title       "Through the Looking Class"
    :description "Enter a value which satisfies the following:"
    :tests       ["(let [x __]
                     (and (= (class x) x) x))"]
    :difficulty "easy" 
    :tags ["fun" "brain-teaser"]}

   {:_id         127
    :title       "Love Triangle"
    :description "Everyone loves triangles,
and it’s easy to understand why —
they’re so wonderfully symmetric
(except scalenes, they suck).

Your passion for triangles has led you to become a miner
(and part-time Clojure programmer) where you work all day
to chip out isosceles-shaped minerals from rocks
gathered in a nearby open-pit mine.
There are too many rocks coming from the mine to harvest them all
so you’ve been tasked with writing a program
to analyze the mineral patterns of each rock,
and determine which rocks have the biggest minerals.

Someone has already written a computer-vision system for the mine.
It images each rock as it comes into the processing centre
and creates a cross-sectional bitmap of mineral (1)
and rock (0) concentrations for each one.

You must now create a function which
accepts a collection of integers,
each integer when read in base-2
gives the bit-representation of the rock
(again, 1s are mineral and 0s are worthless scalene-like rock).
You must return the cross-sectional area of
the largest harvestable mineral from the input rock, as follows:

The minerals only have smooth faces when
sheared vertically or horizontally from the rock’s cross-section
The mine is only concerned with harvesting
isosceles triangles (such that one or two sides can be sheared)
If only one face of the mineral is sheared,
its opposing vertex must be a point
(ie. the smooth face must be of odd length),
and its two equal-length sides must intersect
the shear face at 45° (ie. those sides must cut even-diagonally)
The harvested mineral may not contain any traces of rock
The mineral may lie in any orientation in the plane
Area should be calculated as the sum of 1s that comprise the mineral
Minerals must have a minimum of three measures of area to be harvested
If no minerals can be harvested from the rock,
your function should return nil"
    :tests       ["(= 10 (__ [15 15 15 15 15]))"
                                        ; 1111      1111
                                        ; 1111      *111
                                        ; 1111  ->  **11
                                        ; 1111      ***1
                                        ; 1111      ****
                  "(= 15 (__ [1 3 7 15 31]))"
                                        ; 00001      0000*
                                        ; 00011      000**
                                        ; 00111  ->  00***
                                        ; 01111      0****
                                        ; 11111      *****
                  "(= 3 (__ [3 3]))"
                                        ; 11      *1
                                        ; 11  ->  **
                  "(= 4 (__ [7 3]))"
                                        ; 111      ***
                                        ; 011  ->  0*1
                  "(= 6 (__ [17 22 6 14 22]))"
                                        ; 10001      10001
                                        ; 10110      101*0
                                        ; 00110  ->  00**0
                                        ; 01110      0***0
                                        ; 10110      10110
                  "(= 9 (__ [18 7 14 14 6 3]))"
                                        ; 10010      10010
                                        ; 00111      001*0
                                        ; 01110      01**0
                                        ; 01110  ->  0***0
                                        ; 00110      00**0
                                        ; 00011      000*1
                  "(= nil (__ [21 10 21 10]))"
                                        ; 10101      10101
                                        ; 01010      01010
                                        ; 10101  ->  10101
                                        ; 01010      01010
                  "(= nil (__ [0 31 0 31 0]))"
                                        ; 00000      00000
                                        ; 11111      11111
                                        ; 00000  ->  00000
                                        ; 11111      11111
                                        ; 00000      00000
                  ] 
    :difficulty "hard" 
    :tags ["search" "data-juggling"]}

   {:_id         128
    :title       "Recognize Playing Cards"
    :description "A standard American deck of playing cards has four suits - spades,
hearts, diamonds, and clubs - and thirteen cards in each suit. Two is the lowest rank,
followed by other integers up to ten; then the jack, queen, king, and ace.

It's convenient for humans to represent these cards as suit/rank pairs, such as H5 or DQ:
the heart five and diamond queen respectively. But these forms are not convenient for
programmers, so to write a card game you need some way to parse an input string into
meaningful components. For purposes of determining rank, we will define the cards to
be valued from 0 (the two) to 12 (the ace)

Write a function which converts (for example) the string \"SJ\" into a map of
{:suit :spade,:rank 9}. A ten will always be represented with the single character
\"T\", rather than the two characters \"10\"."
    :tests       ["(= {:suit :diamond :rank 10} (__ \"DQ\"))"
                  "(= {:suit :heart :rank 3} (__ \"H5\"))"
                  "(= {:suit :club :rank 12} (__ \"CA\"))"
                  "(= (range 13) (map (comp :rank __ str)
                                      '[S2 S3 S4 S5 S6 S7
                                        S8 S9 ST SJ SQ SK SA]))"]
    :difficulty "easy" 
    :tags ["strings" "game"]}

   {:_id         131
    :title       "Sum Some Set Subsets"
    :description "Given a variable number of sets of integers, create
a function which returns true iff all of the sets have a non-empty
subset with an equivalent summation."
    :tests       ["(= true (__ #{-1 1 99}
                              #{-2 2 888}
                              #{-3 3 7777}))"
                  "(= false (__ #{1}
                                #{2}
                                #{3}
                                #{4}))"
                  "(= true  (__ #{1}))"
                  "(= false (__ #{1 -3 51 9}
                                #{0}
                                #{9 2 81 33}))"
                  "(= true  (__ #{1 3 5}
                                #{9 11 4}
                                #{-3 12 3}
                                #{-3 4 -2 10}))"
                  "(= false (__ #{-1 -2 -3 -4 -5 -6}
                                #{1 2 3 4 5 6 7 8 9}))"
                  "(= true  (__ #{1 3 5 7}
                                #{2 4 6 8}))"
                  "(= true  (__ #{-1 3 -5 7 -9 11 -13 15}
                                #{1 -3 5 -7 9 -11 13 -15}
                                #{1 -1 2 -2 4 -4 8 -8}))"
                  "(= true  (__ #{-10 9 -8 7 -6 5 -4 3 -2 1}
                                #{10 -9 8 -7 6 -5 4 -3 2 -1}))"]
    :difficulty "medium" 
    :tags ["math"]}

   {:_id         132
    :title       "Intervals"
    :description "Write a function that takes a two-argument predicate,
a value, and a collection; and returns a new collection where the value
is inserted between every two items that satisfy the predicate."
    :tests       ["(= '(1 :less 6 :less 7 4 3) (__ < :less [1 6 7 4 3]))"
                  "(= '(2) (__ > :more [2]))"
                  "(= [0 1 :x 2 :x 3 :x 4]  (__ #(and (pos? %) (< % %2)) :x (range 5)))"
                  "(empty? (__ > :more ()))"
                  "(= [0 1 :same 1 2 3 :same 5 8 13 :same 21]
                      (take 12 (->> [0 1]
                                    (iterate (fn [[a b]] [b (+ a b)]))
                                    (map first) ; fibonacci numbers
                                    (__ (fn [a b] ; both even or both odd
                                          (= (mod a 2) (mod b 2)))
                                        :same))))"]
    :difficulty "medium" 
    :tags ["seqs" "core-functions"]}

   {:_id         134
    :title       "A nil key"
    :description "Write a function which, given a key and map, returns true iff
the map contains an entry with that key and its value is nil."
    :tests       ["(true?  (__ :a {:a nil :b 2}))"
                  "(false? (__ :b {:a nil :b 2}))"
                  "(false? (__ :c {:a nil :b 2}))"]
    :difficulty "elementary" 
    :tags ["maps"]}

   {:_id         135
    :title       "Infix Calculator"
    :description "Your friend Joe is always whining about Lisps using the prefix
notation for math. Show him how you could easily write a function that does math
using the infix notation. Is your favorite language that flexible, Joe? Write a
function that accepts a variable length mathematical expression consisting of
numbers and the operations +, -, *, and /. Assume a simple calculator that does
not do precedence and instead just calculates left to right."
    :tests       ["(= 7  (__ 2 + 5))"
                  "(= 42 (__ 38 + 48 - 2 / 2))"
                  "(= 8  (__ 10 / 2 - 1 * 2))"
                  "(= 72 (__ 20 / 2 + 2 + 4 + 8 - 6 - 10 * 9))"]
    :difficulty "easy" 
    :tags ["higher-order-functions" "math"]}

   {:_id         137
    :title       "Digits and bases"
    :description "Write a function which returns a sequence of digits
of a non-negative number (first argument)
in numerical system with an arbitrary base (second argument).
Digits should be represented with their integer values,
e.g. 15 would be [1 5] in base 10,
[1 1 1 1] in base 2 and [15] in base 16."
    :tests       ["(= [1 2 3 4 5 0 1] (__ 1234501 10))"
                  "(= [0] (__ 0 11))"
                  "(= [1 0 0 1] (__ 9 2))"
                  "(= [1 0] (let [n (rand-int 100000)] (__ n n)))"
                  "(= [16 18 5 24 15 1] (__ Integer/MAX_VALUE 42))"] 
    :difficulty "medium" 
    :tags ["math"]}

   {:_id         140
    :title       "Veitch, Please!"
    :description "Create a function which accepts as input
a boolean algebra function in the form of a set of sets,
where the inner sets are collections of symbols corresponding
to the input boolean variables which satisfy the function
(the inputs of the inner sets are conjoint,
and the sets themselves are disjoint…
also known as canonical minterms).
Note: capitalized symbols represent truth,
and lower-case symbols represent negation of the inputs.
Your function must return the minimal function
which is logically equivalent to the input.

PS — You may want to read about K-Maps before proceeding."
    :tests       ["(= (__ #{#{'a 'B 'C 'd}
                                #{'A 'b 'c 'd}
                                #{'A 'b 'c 'D}
                                #{'A 'b 'C 'd}
                                #{'A 'b 'C 'D}
                                #{'A 'B 'c 'd}
                                #{'A 'B 'c 'D}
                                #{'A 'B 'C 'd}})
                      #{#{'A 'c}
                        #{'A 'b}
                        #{'B 'C 'd}})"
                  "(= (__ #{#{'A 'B 'C 'D}
                                #{'A 'B 'C 'd}})
                      #{#{'A 'B 'C}})"
                  "(= (__ #{#{'a 'b 'c 'd}
                                #{'a 'B 'c 'd}
                                #{'a 'b 'c 'D}
                                #{'a 'B 'c 'D}
                                #{'A 'B 'C 'd}
                                #{'A 'B 'C 'D}
                                #{'A 'b 'C 'd}
                                #{'A 'b 'C 'D}})
                      #{#{'a 'c}
                        #{'A 'C}})"
                  "(= (__ #{#{'a 'b 'c}
                                #{'a 'B 'c}
                                #{'a 'b 'C}
                                #{'a 'B 'C}})
                      #{#{'a}})"
                  "(= (__ #{#{'a 'B 'c 'd}
                                #{'A 'B 'c 'D}
                                #{'A 'b 'C 'D}
                                #{'a 'b 'c 'D}
                                #{'a 'B 'C 'D}
                                #{'A 'B 'C 'd}})
                      #{#{'a 'B 'c 'd}
                        #{'A 'B 'c 'D}
                        #{'A 'b 'C 'D}
                        #{'a 'b 'c 'D}
                        #{'a 'B 'C 'D}
                        #{'A 'B 'C 'd}})"
                  "(= (__ #{#{'a 'b 'c 'd}
                                #{'a 'B 'c 'd}
                                #{'A 'B 'c 'd}
                                #{'a 'b 'c 'D}
                                #{'a 'B 'c 'D}
                                #{'A 'B 'c 'D}})
                      #{#{'a 'c}
                        #{'B 'c}})"
                  "(= (__ #{#{'a 'B 'c 'd}
                                #{'A 'B 'c 'd}
                                #{'a 'b 'c 'D}
                                #{'a 'b 'C 'D}
                                #{'A 'b 'c 'D}
                                #{'A 'b 'C 'D}
                                #{'a 'B 'C 'd}
                                #{'A 'B 'C 'd}})
                      #{#{'B 'd}
                        #{'b 'D}})"
                  "(= (__ #{#{'a 'b 'c 'd}
                                #{'A 'b 'c 'd}
                                #{'a 'B 'c 'D}
                                #{'A 'B 'c 'D}
                                #{'a 'B 'C 'D}
                                #{'A 'B 'C 'D}
                                #{'a 'b 'C 'd}
                                #{'A 'b 'C 'd}})
                      #{#{'B 'D}
                        #{'b 'd}})"
                  "(= (__ #{#{'a 'b 'c 'd}
                                #{'A 'b 'c 'd}
                                #{'a 'B 'c 'D}
                                #{'A 'B 'c 'D}
                                #{'a 'B 'C 'D}
                                #{'A 'B 'C 'D}
                                #{'a 'b 'C 'd}
                                #{'A 'b 'C 'd}})
                      #{#{'B 'D}
                        #{'b 'd}})"] 
    :difficulty "hard" 
    :tags ["math" "circuit-design"]}

   {:_id         141
    :title       "Tricky card games"
    :description "In trick-taking card games such as bridge, spades,
or hearts, cards are played in groups known as \"tricks\" - each player
plays a single card, in order; the first player is said to \"lead\" to
the trick. After all players have played, one card is said to have \"won\"
the trick. How the winner is determined will vary by game, but generally
the winner is the highest card played in the suit that was led. Sometimes
(again varying by game), a particular suit will be designated \"trump\",
meaning that its cards are more powerful than any others: if there is a
trump suit, and any trumps are played, then the highest trump wins
regardless of what was led.

Your goal is to devise a function that can determine which of a number of
cards has won a trick. You should accept a trump suit, and return a function
winner. Winner will be called on a sequence of cards, and should return the
one which wins the trick. Cards will be represented in the format returned
by Problem 128, Recognize Playing Cards: a hash-map of :suit and a numeric
:rank. Cards with a larger rank are stronger."
    :tests       ["(let [notrump (__ nil)]
                     (and (= {:suit :club :rank 9}  (notrump [{:suit :club :rank 4}
                                                              {:suit :club :rank 9}]))
                          (= {:suit :spade :rank 2} (notrump [{:suit :spade :rank 2}
                                                              {:suit :club :rank 10}]))))"
                  "(= {:suit :club :rank 10} ((__ :club) [{:suit :spade :rank 2}
                                                          {:suit :club :rank 10}]))"
                  "(= {:suit :heart :rank 8}
                      ((__ :heart) [{:suit :heart :rank 6} {:suit :heart :rank 8}
                                    {:suit :diamond :rank 10} {:suit :heart :rank 4}]))"]
    :difficulty "medium" 
    :tags ["game" "cards"]}

   {:_id         143
    :title       "dot product"
    :description "Create a function that computes the dot product of two sequences.
You may assume that the vectors will have the same length."
    :tests       ["(= 0 (__ [0 1 0] [1 0 0]))"
                  "(= 3 (__ [1 1 1] [1 1 1]))"
                  "(= 32 (__ [1 2 3] [4 5 6]))"
                  "(= 256 (__ [2 5 6] [100 10 1]))"]
    :difficulty "easy" 
    :tags ["seqs" "math"]}

   {:_id         144
    :title       "Oscilrate"
    :description "Write an oscillating iterate: a function that takes
an initial value and a variable number of functions. It should return
a lazy sequence of the functions applied to the value in order, restarting
from the first function after it hits the end."
    :tests       ["(= (take 3 (__ 3.14 int double)) [3.14 3 3.0])"
                  "(= (take 5 (__ 3 #(- % 3) #(+ 5 %))) [3 0 5 2 7])"
                  "(= (take 12 (__ 0 inc dec inc dec inc)) [0 1 0 1 0 1 2 1 2 1 2 3])"]
    :difficulty "medium" 
    :tags ["sequences"]}

   {:_id         145
    :title       "For the win"
    :description "Clojure's for macro is a tremendously versatile mechanism for
producing a sequence based on some other sequence(s). It can take some time to
understand how to use it properly, but that investment will be paid back with
clear, concise sequence-wrangling later. With that in mind, read over these for
expressions and try to see how each of them produces the same result."
    :tests       ["(= __ (for [x (range 40)
                               :when (= 1 (rem x 4))]
                           x))"
                  "(= __ (for [x (iterate #(+ 4 %) 0)
                               :let [z (inc x)]
                               :while (< z 40)]
                           z))"
                  "(= __ (for [[x y] (partition 2 (range 20))]
                           (+ x y)))"]
    :difficulty "elementary" 
    :tags ["core-functions" "seqs"]}

   {:_id         146
    :title       "Trees into tables"
    :description "Because Clojure's for macro allows you to \"walk\" over multiple
sequences in a nested fashion, it is excellent for transforming all sorts of
sequences. If you don't want a sequence as your final output (say you want a map),
you are often still best-off using for, because you can produce a sequence and feed
it into a map, for example.

For this problem, your goal is to \"flatten\" a map of hashmaps. Each key in your
output map should be the \"path\" (1) that you would have to take in the original
map to get to a value, so for example {1 {2 3}} should result in {[1 2] 3}. You
only need to flatten one level of maps: if one of the values is a map, just leave
it alone.

(1) That is, (get-in original [k1 k2]) should be the same as (get result [k1 k2])"
    :tests       ["(= (__ '{a {p 1, q 2}
                            b {m 3, n 4}})
                      '{[a p] 1, [a q] 2
                        [b m] 3, [b n] 4})"
                  "(= (__ '{[1] {a b c d}
                            [2] {q r s t u v w x}})
                      '{[[1] a] b, [[1] c] d,
                        [[2] q] r, [[2] s] t,
                        [[2] u] v, [[2] w] x})"
                  "(= (__ '{m {1 [a b c] 3 nil}})
                      '{[m 1] [a b c], [m 3] nil})"]
    :difficulty "easy" 
    :tags ["seqs" "maps"]}

   {:_id         147
    :title       "Pascal's Trapezoid"
    :description "Write a function that, for any given input vector of numbers, returns
an infinite lazy sequence of vectors, where each next one is constructed from the
previous following the rules used in Pascal's Triangle. For example, for [3 1 2], the
next row is [3 4 3 2].

Beware of arithmetic overflow! In clojure (since version 1.3 in 2011), if you use an
arithmetic operator like + and the result is too large to fit into a 64-bit integer,
an exception is thrown. You can use +' to indicate that you would rather overflow into
Clojure's slower, arbitrary-precision bigint."
    :tests       ["(= (second (__ [2 3 2])) [2 5 5 2])"
                  "(= (take 5 (__ [1])) [[1] [1 1] [1 2 1] [1 3 3 1] [1 4 6 4 1]])"
                  "(= (take 2 (__ [3 1 2])) [[3 1 2] [3 4 3 2]])"
                  "(= (take 100 (__ [2 4 2])) (rest (take 101 (__ [2 2]))))"]
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         148
    :title       "The Big Divide"
    :description "Write a function which calculates the sum of all natural
numbers under n (first argument) which are evenly divisible by at least one
of a and b (second and third argument). Numbers a and b are guaranteed to be coprimes.

Note: Some test cases have a very large n, so the most obvious solution will
exceed the time limit."
    :tests       ["(= 0 (__ 3 17 11))"
                  "(= 23 (__ 10 3 5))"
                  "(= 233168 (__ 1000 3 5))"
                  "(= \"2333333316666668\" (str (__ 100000000 3 5)))"
                  "(= \"110389610389889610389610\"
                      (str (__ (* 10000 10000 10000) 7 11)))"
                  "(= \"1277732511922987429116\"
                      (str (__ (* 10000 10000 10000) 757 809)))"
                  "(= \"4530161696788274281\"
                      (str (__ (* 10000 10000 1000) 1597 3571)))"]
    :difficulty "medium" 
    :tags ["math"]}

   {:_id         150
    :title       "Palindromic Numbers"
    :description "A palindromic number is a number that is the same when
written forwards or backwards (e.g., 3, 99, 14341).

Write a function which takes an integer n, as its only argument, and
returns an increasing lazy sequence of all palindromic numbers that
are not less than n.

The most simple solution will exceed the time limit!"
    :tests       ["(= (take 26 (__ 0))
                      [0 1 2 3 4 5 6 7 8 9
                       11 22 33 44 55 66 77 88 99
                       101 111 121 131 141 151 161])"
                  "(= (take 16 (__ 162))
                      [171 181 191 202
                       212 222 232 242
                       252 262 272 282
                       292 303 313 323])"
                  "(= (take 6 (__ 1234550000))
                      [1234554321 1234664321 1234774321
                       1234884321 1234994321 1235005321])"
                  "(= (first (__ (* 111111111 111111111)))
                      (* 111111111 111111111))"
                  "(= (set (take 199 (__ 0)))
                      (set (map #(first (__ %)) (range 0 10000))))"
                  "(= true
                      (apply < (take 6666 (__ 9999999))))"
                  "(= (nth (__ 0) 10101)
                      9102019)"]
    :difficulty "medium" 
    :tags ["seqs" "math"]}

   {:_id         153
    :title       "Pairwise Disjoint Sets"
    :description "Given a set of sets, create a function which returns true if no
two of those sets have any elements in common (1) and false otherwise. Some of the
test cases are a bit tricky, so pay a little more attention to them.

(1) Such sets are usually called pairwise disjoint or mutually disjoint."
    :tests       ["(= (__ #{#{\\U} #{\\s} #{\\e \\R \\E} #{\\P \\L} #{\\.}})
                       true)"
                  "(= (__ #{#{:a :b :c :d :e}
                             #{:a :b :c :d}
                             #{:a :b :c}
                             #{:a :b}
                             #{:a}})
                       false)"
                  "(= (__ #{#{[1 2 3] [4 5]}
                             #{[1 2] [3 4 5]}
                             #{[1] [2] 3 4 5}
                             #{1 2 [3 4] [5]}})
                       true)"
                  "(= (__ #{#{'a 'b}
                             #{'c 'd 'e}
                             #{'f 'g 'h 'i}
                             #{''a ''c ''f}})
                       true)"
                  "(= (__ #{#{'(:x :y :z) '(:x :y) '(:z) '()}
                             #{#{:x :y :z} #{:x :y} #{:z} #{}}
                             #{'[:x :y :z] [:x :y] [:z] [] {}}})
                       false)"
                  "(= (__ #{#{(= \"true\") false}
                             #{:yes :no}
                             #{(class 1) 0}
                             #{(symbol \"true\") 'false}
                             #{(keyword \"yes\") ::no}
                             #{(class '1) (int \\0)}})
                       false)"
                  "(= (__ (set [(set [distinct?])
                                 (set [#(-> %) #(-> %)])
                                 (set [#(-> %) #(-> %) #(-> %)])
                                 (set [#(-> %) #(-> %) #(-> %)])]))
                       true)"
                  "(= (__ #{#{(#(-> *)) + (quote mapcat) #_ nil}
                             #{'+ '* mapcat (comment mapcat)}
                             #{(do) set contains? nil?}
                             #{, , , #_, , empty?}})
                       false)"]
    :difficulty "easy" 
    :tags ["set-theory"]}

   {:_id         156
    :title       "Map Defaults"
    :description "When retrieving values from a map, you can specify default
values in case the key is not found:

(= 2 (:foo {:bar 0, :baz 1} 2))

However, what if you want the map itself to contain the default values? Write a
function which takes a default value and a sequence of keys and constructs a map."
    :tests       ["(= (__ 0 [:a :b :c]) {:a 0 :b 0 :c 0})"
                  "(= (__ \"x\" [1 2 3]) {1 \"x\" 2 \"x\" 3 \"x\"})"
                  "(= (__ [:a :b] [:foo :bar]) {:foo [:a :b] :bar [:a :b]})"]
    :difficulty "elementary" 
    :tags ["seqs"]}

   {:_id         157
    :title       "Indexing Sequences"
    :description "Transform a sequence into a sequence of pairs containing the original
elements along with their index."
    :tests       ["(= (__ [:a :b :c]) [[:a 0] [:b 1] [:c 2]])"
                  "(= (__ [0 1 3]) '((0 0) (1 1) (3 2)))"
                  "(= (__ [[:foo] {:bar :baz}]) [[[:foo] 0] [{:bar :baz} 1]])"]
    :difficulty "easy" 
    :tags ["seqs"]}

   {:_id         158
    :title       "Decurry"
    :description "Write a function that accepts a curried function of unknown arity n.
Return an equivalent function of n arguments. "
    :tests       ["(= 10 ((__ (fn [a]
                                (fn [b]
                                  (fn [c]
                                    (fn [d]
                                      (+ a b c d))))))
                          1 2 3 4))"
                  "(= 24 ((__ (fn [a]
                                (fn [b]
                                  (fn [c]
                                    (fn [d]
                                      (* a b c d))))))
                          1 2 3 4))"
                  "(= 25 ((__ (fn [a]
                                (fn [b]
                                  (* a b))))
                          5 5))"]
    :difficulty "medium" 
    :tags ["partial-functions"]}

   {:_id         161
    :title       "Subset and Superset"
    :description "Set A is a subset of set B, or equivalently B is a superset of A,
    if A is \"contained\" inside B. A and B may coincide."
    :tests       ["(clojure.set/superset? __ #{2})"
                  "(clojure.set/subset? #{1} __)"
                  "(clojure.set/superset? __ #{1 2})"
                  "(clojure.set/subset? #{1 2} __)"]
    :difficulty "elementary" 
    :tags ["set-theory"]}

   {:_id         162
    :title       "Logical falsity and truth"
    :description "In Clojure, only nil and false represent the values of logical
falsity in conditional tests - anything else is logical truth."
    :tests       ["(= __ (if-not false 1 0))"
                  "(= __ (if-not nil 1 0))"
                  "(= __ (if true 1 0))"
                  "(= __ (if [] 1 0))"
                  "(= __ (if [0] 1 0))"
                  "(= __ (if 0 1 0))"
                  "(= __ (if 1 1 0))"]
    :difficulty "elementary" 
    :tags ["logic"]}

   {:_id         166
    :title       "Comparisons"
    :description "For any orderable data type it's possible to derive all of the
basic comparison operations (<, ≤, =, ≠, ≥, and >) from a single operation (any
operator but = or ≠ will work). Write a function that takes three arguments, a
less than operator for the data and two items to compare. The function should
return a keyword describing the relationship between the two items. The keywords
for the relationship between x and y are as follows:

  x = y → :eq
  x > y → :gt
  x < y → :lt"
    :tests       ["(= :gt (__ < 5 1))"
                  "(= :eq (__ (fn [x y] (< (count x) (count y))) \"pear\" \"plum\"))"
                  "(= :lt (__ (fn [x y] (< (mod x 5) (mod y 5))) 21 3))"
                  "(= :gt (__ > 0 2))"]
    :difficulty "easy" 
    :tags []}

   {:_id         168
    :title       "Infinite Matrix"
    :description "In what follows, m, n, s, t denote nonnegative integers, f denotes a
function that accepts two arguments and is defined for all nonnegative integers in both
arguments.

In mathematics, the function f can be interpreted as an infinite matrix with infinitely
many rows and columns that, when written, looks like an ordinary matrix but its rows and
columns cannot be written down completely, so are terminated with ellipses. In Clojure,
such infinite matrix can be represented as an infinite lazy sequence of infinite lazy
sequences, where the inner sequences represent rows.

Write a function that accepts 1, 3 and 5 arguments

  * with the argument f, it returns the infinite matrix A that has the entry in the i-th
row and the j-th column equal to f(i,j) for i,j = 0,1,2,...;
  * with the arguments f, m, n, it returns the infinite matrix B that equals the remainder
of the matrix A after the removal of the first m rows and the first n columns;
  * with the arguments f, m, n, s, t, it returns the finite s-by-t matrix that consists of
the first t entries of each of the first s rows of the matrix B or, equivalently, that
consists of the first s entries of each of the first t columns of the matrix B."
    :restricted  ["for" "range" "iterate" "repeat" "cycle" "drop"]
    :tests       ["(= (take 5 (map #(take 6 %) (__ str)))
                       [[\"00\" \"01\" \"02\" \"03\" \"04\" \"05\"]
                        [\"10\" \"11\" \"12\" \"13\" \"14\" \"15\"]
                        [\"20\" \"21\" \"22\" \"23\" \"24\" \"25\"]
                        [\"30\" \"31\" \"32\" \"33\" \"34\" \"35\"]
                        [\"40\" \"41\" \"42\" \"43\" \"44\" \"45\"]])"
                  "(= (take 6 (map #(take 5 %) (__ str 3 2)))
                       [[\"32\" \"33\" \"34\" \"35\" \"36\"]
                        [\"42\" \"43\" \"44\" \"45\" \"46\"]
                        [\"52\" \"53\" \"54\" \"55\" \"56\"]
                        [\"62\" \"63\" \"64\" \"65\" \"66\"]
                        [\"72\" \"73\" \"74\" \"75\" \"76\"]
                        [\"82\" \"83\" \"84\" \"85\" \"86\"]])"
                  "(= (__ * 3 5 5 7)
                       [[15 18 21 24 27 30 33]
                        [20 24 28 32 36 40 44]
                        [25 30 35 40 45 50 55]
                        [30 36 42 48 54 60 66]
                        [35 42 49 56 63 70 77]])"
                  "(= (__ #(/ % (inc %2)) 1 0 6 4)
                       [[1/1 1/2 1/3 1/4]
                        [2/1 2/2 2/3 1/2]
                        [3/1 3/2 3/3 3/4]
                        [4/1 4/2 4/3 4/4]
                        [5/1 5/2 5/3 5/4]
                        [6/1 6/2 6/3 6/4]])"
                  "(= (class (__ (juxt bit-or bit-xor)))
                      (class (__ (juxt quot mod) 13 21))
                      (class (lazy-seq)))"
                  "(= (class (nth (__ (constantly 10946)) 34))
                      (class (nth (__ (constantly 0) 5 8) 55))
                      (class (lazy-seq)))"
                  "(= (let [m 377 n 610 w 987
                            check (fn [f s] (every? true? (map-indexed f s)))
                            row (take w (nth (__ vector) m))
                            column (take w (map first (__ vector m n)))
                            diagonal (map-indexed #(nth %2 %) (__ vector m n w w))]
                        (and (check #(= %2 [m %]) row)
                              (check #(= %2 [(+ m %) n]) column)
                              (check #(= %2 [(+ m %) (+ n %)]) diagonal)))
                      true)"]
    :difficulty "medium" 
    :tags ["seqs" "recursion" "math"]}

   {:_id         171
    :title       "Intervals"
    :description "Write a function that takes a sequence of integers
and returns a sequence of “intervals”.
Each interval is a a vector of two integers, start and end,
such that all integers between start and end (inclusive)
are contained in the input sequence."
    :tests       ["(= (__ [1 2 3]) [[1 3]])"
                  "(= (__ [10 9 8 1 2 3]) [[1 3] [8 10]])"
                  "(= (__ [1 1 1 1 1 1 1]) [[1 1]])"
                  "(= (__ []) [])"
                  "(= (__ [19 4 17 1 3 10 2 13 13 2 16 4 2 15 13 9 6 14 2 11])
                      [[1 4] [6 6] [9 11] [13 17] [19 19]])"] 
    :difficulty "medium" 
    :tags []}

   {:_id         173
    :title       "Intro to Destructuring 2"
    :description "Sequential destructuring allows you to bind symbols to parts of
sequential things (vectors, lists, seqs, etc.): (let [bindings* ] exprs*) Complete
the bindings so all let-parts evaluate to 3."
    :tests       ["(= 3
                      (let [[__] [+ (range 3)]] (apply __))
                      (let [[[__] b] [[+ 1] 2]] (__ b))
                      (let [[__] [inc 2]] (__)))"]
    :difficulty "easy" 
    :tags ["destructuring"]}

   {:_id         177
    :title       "Balancing Brackets"
    :description "When parsing a snippet of code it's often a good idea to do a
sanity check to see if all the brackets match up. Write a function that takes in
a string and returns truthy if all square [ ] round ( ) and curly { } brackets are
properly paired and legally nested, or returns falsey otherwise."
    :tests       ["(__ \"This string has no brackets.\")"
                  "(__ \"class Test {
                          public static void main(String[] args) {
                            System.out.println(\\\"Hello world.\\\");
                          }
                        }\")"
                  "(not (__ \"(start, end]\"))"
                  "(not (__ \"())\"))"
                  "(not (__ \"[ { ] } \"))"
                  "(__ \"([]([(()){()}(()(()))(([[]]({}()))())]((((()()))))))\")"
                  "(not (__ \"([]([(()){()}(()(()))(([[]]({}([)))())]((((()()))))))\"))"
                  "(not (__ \"[\"))"]
    :difficulty "medium" 
    :tags ["parsing"]}

   {:_id         195
    :title       "Parentheses... Again"
    :description "In a family of languages like Lisp, having balanced parentheses
is a defining feature of the language. Luckily, Lisp has almost no syntax, except
for these \"delimiters\" -- and that hardly qualifies as \"syntax\", at least in any
useful computer programming sense.

It is not a difficult exercise to find all the combinations of well-formed parentheses
if we only have N pairs to work with. For instance, if we only have 2 pairs, we only
have two possible combinations: \"()()\" and \"(())\". Any other combination of length 4
is ill-formed. Can you see why?

Generate all possible combinations of well-formed parentheses of length 2n (n pairs
of parentheses). For this problem, we only consider '(' and ')', but the answer
is similar if you work with only {} or only [].

There is an interesting pattern in the numbers!"
    :tests       ["(= [#{\"\"} #{\"()\"} #{\"()()\" \"(())\"}] (map (fn [n] (__ n)) [0 1 2]))"
                  "(= #{\"((()))\" \"()()()\" \"()(())\" \"(())()\" \"(()())\"} (__ 3))"
                  "(= 16796 (count (__ 10)))"
                  "(= (nth (sort (filter #(.contains ^String % \"(()()()())\") (__ 9))) 6) \"(((()()()())(())))\")"
                  "(= (nth (sort (__ 12)) 5000) \"(((((()()()()()))))(()))\")"]
    :difficulty "medium" 
    :tags ["math" "combinatorics"]}])
