(ns app.sci
  (:require ["@codemirror/view" :as view]
            [app.max-or-throw :refer [max-or-throw]]
            [applied-science.js-interop :as j]
            [clojure.walk :as walk]
            [nextjournal.clojure-mode.extensions.eval-region :as eval-region]
            [sci.core :as sci]))

(defonce context
  (sci/init {:classes {'js goog/global
                       :allow :all}
             :namespaces {'max-or-throw.core {'max-or-throw max-or-throw}}}))

(def max-seq-limit 10000)

(defn instrument-1 [form]
  (if (seq? form)
    (list 'max-or-throw.core/max-or-throw form max-seq-limit)
    form))

(defn eval-string [source]
  (let [rdr (sci/reader source)]
    (loop [last-result nil]
      (let [form (sci/parse-next context rdr)]
        (if (= :sci.core/eof form) last-result
          (let [instrumented (walk/postwalk instrument-1 form)]
            (recur (try (sci/eval-form context instrumented)
                        (catch :default e
                          (str e))))))))))

(j/defn eval-at-cursor [on-result ^:js {:keys [state]}]
  (some->> (eval-region/cursor-node-string state)
           (eval-string)
           (on-result))
  true)

(j/defn eval-top-level [on-result ^:js {:keys [state]}]
  (some->> (eval-region/top-level-string state)
           (eval-string)
           (on-result))
  true)

(j/defn eval-cell [on-result ^:js {:keys [state]}]
  (-> (str "(do " (.-doc state) " )")
      (eval-string)
      (on-result))
  true)

(defn keymap* [modifier]
  {:eval-cell
   [{:key "Mod-Enter"
     :doc "Evaluate cell"}]
   :eval-at-cursor
   [{:key (str modifier "-Enter")
     :doc "Evaluates form at cursor"}]
   :eval-top-level
   [{:key (str modifier "-Shift-Enter")
     :doc "Evaluates top-level form at cursor"}]})

(defn extension [{:keys [modifier
                         on-result]}]
  (.of view/keymap
       (j/lit
        [{:key "Mod-Enter"
          :run (partial eval-cell on-result)}
         {:key (str modifier "-Enter")
          :shift (partial eval-top-level on-result)
          :run (partial eval-at-cursor on-result)}])))
