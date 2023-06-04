(ns euler007
  "By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

  What is the 10 001st prime number?"
  (:require [lib.primes :refer [primes]]))

(defn solve [n]
  (nth primes n))

(println (solve (dec 10001)))
