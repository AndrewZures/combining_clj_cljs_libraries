(ns myproject.macros
  ;(:require [myproject.platform]) ;uncommenting will break cljs tests
  )

(defmacro abs [x]
  `(myproject.platform/abs ~x))

