import unittest

from hypothesis import given
from hypothesis.strategies import sampled_from, lists

from prime_factors import prime_factors

PRIMES = [int(n) for n in open('../primes.txt').read().split()]
PRIMES = PRIMES[:150]

class PrimeFactorsTests(unittest.TestCase):

    @given(sampled_from(PRIMES))
    def test_a_primes_only_prime_factor_is_itself(self, prime):
        self.assertEqual([prime], prime_factors(prime))

    @given(sampled_from(PRIMES))
    def test_factoring_two_times_prime_returns_two_and_prime(self, prime):
        self.assertEqual([2, prime], prime_factors(2 * prime))

    @given(sampled_from(PRIMES))
    def test_factoring_prime_times_prime_returns_prime_and_prime(self, prime):
        self.assertEqual([prime, prime], prime_factors(prime * prime))

    @given(lists(elements=sampled_from(PRIMES), min_size=1))
    def test_factoring_product_of_primes_returns_all_primes(self, primes):
        some_big_number = reduce(lambda a, b: a * b, primes)
        self.assertEqual(sorted(primes), sorted(prime_factors(some_big_number)))


if __name__ == '__main__':
    suite = unittest.TestLoader().loadTestsFromTestCase(PrimeFactorsTests)
    unittest.TextTestRunner().run(suite)
