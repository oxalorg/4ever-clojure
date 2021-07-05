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
   [:h3 "Problems "
    [:small (str "(" (count data/problems) ")")]]
   [:ol
    (for [problem data/problems]
      (problem-list-item problem))]])

(defn view []
  [:div
   [:p
    "Keeping 4clojure alive forever! This website is completely static and evals
     code using sci. Suggestions / PRs welcome at "
    [:a {:href "https://github.com/oxalorg/4ever-clojure"} "github.com/oxalorg/4ever-clojure"]]
   [problem-list]]
  )
