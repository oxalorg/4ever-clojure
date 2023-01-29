(ns app.solution
  (:require 
   [reagent.core :as r]))

(defn solutions-url [id]
  (str "https://solutions.4clojure.oxal.org/deduped/solutions/" id ".json"))

(def solutions (r/atom []))

(defn state-init! [id]
  (reset! solutions [])
  (let [id (js/parseInt id)
        data (js/fetch (solutions-url id))]
    (-> data
        (.then (fn [resp]
                 (.json resp)))
        (.then (fn [data]
                 (reset! solutions (take 1000 (js->clj data))))))))

(defn list-view [{:keys [path-params]}]
  (let [id (js/parseInt (:id path-params))]
    [:div
     [:h2 "Solutions for problem #" id]
     [:p "Entire archive available at: "
      [:a {:href "https://github.com/oxalorg/4clojure-solutions-archive/"}
       "github.com/oxalorg/4clojure-solutions-archive/"]]
     (if @solutions
       [:div
        (for [solution @solutions]
          ^{:key (get solution "user")}
          [:div
           [:pre
            [:code (get solution "code")]]]
          )]
       "Loading...")]))
