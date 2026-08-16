(ns app.state
  (:require [alandipert.storage-atom :as lstore]
            [cljs.reader :refer [read-string]]
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

;; E.g. {1 {:code "true", :passed 1, :failed 0}, 19 {:code "(comp first reverse)", :passed 3, :failed 0}}
(defn validate-solution-data
  "Returns the data if valid. Throws an exception otherwise."
  [data]
  (if
   (and
    (map? data)
    (every?
     (fn [[id {:keys [code passed failed]}]]
       (and
        (number? id)
        (string? code)
        (number? passed)
        (number? failed))) data))
    data
    (throw (js/Error. "Invalid data format"))))

(defn import-user-data
  "Import user data from a .edn file"
  []
  (let [id "upload-input"
        upload (new-raw-html-el "input" {:id id :type "file" :accept ".edn"})
        on-upload (fn []
                    (let [data (first (.-files upload))
                          reader (new js/FileReader)]
                      (set!
                       (.-onload reader)
                       #(try (->> (.-result reader)
                                  (read-string)
                                  (validate-solution-data)
                                  (reset! (r/cursor db [:solutions])))
                             (catch :default e (js/alert (str "Invalid data: " (.-message e))))))
                      (set! (.-onerror reader) #(js/alert "Error reading file"))
                      (. reader readAsText data)))]
    (. upload addEventListener "change" on-upload)
    (.click upload)))

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
