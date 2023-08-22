(ns app.editor-ex
  (:require
   ["@codemirror/view" :as view :refer [EditorView]]
   ["lezer-clojure" :as lezer-clj]
   [nextjournal.clojure-mode :as cm-clj]
   [nextjournal.clojure-mode.extensions.eval-region :as eval-region]
   [nextjournal.clojure-mode.extensions.formatting :as format]
   [nextjournal.clojure-mode.extensions.match-brackets :as match-brackets]
   [nextjournal.clojure-mode.extensions.selection-history :as sel-history]))

(def clojure-mode-extensions-basic
  #js[(cm-clj/syntax lezer-clj/parser)
      (match-brackets/extension)
      (sel-history/extension)
      (format/ext-format-changed-lines)
      (.-lineWrapping EditorView)
      (eval-region/extension {:modifier "Alt"})])
