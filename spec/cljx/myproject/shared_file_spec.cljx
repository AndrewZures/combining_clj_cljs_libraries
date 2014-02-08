(ns myproject.shared-file-spec
  (#+clj :require #+cljs :require-macros [speclj.core :refer [describe it should=]])
  (:require [speclj.core]
            [myproject.shared-file :as shared-file]))

(describe "sample cljx file"

  (it "uses cljx files to generate tested code in clj an cljx"
      (should= 12 (shared-file/multiply 3 4)))
)
