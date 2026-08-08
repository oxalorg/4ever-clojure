(ns app.state
  (:require [alandipert.storage-atom :as lstore]
            [reagent.core :as r]
            [reitit.frontend.easy :as rfe]))

(def navigate rfe/push-state)

(def href rfe/href)

(def default-db
  "default db example:
    {:solutions {12 {:code \"(fn [x] (apply + x))\"
                     :passed 2
                     :failed 3}
                 44 {...}}
     :sort-by-solved nil|false|true}"
  {:solutions {}
   :sort-by-solved nil})

(defonce db
  (lstore/local-storage (r/atom {})
                        :4ever-clojure))

(defn new-raw-html-el
  [tag attrs]
  (js/Object.assign
   (js/document.createElement tag)
   (clj->js attrs)))

(defn export-user-data
  "Get the user's solutions from local storage, and save them to a file."
  []
  ;; https://stackoverflow.com/a/79383186/21908056 :)
  (let [filename "4ever-clojure.edn"
        content (@db :solutions)
        file (new js/Blob [content] {"type" "text/plain"})
        link (js/URL.createObjectURL file)
        export (new-raw-html-el "a" {:href link :download filename})]
    (.click export)
    (. js/URL revokeObjectURL link)))
