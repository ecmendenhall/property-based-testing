(ns prime-factors.core-test
  (:require [clojure.test :refer :all]
            [prime-factors.core :refer :all]))

(deftest test-factors-of-one
  (testing "returns [] for 1"
    (is (= [] (prime-factors 1)))))

(deftest test-factors-of-two
  (testing "returns [2] for 2"
    (is (= [2] (prime-factors 2)))))

(deftest test-factors-of-two
  (testing "returns [2 2] for 4"
    (is (= [2 2] (prime-factors 4)))))

(deftest test-factors-of-eight
  (testing "returns [2 2 2] for 8"
    (is (= [2 2 2] (prime-factors 8)))))

(deftest test-factors-of-nine
  (testing "returns [3 3 3] for 9"
    (is (= [3 3] (prime-factors 9)))))

(deftest test-factors-of-thirty
  (testing "returns [2 3 5] for 30"
    (is (= [2 3 5] (prime-factors 30)))))

(deftest test-factors-of-seventeen
  (testing "returns [17] for 17"
    (is (= [17] (prime-factors 17)))))

(deftest test-factors-of-some-very-big-number
  (testing "returns all factors when a bunch of primes are multiplied"
    (is (= [2 2 2 3 5 7 7 11 13]
           (prime-factors (* 2 2 2 3 5 7 7 11 13))))))
