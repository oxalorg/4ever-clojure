(ns app.core
  (:require [app.routes :as routes]
            [reagent.dom :as rdom]))

(def notification
  [:div {:style {:background-color "#D6D0FD"
                 :position "absolute"
                 :top 0
                 :left 0
                 :width "100%"
                 :text-align "center"
                 :padding "0.5rem"}}
   [:small
    "11th July - New editor based on codemirror & nextjournal/clojure-mode added
    🎉!!"]])

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
     [:a {:href "https://twitter.com/lambdaisland"} "@lambdaisland"]]]
   notification])

(defn main []
  [:div
   [header]
   (when-let [match @routes/match]
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
