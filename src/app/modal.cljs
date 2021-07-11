(ns app.modal)

(def modal-style {:position "fixed",
                  :width "700px"
                  :top "50%",
                  :left "50%",
                  :transform "translate(-50%, -50%)",
                  :background "white",
                  :borderRadius "5px",
                  :boxShadow "0 0 0 100vw rgba(0, 0, 0, 0.5)",
                  :padding "0px 30px 20px 30px",
                  :zIndex "9999"})

(defn box [{:keys [is-open on-close]} & children]
  (when @is-open
    [:div {:style modal-style}
     children
     [:button {:on-click on-close} "Close"]]))


