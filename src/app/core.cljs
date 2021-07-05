(ns app.core
  (:require [reagent.core :as r]
            [app.data :as data]
            [app.routes :as routes]
            [reagent.dom :as rdom]))

(defn main []
  [:div
   (if-let [match @routes/match]
     (let [view (:view (:data match))]
       [view match]))])

(defn mount []
  (rdom/render
   [main]
   (js/document.getElementById "app")))

(defn init! []
  (routes/init!)
  (mount))

(init!)
