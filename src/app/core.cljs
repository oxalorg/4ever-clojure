(ns app.core
  (:require [reagent.core :as r]
            [app.data :as data]
            [app.routes :as routes]
            [reagent.dom :as rdom]))

(defn header []
  [:header
   [:h1 "4ever-clojure"]
   [:p
    [:small
     [:a {:href "/"} "home"]
     " | "
     [:a {:href "https://github.com/oxalorg/4ever-clojure"} "github"]
     " | "
     "Built with ❤ by "
     [:a {:href "https://twitter.com/oxalorg"} "@oxalorg"]
     " and "
     [:a {:href "https://twitter.com/lambdaisland"} "@lambdaisland"]]]])

(defn main []
  [:div
   [header]
   (if-let [match @routes/match]
     (let [view (:view (:data match))]
       [view match]))])

(defn ^:dev/after-load mount []
  (rdom/render
   [main]
   (js/document.getElementById "app")))

(defn init! []
  (routes/init!)
  (mount))

(init!)
