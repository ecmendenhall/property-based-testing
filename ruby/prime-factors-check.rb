require 'rspec'
require 'rantly/rspec_extensions'
require './prime-factors.rb'

PRIMES = File.open('../primes.txt').read.split.map(&:to_i)

describe "Prime factorization" do

  it "1 has no prime factors" do
    expect(prime_factors(1)).to eq([])
  end

  it "A prime number's only prime factor is itself" do
    property_of { choose(*PRIMES) }.check do |n|
      expect(prime_factors(n)).to eq([n])
    end
  end

  it "Factoring 2 * a prime returns 2 and the prime" do
    property_of { choose(*PRIMES) }.check do |n|
      expect(prime_factors(2 * n)).to eq([2, n])
    end
  end

  it "Factoring prime * prime returns both primes" do
    property_of { array(2) { choose(*PRIMES) } }.check do |prime_one, prime_two|
      expect(prime_factors(prime_one * prime_two)).to eq([prime_one, prime_two].sort)
    end
  end

  it "Factoring the product of a series of primes returns all the primes" do
    property_of { array { choose(*PRIMES) } }.check do |primes|
      some_big_number = primes.inject(&:*)
      expect(prime_factors(some_big_number)).to eq(primes.sort)
    end
  end

end
