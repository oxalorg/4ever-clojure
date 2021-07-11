(ns app.max-or-throw
  "Taken from a previous version of SCI. See
  https://github.com/borkdude/sci/commit/4197294987cdd85a8c909328c6fc5d5ba92fa7c6.")

(defprotocol MaxOrThrow
  (max-or-throw [this n]))

(defn bottom [n data]
  (lazy-seq [(throw (ex-info (str "Maximum number of elements realized: " n)
                             data))]))

(defn take*
  ([n coll err-val]
   (lazy-seq
    (if (pos? n)
      (when-let [s (seq coll)]
        (cons (first s) (take* (dec n) (rest s) err-val)))
      err-val))))

(defn take-or-throw [coll n]
  (take* n coll
         (bottom n (merge {:type :sci.error/realized-beyond-max
                           :realize-max n}))))

(extend-protocol MaxOrThrow

  nil
  (max-or-throw
    ([this n] this))

  default
  (max-or-throw
    ([this n] this))

  LazySeq
  (max-or-throw
    ([this n]
     (take-or-throw this n)))

  Cons
  (max-or-throw
    ([this n]
     (take-or-throw this n)))

  Range
  (max-or-throw
    ([this n]
     (take-or-throw this n)))

  Iterate
  (max-or-throw
    ([this n]
     (take-or-throw this n)))

  Repeat
  (max-or-throw
    ([this n]
     (take-or-throw this n))))
