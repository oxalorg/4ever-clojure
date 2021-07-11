(ns app.problem
  (:require [app.data :as data]
            [app.editor :as editor]
            [app.sci :refer [eval-string]]
            [app.state :as state :refer [db]]
            [clojure.string :as str]
            [goog.object :as gobj]
            [reagent.core :as r]
            [app.modal :as modal]))

(def user-data (r/cursor db [:solutions]))

(defn get-problem [id]
  (first
   (filter #(= (:id %) id) data/problems)))

(defn check-solution [problem user-solution]
  (try
    (let [replaced (mapv #(str/replace % "__" user-solution) (:tests problem))
          results  (map eval-string replaced)
          passed   (count (filter true? results))
          failed   (count (filter false? results))]
      (swap! user-data assoc (:id problem) {:code   user-solution
                                            :passed passed
                                            :failed failed})
      #_(js/alert (str "Passed: " passed " Failed: " failed))
      (if (or (> failed 0) (> passed 0))
        (do (modal/show) results)
        (js/alert (first results))))
    (catch js/Error e
      (js/alert (gobj/get e "message")))))

(defn user-code-section [id problem solution]
  (r/with-let [code (r/atom (:code solution ""))
               !editor-view (r/atom nil)
               get-editor-value #(some-> @!editor-view .-state .-doc str)
               results (r/atom '())]
    [:div
     [:p "Write code which will fill in the above blanks:"]
     (when (:restricted problem) [:p {:style {:color "#FF0000" :border-color "darkred"
                                              :border-style "dashed" :padding "10px"}}
                                  "Special Restrictions : "
                                  (str/join "," (:restricted problem))])

     [editor/editor @code !editor-view {:eval? true}]
     [:button {:on-click #(swap! results (fn [] (check-solution problem (get-editor-value))))
               :style {:margin-top "1rem"}} "Run"]
     [:p {:style {:margin-top "1rem"}}
      [:small
       "Alt+Enter will eval the local form in the editor box above. There are
        lots of nifty such features and keybindings. More docs coming soon! (Try
        playing with alt + arrows / ctrl + enter) in the meanwhile."]]
     (when @modal/show-modal? [modal/box @results (:tests problem) (:id problem)])]))

(defn view [_]
  (fn [{:keys [path-params] :as _props}]
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
