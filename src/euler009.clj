(ns euler009
  "A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,

  a^2 + b^2 = c^2
  For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.

  There exists exactly one Pythagorean triplet for which a + b + c = 1000.
  Find the product abc.")

(defn solve [n]
  (for [a (range 1 n)
        b (range (inc a) (- n a))
        :let [c (- n a b)
              sum (+ a b c)
              x (+ (* a a) (*  b b))]
        :when (and (= sum n) (= x (* c c)))]
    (* a b c)))
(println (solve 1000))
