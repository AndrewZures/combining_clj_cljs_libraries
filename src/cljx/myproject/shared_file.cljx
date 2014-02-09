(ns myproject.shared-file
  (#+clj :require #+cljs :require-macros
            [myproject.macros :as macros])
  (:require [myproject.platform :as platform])
  )

(defn multiply [x y]
  (* x y))

(defn abs-diff [x y]
  (platform/abs (- (platform/abs x) (platform/abs y))))
