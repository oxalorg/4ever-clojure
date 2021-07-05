(ns app.problem
  (:require [app.data :as data]
            [app.state :as state]))

(defn view [{:keys [path-params] :as props}]
  [:div
   [:h3 "Problem " (:id path-params)]])
