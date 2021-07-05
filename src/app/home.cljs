(ns app.home)

(defn header []
  [:header
   [:h1 "4ever-clojure"]
   [:p "Keeping 4clojure alive forever! This website is completely static and evals code using sci."]
   [:p "If people start using this we can think about adding a simple ranking system using something like firebase."]]
  )

(defn view []
  [:div
   [header]]
  )
