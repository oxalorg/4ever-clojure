(ns app.editor-ex-brackets
  (:require
   ["@codemirror/view" :as view]
   [applied-science.js-interop :as j]
   [nextjournal.clojure-mode.extensions.close-brackets :as orig]))

(defn extension []
  (.of view/keymap
       (j/lit
        [{:key "(" :run (orig/handle-open-cmd "(")}
         {:key "[" :run (orig/handle-open-cmd "[")}
         {:key "{" :run (orig/handle-open-cmd "{")}
         {:key \" :run (orig/handle-open-cmd \")}])))
