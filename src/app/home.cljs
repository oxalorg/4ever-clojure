(ns app.home
  (:require [app.data :as data]
            [app.state :as state]))

(defn problem-list-item [{:keys [_id title]}]
  [:li
   ^{:key _id}
   [:a {:href (state/href :problem/item {:id _id})}
    title]])

(defn problem-list []
  [:<>
   [:h3 "Latest problems"]
   [:ul
    (for [problem data/problems]
      (problem-list-item problem))]])

(defn view []
  [:div
   [:p
    "Keeping 4clojure alive forever! This website is completely static and evals
     code using sci."]
   [:p
    "If people start using this we can think about adding a simple ranking
     system using something like firebase."]
   [problem-list]]
  )
