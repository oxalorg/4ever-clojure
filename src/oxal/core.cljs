(ns oxal.core
  (:require [reagent.core :as r]
            [reagent.dom :as rdom]))

(js/alert "Hello world!")

(defn my-counter []
  (let [counter (r/atom 0)]
    (fn []
      [:div
       [:h2 "Hello this is a counter!"]
       [:h3 @counter]
       [:button {:on-click #(swap! counter inc)} "+"]
       [:button {:on-click #(swap! counter dec)} "-"]])))

(rdom/render [my-counter]
             (js/document.getElementById "my-root"))
