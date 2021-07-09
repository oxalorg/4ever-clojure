(ns app.state
  (:require [reagent.core :as r]
            [alandipert.storage-atom :as lstore]
            [reitit.frontend :as rf]
            [reitit.frontend.controllers :as rfc]
            [reitit.frontend.easy :as rfe]))

(def navigate rfe/push-state)

(def href rfe/href)

(def default-db
  "default db example:
    {:solutions {12 {:code \"(fn [x] (apply + x))\"
                     :passed 2
                     :failed 3}
                 44 {...}}}"
  {:solutions {}})

(defonce db 
  (lstore/local-storage (r/atom {})
                        :4ever-clojure))
