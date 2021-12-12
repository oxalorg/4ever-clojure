(ns app.error
  (:require [clojure.string :as str]
            [sci.core :as sci]))

(defn ruler [title]
  (println (apply str "----- " title " " (repeat (- 50 7 (count title)) \-))))

(defn split-stacktrace [stacktrace verbose?]
  (if verbose? [stacktrace]
      (let [stack-count (count stacktrace)]
        (if (<= stack-count 10)
          [stacktrace]
          [(take 5 stacktrace)
           (drop (- stack-count 5) stacktrace)]))))

(defn print-stacktrace
  [stacktrace {:keys [:verbose?]}]
  (let [stacktrace (sci/format-stacktrace stacktrace)
        segments (split-stacktrace stacktrace verbose?)
        [fst snd] segments]
    (run! #(print % "\n") fst)
    (when snd
      (print "...\n")
      (run! #(print % "\n") snd))))

(defn error-context [source ex]
  (let [{:keys [:line :column]} (ex-data ex)]
    (when line
      (when-let [content source]
        (let [matching-line (dec line)
              start-line (max (- matching-line 4) 0)
              end-line (+ matching-line 6)
              [before after] (->>
                              (str/split-lines content)
                              (map-indexed list)
                              (drop start-line)
                              (take (- end-line start-line))
                              (split-at (inc (- matching-line start-line))))
              snippet-lines (concat before
                                    [[nil (str (str/join "" (repeat (dec column) " "))
                                               (str "^--- " (ex-message ex)))]]
                                    after)
              indices (map first snippet-lines)
              max-size (reduce max 0 (map (comp count str) indices))
              snippet-lines (map (fn [[idx line]]
                                   (if idx
                                     (let [line-number (inc idx)]
                                       (str (.padStart (str line-number ":") max-size "0") " " line))
                                     (str (str/join (repeat (+ 2 max-size) " ")) line)))
                                 snippet-lines)]
          (str/join "\n" snippet-lines))))))

(defn right-pad [s n]
  (let [n (- n (count s))]
    (str s (str/join (repeat n " ")))))

(defn print-locals [locals]
  (let [max-name-length (reduce max 0 (map (comp count str)
                                           (keys locals)))
        max-name-length (+ max-name-length 2)]
    (println
     (with-out-str (binding [*print-length* 10
                             *print-level* 2]
                     (doseq [[k v] locals]
                       (print (str (right-pad (str k ": ") max-name-length)))
                       ;; print nil as nil
                       (prn v)))))))

(defn error-handler [source ex]
  (let [stacktrace (sci/stacktrace ex)
        d (ex-data ex)
        sci-error? (isa? (:type d) :sci/error)]
    (ruler "Error")
    (when-let [name (.-name ex)]
      (when-not (= "Error" name)
        (println "Type:    " name)))
    (when-let [m (.-message ex)]
      (println (str "Message:  " m)))
    (let [{:keys [:file :line :column]} d]
      (when line
        (println (str "Location: "
                      (when file (str file ":"))
                      line ":" column""))))
    (when-let [phase (:phase d)]
      (println "Phase:   " phase))
    (when-let [ec (when sci-error?
                    (error-context source ex))]
      (println)
      (ruler "Context")
      (println ec))
    (when sci-error?
      (when-let
          [st (let [st (with-out-str
                         (when stacktrace
                           (print-stacktrace stacktrace nil)))]
                (when-not (str/blank? st) st))]
        (println)
        (ruler "Stack trace")
        (println st)))))
