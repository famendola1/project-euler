(ns euler013
  "Work out the first ten digits of the sum of the following one-hundred 50-digit numbers."
  (:require [clojure.java.io :as io]))

(defn solve []
  (with-open [rdr (io/reader "src/data/euler013.txt")]
    (subs (str (reduce (fn [out num]
                (+ out (bigint (subs num 0 11))))
               0
               (line-seq rdr)))
          0
          10)))

(println (solve))
