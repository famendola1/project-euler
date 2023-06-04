(ns lib.numbers
  (:require [clojure.math :as math]))

(defn sqrt [n]
  (long (math/sqrt n)))

(defn- sum [n]
  (reduce + (range (inc n))))

(def triangles
  (map sum (lazy-seq (iterate inc 1))))

(defn divisors-up-to [n max]
  (filter #(zero? (rem n %))
          (range 1 (inc max))))

(defn divisors [n]
  (divisors-up-to n n))

(defn- rotate-string [s]
  (let [h (first s)
        r (subs s 1)]
    (cons s (lazy-seq (rotate-string (str r h))))))

(defn rotate [n]
  (map #(Integer/parseInt %) (rotate-string (str n))))

(defn exp [x n]
  (reduce * (repeat n x)))

(defn num-rest [n]
  (if (> n 10)
    (Integer/parseInt (apply str (rest (str n))))
    0))

(defn num-butlast [n]
  (if (> n 10)
    (Integer/parseInt (apply str (butlast (str n))))
    0))

(defn truncate-left [n]
  (take-while pos? (iterate num-rest n)))

(defn truncate-right [n]
  (take-while pos? (iterate num-butlast n)))

