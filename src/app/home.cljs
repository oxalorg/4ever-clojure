(ns app.home
  (:require [app.data :as data]
            [app.state :as state]
            [app.problem :as problem]
            [reagent.core :as r]))

(defonce sort-by-status (r/atom true))

(defn sorted-problems []
  (let [solved-keys (set (keys @problem/user-data))
        p-map (group-by #(contains? solved-keys (:_id %)) data/problems)]
    (if @sort-by-status
      (concat (get p-map true) (get p-map false))
      (concat (get p-map false) (get p-map true)))))

(defn get-problem-status [id]
  (let [{:keys [passed failed]}
        (get @problem/user-data (js/parseInt id))
        progress (str passed "/" (+ passed failed))]
    (cond
      (and passed (zero? failed))
      [:span {:style {:color "green"}} (str progress " Passed!")]
      (not (nil? passed)) progress
      :else "-")))

(defn problem-list-item [{:keys [_id title tags difficulty]}]
  [:tr
   [:td _id]
   [:td 
    [:a {:href (state/href :problem/item {:id _id})}
     title]]
   [:td difficulty]
   [:td (get-problem-status _id)]])

(defn problem-list []
  [:<>
   [:h3 "Problems "
    [:small (str "(" (count data/problems) ")")]]
   (into [:table
          [:tr
           [:th "No."]
           [:th "Name"]
           [:th "Difficulty"]
           [:th
            {:on-click #(swap! sort-by-status
                               (fn [] (if @sort-by-status false true)))}
            (str "Status  " (if @sort-by-status "🠕" "🠗"))]]
          (for [problem (sorted-problems)]
            ^{:key (:_id problem)}
            [problem-list-item problem])])])

(defn view []
[:div
 [:p
  "Keeping 4clojure alive forever! This website is completely static and evals
     code using sci. Suggestions / PRs welcome at "
  [:a {:href "https://github.com/oxalorg/4ever-clojure"} "github.com/oxalorg/4ever-clojure"]]
 [problem-list]]
)
