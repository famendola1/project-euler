(ns lib.primes
  (:require [lib.numbers :refer [rotate divisors-up-to sqrt truncate-left truncate-right]])
  (:import java.util.PriorityQueue))


;; Source: https://cuddly-octo-palm-tree.com/posts/2021-12-05-sieve/

(def wheel2357
  (cycle [2 4 2 4 6 2 6 4 2 4 6 6 2 6 4 2 6 4 6 8 4 2 4 2 4 8
          6 4 6 2 4 6 2 6 6 4 2 4 6 2 6 4 2 4 2 10 2 10]))

(defn- insert-prime [^java.util.PriorityQueue table x xs]
  (.add table [(* x x) (map #(* x %) xs)])
  table)

(defn- sieve
  ([[i & is]] (sieve
               is
               (insert-prime
                (PriorityQueue. 10 (fn [[x] [y]] (< x y)))
                i is)))
  ([[x & xs] ^java.util.PriorityQueue table]
   (let [[next-composite] (.peek table)]
     (if (> next-composite x)
       (cons x (lazy-seq (sieve xs (insert-prime table x xs))))
       (do (while (== x (first (.peek table)))
             (let [[_ [f & fs]] (.poll table)]
               (.add table [f fs])))
           (sieve xs table))))))

(defn- spin [[x & xs] n]
  (cons n (lazy-seq (spin xs (+ n x)))))

(def primes
  (concat [2 3 5 7 11] (sieve (spin wheel2357 11))))

(defn is-prime? [n]
  (if (< n 2)
    false
    (= 1 (count (divisors-up-to n (sqrt n))))))

(defn prime-divisors [n]
  (filter is-prime? (divisors-up-to n (sqrt n))))

(defn is-circular-prime? [n]
  (every? is-prime? (take (count (str n)) (rotate n))))

(defn is-truncatable? [n]
  (every? is-prime? (distinct (sort (concat (truncate-left n) (truncate-right n))))))
