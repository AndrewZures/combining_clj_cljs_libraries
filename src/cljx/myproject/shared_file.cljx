(ns myproject.shared-file
  (:require [myproject.platform :as platform]))

(defn multiply [x y]
  (* x y))

(defn abs-diff [x y]
  (- (platform/abs x) (platform/abs y)))
