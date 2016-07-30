(ns prime-factors.core)

(defn trial-division  [n divisor factors]
  (if (< n 2)
    factors
    (if (= 0 (mod n divisor))
      (recur (/ n divisor) divisor (conj factors divisor))
            (recur n (inc divisor) factors))))

(defn prime-factors [n]
  (trial-division n 2 []))
