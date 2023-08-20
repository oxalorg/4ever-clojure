(ns app.sci
  (:require ["@codemirror/view" :as view]
            [app.error :refer [error-handler]]
            [applied-science.js-interop :as j]
            [goog.string]
            [goog.string.format]
            [nextjournal.clojure-mode.extensions.eval-region :as eval-region]
            [sci.core :as sci]
            [sci.impl.evaluator]))

(def doc-str-src "
(in-ns 'user)
(defmacro doc [sym]
  `(str \"\n\" (with-out-str (clojure.repl/doc ~sym))))")

(defonce context
  (doto
   (sci/init {:classes {'js goog/global
                        :allow :all}
              :namespaces {'clojure.core {'format goog.string/format}}})
   (sci/eval-string* doc-str-src)))


(defn eval-string [source]
  (try {::result (sci/eval-string* context source)}
       (catch :default e
         {::error-str (with-out-str (error-handler source e))})))

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
