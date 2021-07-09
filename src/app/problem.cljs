(ns app.problem
  (:require [app.data :as data]
            [app.state :as state]
            [app.localstorage :as localstorage]
            [clojure.string :as str]
            [goog.object :as gobj]
            [reagent.core :as r]
            [sci.core :as sci]))

(def user-solution (r/atom ""))

(defn get-problem [id]
  (first
   (filter #(= (:_id %) id) data/problems)))

(defn eval-string [s]
  (sci/eval-string s {:classes {'js goog/global
                                :allow :all}}))

(defn check-solution [id user-solution]
  (try
    (let [problem (get-problem id)
          replaced   (mapv #(str/replace % "__" user-solution) (:tests problem))
          results (map eval-string replaced)
          passed (count (filter true? results))
          failed (count (filter false? results))]
      (js/alert (str "Passed: " passed " / Failed: " failed)))
    (catch js/Error e
      (js/alert (gobj/get e "message")))))

(defn input-block-handler [problem-id user-solution-atom e]
  (let [solution (-> e .-target .-value)]
    (reset! user-solution-atom solution)
    (localstorage/set-item! problem-id solution)))

(defn input-block [id]
  [:pre
   [:textarea {:name "user-solution"
               :value @user-solution
               :on-change (partial input-block-handler id user-solution)
               :rows 8}]])

(defn view [{:keys [path-params] :as props}]
  (fn [{:keys [path-params] :as props}]
    (let [id (js/parseInt (:id path-params))
          problem (get-problem id)
          solution (localstorage/get-item id)]
      (if (some? solution)
        (reset! user-solution solution)
        (reset! user-solution ""))
      [:div
       [:h3 "Problem " id]
       [:p (:description problem)]
       [:ul
        (for [[i test] (map vector (range) (:tests problem))]
          ^{:key i}
          [:li
           [:pre
            [:code test]]])]
       [:p "Write code which will fill in the above blanks:"]
       [input-block id]
       [:button {:disabled (-> @user-solution
                               str/trim
                               str/blank?)
                 :on-click #(check-solution id @user-solution)} "Run"]])))
