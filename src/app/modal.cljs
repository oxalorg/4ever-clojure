(ns app.modal
  (:require [goog.string :refer [unescapeEntities]]))

(def modal-style {:width "700px",
                  :max-width "100%",
                  :padding "0",
                  :background "white",
                  :border "unset",
                  :borderRadius "5px",
                  :boxShadow "0 0 0 100vw rgba(0, 0, 0, 0.5)"})

(defn close-button []
  [:button {:aria-label "Close"
            :type "submit"
            :style {:font-size "2.5rem"
                    :padding "unset"
                    :background "unset"
                    :border "unset"
                    :color "#000"
                    :margin-top "1rem"
                    :margin-bottom "-3rem"}}
   (unescapeEntities "&times")])

(defn box [{:keys [id heading]} & children]
  (let [heading-id (str id "-heading")]
    [:dialog {:style modal-style
              :id id
              :aria-labelledby heading-id}
     [:form {:method "dialog"
             :style {:display "flex"
                     :justify-content "flex-end"
                     :padding-right "2rem"}}
      [close-button]]
     [:div {:style {:padding "0px 30px 30px 30px"}}
      [:h4 {:id heading-id} heading]
      children]]))

(defn show [id]
  (.showModal (js/document.getElementById id)))