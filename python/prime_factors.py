def trial_division(n, divisor, factors):
  if n < 2:
    return factors
  else:
    if (n % divisor) == 0:
      factors.append(divisor)
      return trial_division(n / divisor, divisor, factors)
    else:
      return trial_division(n, divisor + 1, factors)

def prime_factors(n):
  return trial_division(n, 2, [])
