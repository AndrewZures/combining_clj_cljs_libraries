(ns myproject.platform
  (:require [clojure.math.numeric-tower :refer [abs]]))

(defn absolute-val [num]
  (abs num))
