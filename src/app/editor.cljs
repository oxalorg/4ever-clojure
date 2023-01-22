(ns app.editor
  (:require ["@codemirror/fold" :as fold]
            ["@codemirror/gutter" :refer [lineNumbers]]
            ["@codemirror/highlight" :as highlight]
            ["@codemirror/history" :refer [history #_historyKeymap]]
            ["@codemirror/state" :refer [EditorState]]
            ["@codemirror/view" :as view :refer [EditorView]]
            [app.editor-ex :as editor-ex]
            [app.sci :as sci]
            [applied-science.js-interop :as j]
            [nextjournal.clojure-mode :as cm-clj]
            [nextjournal.clojure-mode.live-grammar :as live-grammar]
            [reagent.core :as r]))

(def theme
  (.theme
   EditorView
   (j/lit {".cm-content" {:white-space "pre-wrap", :padding "10px 0"},
           "&.cm-focused" {:outline "none"},
           ".cm-line" {:padding "0 9px",
                       :line-height "1.6",
                       :font-size "16px",
                       :font-family "var(--code-font)"},
           ".cm-matchingBracket" {:border-bottom "1px solid var(--teal-color)",
                                  :color "inherit"},
           ".cm-gutters" {:background "transparent", :border "none"},
           ".cm-gutterElement" {:margin-left "5px"},
           ;; only show cursor when focused
           ".cm-cursor" {:visibility "hidden"},
           "&.cm-focused .cm-cursor" {:visibility "visible"}})))

(defonce extensions
  #js
   [theme
    (history)
    highlight/defaultHighlightStyle
    (view/drawSelection)
    (lineNumbers)
    (fold/foldGutter)
    (.. EditorState -allowMultipleSelections (of true))
    (if false
     ;; use live-reloading grammar
      #js [(cm-clj/syntax live-grammar/parser)
           (.slice editor-ex/clojure-mode-extensions 1)]
      editor-ex/clojure-mode-extensions)
    #_(.of view/keymap cm-clj/complete-keymap)
    #_(.of view/keymap historyKeymap)])

(defn- make-state [extensions doc]
  (.create EditorState
           #js{:doc doc
               :extensions (cond-> #js[(.. EditorState -allowMultipleSelections (of true))]
                             extensions
                             (j/push! extensions))}))

(defn editor
  [source !view {:keys [eval?]}]
  (r/with-let
    [last-result (when eval? (r/atom (sci/eval-string source)))
     mount! (fn [el]
              (when el
                (reset! !view (new EditorView
                                   (j/obj :state (make-state
                                                  (cond-> #js [extensions]
                                                    eval? (.concat
                                                           #js
                                                            [(sci/extension
                                                              {:modifier "Alt",
                                                               :on-result
                                                               (fn [result]
                                                                 (reset! last-result result))})]))
                                                  source)

                                          :parent el)))))]
    [:div
     [:div
      {:ref mount!,
       :style {:background-color "#e3e3e3"}}]
     (when eval?
       [:div
        {:style {:white-space "pre-wrap"
                 :margin-top "0.5rem"
                 :font-size "0.9em"
                 :color "#333333"
                 :font-family "var(--code-font)"}}
        [:pre {:style {:margin-bottom "0.5rem"}}
         [:span "user=> "]
         (try [:code {:style {:white-space "pre-wrap"
                              :word-break "break-all"}}
               (binding [*print-length* 20]
                 (if (string? @last-result) @last-result (pr-str @last-result)))]
              (catch :default e (str e)))]])]
    (finally (j/call @!view :destroy))))
