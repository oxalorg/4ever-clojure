(ns app.state
  (:require [reitit.frontend :as rf]
            [reitit.frontend.controllers :as rfc]
            [reitit.frontend.easy :as rfe]))

(def navigate rfe/push-state)

(def href rfe/href)
