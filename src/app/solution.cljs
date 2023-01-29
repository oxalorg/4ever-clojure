(ns app.solution
  (:require [lambdaisland.fetch :as fetch]
            [reagent.core :as r]))

(defn solutions-url [id]
  (str "https://solutions.4clojure.oxal.org/deduped/solutions/" id ".json"))

(def solutions (r/atom []))

(defn state-init! [id]
  (reset! solutions [])
  (let [id (js/parseInt id)
        data (fetch/get (solutions-url id))]
    (-> data
        (.then (fn [resp]
                 (reset! solutions (take 1000 (js->clj (:body resp)))))))))

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
