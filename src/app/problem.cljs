(ns app.problem
  (:require
   [app.data :as data]
   [app.editor :as editor]
   [app.editor-settings :as editor-settings]
   [app.modal :as modal]
   [app.sci :refer [eval-string] :as evaluator]
   [app.state :as state :refer [db]]
   [clojure.string :as str]
   [reagent.core :as r]))

(def user-data (r/cursor db [:solutions]))

(defn get-problem [id]
  (first
   (filter #(= (:id %) id) data/problems)))

(defn next-problem [id]
  (some #(when (> (:id %) id) %) data/problems))

(defn passed? [attempt]
  (true? (::evaluator/result attempt)))

(defn result-type [attempt]
  (cond
    (::evaluator/error-str attempt) ::error
    (passed? attempt) ::passed
    :else ::failed))

(defn check-solution [problem user-solution]
  (let [replaced (mapv #(str/replace % "__" user-solution) (:tests problem))
        results  (map eval-string replaced)
        grouped-results (group-by result-type results)]
    (swap! user-data assoc (:id problem) {:code   user-solution
                                          :passed (count (grouped-results ::passed))
                                          :failed (+ (count (grouped-results ::failed))
                                                     (count (grouped-results ::error)))})
    (if-let [[first-error] (seq (grouped-results ::error))]
      {:error first-error}
      {:results results})))

(def results-style {:display "flex"
                    :flex-direction "row"
                    :flex-wrap "wrap"
                    :font-family "monospace"})

(defn render-result [test-src maybe-result]
  [:li
   [:pre
    [:code {:style results-style}
     [:span test-src]
     (when maybe-result maybe-result)]]])

(defn result-list [items]
  [:ul {:style {:list-style "none" :padding 0}}
   items])

(defn test-list-section [tests]
  [result-list
   (doall
    (for [[i test-src] (map-indexed vector tests)]
      ^{:key i}
      [render-result test-src]))])

(defn result-info-item [color text]
  [:span {:style {:color color
                  :align-self "center"
                  :width "4.5em"
                  :margin-left "auto"}}
   text])

(defn test-results-section [attempts tests]
  [result-list
   (let [test-attempts (map vector tests attempts)]
     (for [[i [test-src attempt]] (map-indexed vector test-attempts)]
       ^{:key i}
       [render-result
        test-src
        (if (passed? attempt)
          [result-info-item "green" "🟢 pass"]
          [result-info-item "red"   "🔴 uh-oh"])]))])

(def run-button-style {:margin-top "1rem"})

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
               editor-extension-mode (r/atom
                                      (:extension-mode
                                       @editor-settings/editor-settings))
               get-editor-value #(some-> @!editor-view .-state .-doc str)
               attempts-atom (r/atom '())
               attempt-error-str (r/atom nil)
               success-modal-is-open (r/atom false)
               success-modal-on-close #(reset! success-modal-is-open false)
               settings-modal-is-open (r/atom false)
               settings-modal-on-close #(reset! settings-modal-is-open false)
               solution-attempted (r/atom false)
               tests (:tests problem)]
    (let [next-prob (next-problem id)
          next-prob-href (state/href :problem/item {:id (:id next-prob)})
          on-run (fn []
                   (let [editor-value (get-editor-value)
                         _ (reset! code editor-value)
                         {:keys [results error]} (check-solution problem editor-value)]
                     (if error
                       (reset! attempt-error-str (::evaluator/error-str error))
                       (do
                         (reset! attempt-error-str nil)
                         (reset! attempts-atom results)
                         (reset! solution-attempted true)
                         (when (every? passed? results)
                           (reset! success-modal-is-open true))))))]
      [:div
       (if @solution-attempted
         [test-results-section @attempts-atom tests]
         [test-list-section tests])
       (when (:restricted problem)
         [restricted-alert problem])
       [:p "Write code which will fill in the above blanks:"]

       ;; Force resetting editor state when input source code changed
       ;; e.g., when manually trigger run
       ^{:key [@code @editor-extension-mode]}
       [editor/editor
        @code
        !editor-view
        @attempt-error-str
        {:eval? true
         :extension-mode @editor-extension-mode}]
       [:div {:style {:display "flex"
                      :justify-content "space-between"}}
        [:button {:on-click on-run
                  :style run-button-style}
         "Run"]
        [:button {:on-click #(reset! settings-modal-is-open true)
                  :style run-button-style}
         "Settings"]]
       [modal/box {:is-open settings-modal-is-open
                   :on-close settings-modal-on-close}
        [editor-settings/modal
         (fn [{:keys [extension-mode] :as _editor-settings}]
           (reset! code (get-editor-value))
           (reset! editor-extension-mode extension-mode))]]
       [:p {:style {:margin-top "1rem"}}
        [:small
         "Alt+Enter will eval the local form in the editor box above, and Tab will format the code. There are
          lots of nifty such features and keybindings. More docs coming soon! (Try
          playing with alt + arrows / ctrl + enter / tab) in the meanwhile.
          For documentation try e.g. (doc map)."]]
       [modal/box {:is-open success-modal-is-open
                   :on-close success-modal-on-close}
        [:h4 (str "Congratulations on solving problem " "#" id "!")]
        [:div
         [:p {:on-click #(reset! success-modal-is-open false)}
          "Next problem "
          [:a {:href next-prob-href}
           (str "#" (:id next-prob) " " (:title next-prob))]]]
        [:button {:on-click #(set! js/window.location next-prob-href)} "Next Problem"]]])))

(defn view [_]
  (fn [{:keys [path-params] :as _props}]
    (let [id (js/parseInt (:id path-params))
          solution (get @user-data id)
          {:keys [title description difficulty] :as problem} (get-problem id)]
      [:div
       [:h3 "Problem " id ", " title]
       [:div {:style {:margin-top "0.5rem" :margin-bottom "2rem"}}
        [:b "Difficulty: "] difficulty]
       [:p description]
       ^{:key (str "problem-" id)}
       [user-code-section id problem solution]
       [:hr]
       [:p
        "Want to see how others have solved this? "
        [:a {:href (state/href :solution/list {:id id})}
         "View problem #" id " solutions archive"]
        " No cheating please! :)"]])))
