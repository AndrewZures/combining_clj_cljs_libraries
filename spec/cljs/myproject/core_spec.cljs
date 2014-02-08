(ns test-spec
  (:require-macros [speclj.core :refer [describe it should=]])
  (:require [speclj.core]
            [myproject.core :as my-core]))

(describe "test"
 (it "tests someting"
     (should= (my-core/add 1 2) 3))
)
