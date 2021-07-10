(ns app.problem
  (:require [app.data :as data]
            [app.state :as state :refer [db]]
            [clojure.string :as str]
            [goog.object :as gobj]
            [reagent.core :as r]
            [sci.core :as sci]
            ["react-ace" :as AceEditorImport]
            ["ace-builds/src-noconflict/theme-dracula"]
            ["ace-builds/src-noconflict/mode-clojure"]))

(def AceEditor (.-default AceEditorImport))

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
  (r/with-let [code (r/atom (:code solution ""))]
    [:div
     [:p "Write code which will fill in the above blanks:"]
     (when (:restricted problem) [:p {:style {:color "#FF0000" :border-color "darkred"
                                              :border-style "dashed" :padding "10px"}}
                                  "Special Restrictions : "
                                  (str/join "," (:restricted problem))])
     [:div {:style {:marginBottom "2.5rem"}}
      [:> AceEditor
       {:mode      :clojure
        :theme     :dracula
        :name      "user-solution"
        :value     @code
        :style     {:borderRadius "5px"}
        :maxLines  15
        :minLines  15
        :on-change #(reset! code %)}]]
     [:button {:disabled (-> @code str/trim str/blank?)
               :on-click #(check-solution problem @code)} "Run"]]))

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
