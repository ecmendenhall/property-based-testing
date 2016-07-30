import unittest
from prime_factors import prime_factors

class PrimeFactorsTests(unittest.TestCase):

    def test_factors_of_one(self):
        self.assertEqual([], prime_factors(1))

    def test_factors_of_two(self):
        self.assertEqual([2], prime_factors(2))

    def test_factors_of_four(self):
        self.assertEqual([2, 2], prime_factors(4))

    def test_factors_of_eight(self):
        self.assertEqual([2, 2, 2], prime_factors(8))

    def test_factors_of_nine(self):
        self.assertEqual([3, 3], prime_factors(9))

    def test_factors_of_thirty(self):
        self.assertEqual([2, 3, 5], prime_factors(30))

    def test_factors_of_seventeen(self):
        self.assertEqual([17], prime_factors(17))

    def test_factors_of_some_big_number(self):
        primes = [2, 2, 2, 3, 5, 7, 7, 11, 13]
        some_big_number = reduce(lambda a, b: a * b, primes)
        self.assertEqual(primes, prime_factors(some_big_number))


if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(PrimeFactorsTests)
    unittest.TextTestRunner().run(suite)
