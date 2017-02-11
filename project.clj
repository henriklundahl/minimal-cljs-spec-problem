(defproject minimal-cljs-spec-problem "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.473"]]
  :plugins [[lein-cljsbuild "1.1.5"]]
  :repl-options {:init-ns minimal-cljs-spec-problem.core}
  :cljsbuild {:builds
              {:dev {:compiler {:asset-path "/js"
                                :main minimal-cljs-spec-problem.core
                                :optimizations :none
                                :output-dir "resources/js"
                                :output-to "resources/js/main.js"
                                :source-map true
                                :verbose false}
                     :source-paths ["src"]}}})
