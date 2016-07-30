var expect = require('chai').expect;
var jsc = require('jsverify');
var _ = require('lodash');
var fs = require('fs');
var primeFactors = require('../src/prime-factors');


fs.readFile('../primes.txt', 'utf8', function(err, data) {
  var primes = data.split(/\s+/).map(function(n) {
    return parseInt(n);
  });

  describe('Prime factorization (property-based tests)', function() {

    it('1 has no prime factors', function() {
      expect(primeFactors(1)).to.eql([]);
    });

    jsc.property(
      "A prime number's only prime factor is itself",
      jsc.elements(primes),
      function (prime) {
        return _.isEqual(primeFactors(prime), [prime]);}
    );

    jsc.property(
      "Factoring 2 * a prime returns 2 and the prime",
      jsc.elements(primes),
      function (prime) {
        return _.isEqual(primeFactors(2 * prime), [2, prime]);}
    );

    jsc.property(
      "Factoring a prime * a prime returns both primes",
      jsc.elements(primes),
      function (prime) {
        return _.isEqual(primeFactors(prime * prime), [prime, prime]);}
    );

    jsc.property(
      "Factoring the product of a series of primes returns all the primes",
      jsc.small(jsc.nearray(jsc.elements(primes))),
      function (primes) {
        var someBigNumber = primes.reduce(function(a, b) {
          return a * b;
        });
        return _.isEqual(primeFactors(someBigNumber).sort(), primes.sort());}
    );
  });
});

