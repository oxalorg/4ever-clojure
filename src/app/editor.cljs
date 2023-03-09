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

(def mk-extensions
  (memoize
   (fn [extension-mode]
     #js
      [theme
       (history)
       highlight/defaultHighlightStyle
       (view/drawSelection)
       (lineNumbers)
       (fold/foldGutter)
       (.. EditorState -allowMultipleSelections (of true))
       (let [editor-extensions-to-load (case extension-mode
                                         :basic editor-ex/clojure-mode-extensions-basic
                                         :extended cm-clj/default-extensions
                                         (do (js/console.info (str "Unknown Editor extensions mode: "
                                                                   (name extension-mode)
                                                                   ". Defaulting to basic mode."))
                                             editor-ex/clojure-mode-extensions-basic))]
         (if false
           ;; use live-reloading grammar
           #js [(cm-clj/syntax live-grammar/parser)
                (.slice editor-extensions-to-load 1)]
           editor-extensions-to-load))
       #_(.of view/keymap cm-clj/complete-keymap)
       #_(.of view/keymap historyKeymap)])))

(defn- make-state [extensions doc]
  (.create EditorState
           #js{:doc doc
               :extensions (cond-> #js[(.. EditorState -allowMultipleSelections (of true))]
                             extensions
                             (j/push! extensions))}))

(defn show-error [last-result test-evaluation-error-str]
  (if (contains? last-result ::sci/result)
    [:span "user=> "
     (binding [*print-length* 20]
       (pr-str (::sci/result last-result)))
     (when test-evaluation-error-str
       [:span
        [:br]
        [:br]
        "test=>"
        [:br]
        test-evaluation-error-str])]
    [:span
     "user=>"
     [:br]
     (::sci/error-str last-result)]))

(defn editor
  [source !view test-evaluation-error-str {:keys [eval? extension-mode]}]
  (r/with-let
    [last-result (when eval? (r/atom (sci/eval-string source)))
     mount! (fn [el]
              (when el
                (reset! !view
                        (new EditorView
                             (j/obj :state (make-state
                                            (cond-> #js [(mk-extensions (or extension-mode :basic))]
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
         (try [:code {:style {:white-space "pre-wrap"
                              :word-break "break-all"}}
               [show-error @last-result test-evaluation-error-str]]

              (catch :default e (str e)))]])]
    (finally (j/call @!view :destroy))))
