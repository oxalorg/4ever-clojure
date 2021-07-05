(ns app.routes
  (:require [app.home :as home]
            [reitit.frontend :as rf]
            [reitit.frontend.controllers :as rfc]
            [reitit.frontend.easy :as rfe]
            [reagent.core :as r]))

(def navigate rfe/push-state)

(defonce match (r/atom nil))

(def routes
  [["/" {:name :home
         :view home/view}]
   ["/problems" {:name :problems
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
