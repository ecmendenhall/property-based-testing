def trial_division(n, divisor=2, factors=[])
  if n < 2
    factors
  else
    if (n % divisor) == 0
      factors << divisor
      trial_division(n / divisor, divisor, factors)
    else
      trial_division(n, divisor + 1, factors)
    end
  end
end

def prime_factors(n)
  trial_division(n)
end
