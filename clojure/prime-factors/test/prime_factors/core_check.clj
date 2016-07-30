(ns prime-factors.core-check
  (:require [clojure.test :refer :all]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check.clojure-test :refer :all]
            [prime-factors.core :refer :all]))

(def primes (map read-string (clojure.string/split (slurp "../../primes.txt") #"\s+")))

(deftest one-has-no-prime-factors
  (testing "returns [] for 1"
    (is (= [] (prime-factors 1)))))

(defspec check-primes-have-one-prime-factor
  10
  (testing "A prime number's only prime factor is itself"
    (prop/for-all [prime (gen/elements primes)]
      (= [prime] (prime-factors prime)))))

(defspec check-two-times-prime-has-two-prime-factors
  1000
  (testing "Factoring 2 * prime returns 2 and the prime"
    (prop/for-all [prime (gen/elements primes)]
      (= [2 prime] (prime-factors (* 2 prime))))))

(defspec check-prime-times-prime-has-two-prime-factors
  1000
  (testing "Factoring prime * prime returns both primes"
    (prop/for-all [prime-one (gen/elements primes)
                   prime-two (gen/elements primes)]
      (= (set [prime-one prime-two])
         (set (prime-factors (* prime-one prime-two)))))))

(defspec check-prime-times-prime-has-two-prime-factors
  1000
  (testing "Factoring prime * prime returns both primes"
    (prop/for-all [prime-one (gen/elements primes)
                   prime-two (gen/elements primes)]
      (= (set [prime-one prime-two])
         (set (prime-factors (* prime-one prime-two)))))))

(defspec check-product-of-a-series-of-primes-returns-all-primes
  1000
  (testing "Factoring the product of a series of primes returns all the primes"
    (prop/for-all [prime-seq (gen/vector (gen/elements primes))]
      (= (sort prime-seq)
         (prime-factors (apply *' prime-seq))))))
