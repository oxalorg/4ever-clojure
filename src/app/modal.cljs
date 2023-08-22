(ns app.modal
  (:require [goog.string :refer [unescapeEntities]]))

(def modal-style {:position "fixed",
                  :width "700px"
                  :max-width "100%"
                  :top "50%",
                  :left "50%",
                  :transform "translate(-50%, -50%)",
                  :background "white",
                  :borderRadius "5px",
                  :boxShadow "0 0 0 100vw rgba(0, 0, 0, 0.5)",
                  :zIndex "9999"})

(defn close-button [on-close] 
  [:button {:aria-label "Close Dialog" 
            :style {:font-size "2.5rem"
                    :padding "unset"
                    :background "unset"
                    :border "unset"
                    :color "#000"
                    :margin-top "1rem" 
                    :margin-bottom 0} 
            :on-click on-close} 
   (unescapeEntities "&times")])

(defn box [{:keys [is-open on-close]} & children]
  (when @is-open
    [:div {:style modal-style}
     [:div {:style {:padding "0px 30px 20px 30px"}}
      children
      [:button {:on-click on-close} "Close"]]]))


