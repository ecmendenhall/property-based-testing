var expect = require('chai').expect;
var primeFactors = require('../src/prime-factors');

describe('Prime factorization (unit tests)', function() {

  it('returns [] for 1', function() {
    expect(primeFactors(1)).to.eql([]);
  });

  it('returns [2] for 2', function() {
    expect(primeFactors(2)).to.eql([2]);
  });

  it('returns [2, 2] for 4', function() {
    expect(primeFactors(4)).to.eql([2, 2]);
  });

  it('returns [2, 2, 2] for 8', function() {
    expect(primeFactors(8)).to.eql([2, 2, 2]);
  });

  it('returns [3, 3] for 9', function() {
    expect(primeFactors(9)).to.eql([3, 3]);
  });

  it('returns [2, 3, 5] for 30', function() {
    expect(primeFactors(30)).to.eql([2, 3, 5]);
  });

  it('returns [17] for 17', function() {
    expect(primeFactors(17)).to.eql([17]);
  });

  it('returns all factors when a bunch of primes are multiplied', function() {
    primes = [2, 2, 2, 3, 5, 7, 7, 11, 13];
    someBigNumber = primes.reduce(function(a, b) {
      return a * b;
    });
    expect(primeFactors(someBigNumber)).to.eql(primes);
  });

});
