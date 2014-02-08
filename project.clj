(defproject myproject "0.1.0-SNAPSHOT"
  :description "Combining Clojure and ClojureScript Libraries"

  :dependencies [[org.clojure/clojure "1.5.1"]
                 [speclj "2.9.4"]
                 [com.keminglabs/cljx "0.3.1"]]

  :plugins [[speclj "2.9.4"]]

  :aliases {  "clj-test" ["do" "clean," "with-profile","clj","spec"]
              "clj-test-auto"  ["do" "clean," "with-profile","clj","spec", "-a"]
              "cljs-test" ["do" "clean," "cljx," "with-profile","cljs", "cljsbuild", "test"]
              "cljs-test-auto" ["do" "clean," "with-profile","cljs", "cljsbuild", "auto"]
            }


  :profiles {
             :dev {
                   }

             :clj {
                    :source-paths ["src/clj", "target/generated/src/clj"]
                    :test-paths ["spec/clj", "target/generated/spec/clj"]
                   }

             :cljs {:dependencies [[org.clojure/clojurescript "0.0-2014"] ;necessary or current version of speclj
                                   [org.clojure/tools.reader "0.7.10"] ;necessary or current version of speclj
                                   [lein-cljsbuild "1.0.2"]]
                    :plugins [[lein-cljsbuild "1.0.2"]]

                    :cljsbuild ~(let [run-specs ["bin/speclj" "target/tests.js"]]
                                  {:builds
                                   {:dev {:source-paths ["src/cljs" 
                                                         "spec/cljs"
                                                         "target/generated/src/cljs"
                                                         "target/generated/spec/cljs"] 
                                          :compiler {:output-to "target/tests.js"
                                                     :pretty-print true}
                                          }}
                                   :test-commands {"test" run-specs}})

                    }
             }

  :hooks [cljx.hooks]
  :cljx {:builds [{:source-paths ["src/cljx"]
                   :output-path "target/generated/src/clj"
                   :rules :clj}
                  {:source-paths ["src/cljx"]
                   :output-path "target/generated/src/cljs"
                   :rules :cljs}
                  {:source-paths ["spec/cljx"]
                   :output-path "target/generated/spec/clj"
                   :rules :clj}
                  {:source-paths ["spec/cljx"]
                   :output-path "target/generated/spec/cljs"
                   :rules :cljs}]}
  )
