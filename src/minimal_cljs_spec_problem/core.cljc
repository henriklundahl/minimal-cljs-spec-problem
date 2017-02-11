(ns minimal-cljs-spec-problem.core
  (:require [clojure.spec :as s]))

#?(:cljs (enable-console-print!))

(defn pred-1?
  [s]
  (println "pred-1?:" s)
  (> (count s) 100))

(defn pred-2?
  [s]
  (println "pred-2?:" s)
  (> (count s) 100))

(defn pred-3?
  [s]
  (println "pred-3?:" s)
  (> (count s) 100))

(defn validate []
  (s/valid? (s/and string? pred-1? pred-2? pred-3?) "a"))
