(ns app.editor-settings
  (:require
   [app.state :refer [db]]
   [reagent.core :as r]))

(def editor-settings (r/cursor db [:editor-settings]))

(defn mk-editor-settings-state [extension-mode]
  {:extension-mode extension-mode})

(defn save-editor-settings! [new-state]
  (reset! editor-settings new-state))

(defn modal-content [on-change-settings]
  (let [editor-extension-mode (r/atom (:extension-mode @editor-settings))]
    [:div ^{:key "header"}
     ^{:key "settings"}
     [:div
      [:div {:style {:display "flex" :align-items "center" :gap 6}}
       [:input {:type "checkbox"
                :id "checkbox-editor-is-extended-mode"
                :checked (= :extended @editor-extension-mode)
                :on-change (fn [e]
                             (let [new-mode (if (-> e
                                                    .-target
                                                    .-checked)
                                              :extended
                                              :basic)]
                               (let [new-state (mk-editor-settings-state
                                                new-mode)]
                                 (save-editor-settings! new-state)
                                 (on-change-settings new-state))))}]
       [:label {:for "checkbox-editor-is-extended-mode"} "Use extended input mode (can be somewhat intrusive)"]]]]))
