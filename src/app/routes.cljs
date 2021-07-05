(ns app.routes
  (:require [app.home :as home]
            [reitit.frontend :as rf]
            [reitit.frontend.controllers :as rfc]
            [reitit.frontend.easy :as rfe]
            [reagent.core :as r]))

(defonce match (r/atom nil))

(def routes
  [["/" {:name :home
         :view home/view}]
   ["/problem" {:name :problem/list
                :view home/view}]
   ["/problem/:id" {:name :problem/item
                :view home/view}]])

(defn route-handler [new-match]
  (swap! match
         (fn [old-match]
           (when new-match
             (assoc new-match
                    :controllers (rfc/apply-controllers (:controllers old-match) new-match))))))

(defn init! []
  (rfe/start!
   (rf/router routes)
   route-handler
   {:use-fragment true}))
