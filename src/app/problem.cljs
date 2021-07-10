(ns app.problem
  (:require [app.data :as data]
            [app.state :as state :refer [db]]
            [app.editor :as editor]
            [clojure.string :as str]
            [goog.object :as gobj]
            [reagent.core :as r]
            [sci.core :as sci]))

(def user-data (r/cursor db [:solutions]))

(defn get-problem [id]
  (first
   (filter #(= (:_id %) id) data/problems)))

(defn eval-string [s]
  (sci/eval-string s {:classes {'js goog/global
                                :allow :all}}))

(defn check-solution [problem user-solution]
  (try
    (let [replaced (mapv #(str/replace % "__" user-solution) (:tests problem))
          results  (map eval-string replaced)
          passed   (count (filter true? results))
          failed   (count (filter false? results))]
      (swap! user-data assoc (:_id problem) {:code   user-solution
                                             :passed passed
                                             :failed failed})
      (js/alert (str "Passed: " passed " / Failed: " failed)))
    (catch js/Error e
      (js/alert (gobj/get e "message")))))

(defn user-code-section [id problem solution]
  (r/with-let [code (r/atom (:code solution ""))
               !editor-view (r/atom nil)
               get-editor-value #(some-> @!editor-view .-state .-doc str)]
    [:div
     [:p "Write code which will fill in the above blanks:"]
     [editor/editor @code !editor-view {:eval? true}]
     [:button {:on-click #(check-solution problem (get-editor-value))
               :style {:margin-top "1rem"}} "Run"]
     [:p {:style {:margin-top "1rem"}}
      [:small
       "Alt+Enter will eval the local form in the editor box above. There are
        lots of nifty such features and keybindings. More docs coming soon! (Try
        playing with alt + arrows / ctrl + enter) in the meanwhile."]]]))

(defn view [{:keys [path-params] :as props}]
  (fn [{:keys [path-params] :as props}]
    (let [id (js/parseInt (:id path-params))
          solution (get @user-data id)
          problem (get-problem id)]
      [:div
       [:h3 "Problem " id]
       [:p (:description problem)]
       [:ul
        (for [[i test] (map-indexed vector (:tests problem))]
          ^{:key i}
          [:li
           [:pre
            [:code test]]])]
       [user-code-section id problem solution]])))
