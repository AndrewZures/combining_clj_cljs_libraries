(defn test-stuff
  (:require-macros [speclj :refer [describe it should]])
  (:require [speclj.core]))

(describe "test"
  (it "tests someting"
      (should= 1 1)))
