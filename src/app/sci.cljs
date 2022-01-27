(ns app.sci
  (:require ["@codemirror/view" :as view]
            [app.error :refer [error-handler]]
            [app.max-or-throw :refer [max-or-throw]]
            [applied-science.js-interop :as j]
            [nextjournal.clojure-mode.extensions.eval-region :as eval-region]
            [sci.core :as sci]
            [sci.impl.evaluator]))

(defonce context
  (sci/init {:classes {'js goog/global
                       :allow :all}
             :namespaces {'max-or-throw.core {'max-or-throw max-or-throw}}}))

(def max-seq-limit 10000)

(defn instrument-1 [form]
  (if (seq? form)
    (list 'max-or-throw.core/max-or-throw form max-seq-limit)
    form))

;; Note from @borkdude: this is a hack. We intercept each result from the
;; evaluator and wrap it in a call to max-or-throw.
(defonce instrument-eval
  (let [old-eval sci.impl.evaluator/eval]
    (set! sci.impl.evaluator/eval
          (fn [ctx bindings expr]
            (max-or-throw (old-eval ctx bindings expr) 10000)))))

(defn eval-string [source]
  (try (sci/eval-string* context source)
       (catch :default e
         (with-out-str (error-handler source e)))))

(j/defn eval-at-cursor [on-result ^:js {:keys [state]}]
  (some->> (eval-region/cursor-node-string state)
           (eval-string)
           (on-result (.-doc state)))
  true)

(j/defn eval-top-level [on-result ^:js {:keys [state]}]
  (some->> (eval-region/top-level-string state)
           (eval-string)
           (on-result (.-doc state)))
  true)

(j/defn eval-cell [on-result ^:js {:keys [state]}]
  (some->> (str "(do " (.-doc state) " )")
      (eval-string)
      (on-result (.-doc state)))
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
