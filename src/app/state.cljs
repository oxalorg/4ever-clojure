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
