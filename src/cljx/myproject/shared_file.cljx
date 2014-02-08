(ns myproject.shared-file
  (#+clj :require #+cljs :require-macros
            [myproject.macros :as macros])
  (:require [myproject.platform :as platform])
  )

(defn multiply [x y]
  (* x y))

(defn absolute-difference [x y]
  (- (platform/absolute-val x) (platform/absolute-val y)))

