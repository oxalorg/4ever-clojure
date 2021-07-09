(ns app.problem
  (:require [app.data :as data]
            [app.state :as state]
            [alandipert.storage-atom :as lstore]
            [clojure.string :as str]
            [goog.object :as gobj]
            [reagent.core :as r]
            [sci.core :as sci]))

(defonce user-data
  (lstore/local-storage (r/atom {})
                        :4ever-clojure))

(defn get-problem [id]
  (first
   (filter #(= (:_id %) id) data/problems)))

(defn eval-string [s]
  (sci/eval-string s {:classes {'js goog/global
                                :allow :all}}))

(defn check-solution [problem user-solution]
  (try
    (let [replaced   (mapv #(str/replace % "__" user-solution) (:tests problem))
          results (map eval-string replaced)
          passed (count (filter true? results))
          failed (count (filter false? results))]
      (js/alert (str "Passed: " passed " / Failed: " failed)))
    (catch js/Error e
      (js/alert (gobj/get e "message")))))

(defn input-block [idk solution]
  [:pre
   [:textarea {:name "user-solution"
               :value solution
               :on-change #(swap! user-data assoc idk (-> % .-target .-value))
               :rows 8}]])

(defn view [{:keys [path-params] :as props}]
  (fn [{:keys [path-params] :as props}]
    (let [idn (js/parseInt (:id path-params))
          idk (keyword (:id path-params))
          solution (if (nil? (idk @user-data))
                     ""
                     (idk @user-data))
          problem (get-problem idn)]
      [:div
       [:h3 "Problem " idn]
       [:p (:description problem)]
       [:ul
        (for [[i test] (map vector (range) (:tests problem))]
          ^{:key i}
          [:li
           [:pre
            [:code test]]])]
       [:p "Write code which will fill in the above blanks:"]
       [input-block idk solution]
       [:button {:disabled (-> solution
                               str/trim
                               str/blank?)
                 :on-click #(check-solution problem solution)} "Run"]])))
