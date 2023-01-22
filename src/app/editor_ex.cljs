(ns app.editor-ex
  (:require
   ["@codemirror/view" :as view :refer [EditorView]]
   ["lezer-clojure" :as lezer-clj]
   [app.editor-ex-brackets :as open-brackets]
   [nextjournal.clojure-mode :as cm-clj]
   [nextjournal.clojure-mode.extensions.eval-region :as eval-region]
   [nextjournal.clojure-mode.extensions.formatting :as format]
   [nextjournal.clojure-mode.extensions.match-brackets :as match-brackets]
   #_[nextjournal.clojure-mode.extensions.selection-history :as sel-history]))

(def clojure-mode-extensions
  #js[(cm-clj/syntax lezer-clj/parser)
      (open-brackets/extension)
      (match-brackets/extension)
      #_(sel-kistory/extension)
      (format/ext-format-changed-lines)
      (.-lineWrapping EditorView)
      (eval-region/extension {:modifier "Alt"})])

