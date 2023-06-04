(ns euler005
  "2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.

  What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20")

(defn- gcd [x y]
  (if (zero? y) x (recur y (mod x y))))

(defn- lcm [x y]
  (quot (* x y) (gcd x y)))

(defn solve [n]
  (reduce lcm (range 1 n)))

(println (solve 20))
