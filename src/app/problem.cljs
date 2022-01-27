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
  (let [replaced (mapv #(str/replace % "__" user-solution) (:tests problem))
        results  (map eval-string replaced)
        passed   (count (filter true? results))
        failed   (count (filter false? results))]
    (swap! user-data assoc (:id problem) {:code   user-solution
                                          :passed passed
                                          :failed failed})
    (if (or (> failed 0) (> passed 0))
      results
      (throw (ex-info "Evaluation error" {:stacktrace (first results)})))))

(def results-style {:width "100%"
                    :display "flex"
                    :font-family "monospace"
                    :justify-content "space-between"})

(defn modal-results-section [results tests id]
  (let [test-attempts (map vector tests results)]
    [:div
     [:h4 (str "Results " "#" id )]
     [:hr ]
     (for [[i [test passed?]] (map-indexed vector test-attempts)]
       ^{:key i}
       [:p {:style results-style}
        [:span test]
        (if passed?
          [:span {:style {:color "green"}} "🟢 pass"]
          [:span {:style {:color "red" }} "🔴 uh-oh"])])]))

(defn restricted-alert [problem]
  [:p
   {:style {:color "#FF0000",
            :border-color "darkred",
            :border-style "dashed",
            :padding "10px"}} "Special Restrictions : "
   (str/join "," (:restricted problem))])

(defn user-code-section [id problem solution]
  (r/with-let [code (r/atom (if-let [code (:code solution "")]
                              ;; can sometimes be {:code nil}
                              code ""))
               !editor-view (r/atom nil)
               get-editor-value #(some-> @!editor-view .-state .-doc str)
               results (r/atom '())
               modal-is-open (r/atom false)
               modal-on-close #(reset! modal-is-open false)
               error-stacktrace (r/atom nil)]
    (let [next-prob (some #(when (> (:id %) id) %) data/problems)
          on-run (fn []
                   (try
                       (let [attempts (check-solution problem (get-editor-value))]
                         (when attempts
                           (reset! results attempts)
                           (reset! modal-is-open true)))
                       (catch ExceptionInfo e
                         (reset! error-stacktrace (-> e ex-data :stacktrace)))))]
      [:div
       (when (:restricted problem)
         [restricted-alert problem])
       [:p "Write code which will fill in the above blanks:"]
       [editor/editor @code !editor-view {:eval? true}]
       [:button {:on-click on-run
                 :style {:margin-top "1rem"}}
        "Run"]
       [:p {:style {:margin-top "1rem"}}
        [:small
         "Alt+Enter will eval the local form in the editor box above. There are
          lots of nifty such features and keybindings. More docs coming soon! (Try
          playing with alt + arrows / ctrl + enter) in the meanwhile."]]
       [modal/box {:is-open modal-is-open
                   :on-close modal-on-close}
        [modal-results-section @results (:tests problem) (:id problem)]
        [:div
         [:p {:on-click #(reset! modal-is-open false)}
          "Next problem "
          [:a {:href (state/href :problem/item {:id (:id next-prob)})}
           (str "#" (:id next-prob) " " (:title next-prob))]]]
      ]])))

(defn view [_]
  (fn [{:keys [path-params] :as _props}]
    (let [id (js/parseInt (:id path-params))
          solution (get @user-data id)
          problem (get-problem id)]
      [:div
       [:h3 "Problem " id]
       [:p (:description problem)]
       [:ul
        (doall
         (for [[i test] (map-indexed vector (:tests problem))]
           ^{:key i}
           [:li
            [:pre
             [:code test]]]))]
       ^{:key (str "problem-" id)}
       [user-code-section id problem solution]
       [:hr]
       [:p
        "Want to see how others have solved this? "
        [:a {:href (state/href :solution/list {:id id})}
         "View problem #" id " solutions archive"]
        " No cheating please! :)"]
       ])))
