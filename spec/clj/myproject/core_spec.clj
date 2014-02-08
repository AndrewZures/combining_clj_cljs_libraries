(ns myproject.core-spec
  (:require [speclj.core :refer :all]
            [myproject.core :refer :all])
  )

(describe "test"
 (it "tests someting"
     (should= (add 1 2) 3))
)
