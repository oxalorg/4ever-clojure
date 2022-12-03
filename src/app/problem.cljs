(ns app.problem
  (:require [app.data :as data]
            [app.editor :as editor]
            [app.modal :as modal]
            [app.sci :refer [eval-string]]
            [app.state :as state :refer [db]]
            [clojure.string :as str]
            [reagent.core :as r]))

(def user-data (r/cursor db [:solutions]))

(defn get-problem [id]
  (first
   (filter #(= (:id %) id) data/problems)))

(defn next-problem [id]
  (some #(when (> (:id %) id) %) data/problems))

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

(defn test-attempts [results tests]
  (map vector tests results))

(defn test-attempts-passed? [results tests]
  (every? true? (map #(second %) (test-attempts results tests))))

(defn modal-results-section [results tests id]
  (let [attempts (test-attempts results tests)]
    [:div
     [:h4 (str "Results " "#" id )]
     [:hr ]
     (for [[i [test passed?]] (map-indexed vector attempts)]
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
    (let [next-prob (next-problem id)
          on-run (fn []
                   (try
                     (let [editor-value (get-editor-value)
                           _ (reset! code editor-value)
                           attempts (check-solution problem editor-value)]
                       (when attempts
                         (reset! results attempts)
                         (reset! modal-is-open true)))
                     (catch ExceptionInfo e
                       (reset! error-stacktrace (-> e ex-data :stacktrace)))))]
      [:div
       (when (:restricted problem)
         [restricted-alert problem])
       [:p "Write code which will fill in the above blanks:"]

       ;; Force resetting editor state when input source code changed
       ;; e.g., when manually trigger run
       ^{:key @code} [editor/editor @code !editor-view {:eval? true}]
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
          (if (test-attempts-passed? @results (:tests problem)) 
             [:button {:on-click #(set! (.-location js/window) (state/href :problem/item {:id (:id next-prob)}))}  
              (str "Next problem " "#" (:id next-prob) " " (:title next-prob))]
             [:button {:on-click #(reset! modal-is-open false)} "Return to problem"])]]])))

(defn view [_]
  (fn [{:keys [path-params] :as _props}]
    (let [id (js/parseInt (:id path-params))
          solution (get @user-data id)
          {:keys [title tests description difficulty] :as problem} (get-problem id)]
      [:div
       [:h3 "Problem " id ", " title]
       [:div {:style {:margin-top "0.5rem" :margin-bottom "2rem"}}
        [:b "Difficulty: "] difficulty]
       [:p description]
       [:ul {:style {:list-style "none" :padding 0}}
        (doall
         (for [[i test] (map-indexed vector tests)]
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
