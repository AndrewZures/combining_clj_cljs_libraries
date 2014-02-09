(ns myproject.macros
  ;(:require [myproject.platform]) ;uncommenting will break cljs tests
  )

(defn cljs? []
    (boolean (find-ns 'cljs.analyzer)))

(defmacro when-not-bound [name & body]
  (if (cljs?)
    `(when-not ~name)
    `(when-not (bound? (find-var '~name)))))


; 1. ClojureScript error handling
;Clojure won't know what to do with js/Object
;try it - uncomment function below:
;   if you run "lein cljs-clean-test" - it will pass
;   if you run "lein clj-clean-test" - it will fail
;
;(defmacro slurpable-file? [file-name]
;  `(try
;     (slurp ~file-name)
;     (catch js/Object e# true)))



; 2. Clojure error handling
;ClojureScript won't know what to do with Exception
;try it: uncomment function below and run "lein cljs-clean-test"
;   if you run "lein clj-clean-test" - tests will pass
;   if you run "lein cljs-clean-test" - tests will fail

;(defmacro slurpable-file? [file-name]
;  `(try
;     (slurp ~file-name)
;     (catch Exception e# true)))
;

; 3. Checking macro context and applying correct error handling
; the code below will work for both platforms

(defmacro slurpable-file? [file-name]
  `(try
     (slurp ~file-name)
     ~(if (cljs?)
        '(catch js/Object e# true)
        '(catch Exception e# true)))
  )

(defmacro absolute-value [x]
  `(myproject.platform/absolute-val ~x))

