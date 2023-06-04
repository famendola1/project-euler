(ns euler001
  "Add all the natural numbers below one thousand that are multiples of 3 or 5.")

(defn solve [n]
  (apply + (distinct (concat (range 3 n 3)
                             (range 5 n 5)))))

(println (solve 1000))
