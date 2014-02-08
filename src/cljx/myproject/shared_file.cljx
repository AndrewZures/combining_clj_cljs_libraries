(ns myproject.shared-file
  (:require [myproject.platform :as platform]))

(defn multiply [x y]
  (* x y))

(defn absolute-difference [x y]
  (- (platform/absolute-val x) (platform/absolute-val y)))
