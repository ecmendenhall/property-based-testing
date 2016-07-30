function trialDivision(n, divisor, factors) {
  if (n < 2) {
    return factors;
  } else {
    if ((n % divisor) === 0) {
      factors.push(divisor);
      return trialDivision(n / divisor, divisor, factors);
    } else {
      return trialDivision(n, divisor + 1, factors);
    }
  }
}

function primeFactors(n) {
  return trialDivision(n, 2, []);
}

module.exports = primeFactors;
