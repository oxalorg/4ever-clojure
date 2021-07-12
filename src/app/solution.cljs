(ns app.solution
  (:require [lambdaisland.fetch :as fetch]
            [reagent.core :as r]))

(defn solutions-url [id]
  (str "/api/solutions/" id ".json"))

(def solutions (r/atom []))

(defn state-init! [id]
  (reset! solutions [])
  (let [id (js/parseInt id)
        data (fetch/get (solutions-url id))]
    (-> data
        (.then (fn [resp]
                 (reset! solutions (js->clj (:body resp))))))))

(defn list-view [{:keys [path-params]}]
  (let [id (js/parseInt (:id path-params))]
    [:div
     [:h2 "Solutions for problem #" id]
     [:p "Entire archive available at: "
      [:a {:href "https://github.com/oxalorg/4clojure-solutions-acrhive/"}
       "github.com/oxalorg/4clojure-solutions-acrhive/"]]
     (if @solutions
       [:div
        (for [solution @solutions]
          ^{:key (get solution "user")}
          [:div
           [:pre
            [:code (get solution "code")]]]
          )]
       "Loading...")]))
