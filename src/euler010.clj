(ns euler010
  "The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.

  Find the sum of all the primes below two million."
  (:require [lib.primes :refer [primes]]))

(defn solve [n]
  (reduce + (take-while #(> n %) primes)))

(println (solve 2000000))
