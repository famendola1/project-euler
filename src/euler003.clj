(ns euler003
  "The prime factors of 13195 are 5, 7, 13 and 29.

  What is the largest prime factor of the number 600851475143 ?"
  (:require [lib.primes :refer [prime-divisors]]))

(defn solve [n]
  (apply max (prime-divisors n)))

(println (solve 600851475143))

