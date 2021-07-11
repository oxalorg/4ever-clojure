(ns app.modal
  (:require [app.data :as data]
            [app.state :as state]
            [reagent.core :as r]))

(def show-modal? (r/atom false))

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

(def results-style {:width "100%"
                    :display "flex"
                    :font-family "monospace"
                    :justify-content "space-between"})

(defn show []
  (swap! show-modal? (fn [] true)))

(defn close []
  (swap! show-modal? (fn [] false)))

(defn box [results tests id]
  (let [test&res (map #(cons %1 (list %2)) tests results)
        next-prob (first (take 1 (filter #(> (:id %) id) data/problems)))]
    [:div {:style modal-style}
     [:h4 (str "Results " "#" id )] [:hr ]
     (for [[i t&r] (map-indexed vector test&res)]
       ^{:key i}
       [:p {:style results-style} [:span (first t&r)]
        (if (last t&r)
          [:span {:style {:color "green"}} "✓ complete"]
          [:span {:style {:color "red" }} "! uh-oh"])])
     [:div {:style {:display "flex" :justify-content "space-between"}}
      [:button {:on-click close} "close"]
      [:span {:on-click close} "Next: " 
       [:a {:href (state/href :problem/item {:id (:id next-prob)})}
        (str "#" (:id next-prob) " " (:title next-prob))]]]]))


