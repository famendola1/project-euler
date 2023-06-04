(ns euler004
  "A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

  Find the largest palindrome made from the product of two 3-digit numbers.")

(defn- is-palindrome? [n]
  (let [s (str n)
        mid (/ (count s) 2)]
    (= (subs s 0 mid)
       (apply str (reverse (subs s (if (odd? (count s)) (+ 1 mid) mid)))))))

(defn- three-digit-products []
  (for [x (range 100 999)
        y (range 100 999)]
    (* x y)))

(defn solve []
  (apply max (filter is-palindrome? (three-digit-products))))

(println (solve))
