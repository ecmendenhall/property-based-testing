require 'rspec'
require './prime-factors.rb'

describe "Prime factorization" do

  it "returns [] for 1" do
    expect(prime_factors(1)).to eq([])
  end

  it "returns [2] for 2" do
    expect(prime_factors(2)).to eq([2])
  end

  it "returns [2, 2] for 4" do
    expect(prime_factors(4)).to eq([2, 2])
  end

  it "returns [2, 2, 2] for 8" do
    expect(prime_factors(8)).to eq([2, 2, 2])
  end

  it "returns [3, 3] for 9" do
    expect(prime_factors(9)).to eq([3, 3])
  end

  it "returns [2, 3, 5] for 30" do
    expect(prime_factors(30)).to eq([2, 3, 5])
  end

  it "returns [17] for 17" do
    expect(prime_factors(17)).to eq([17])
  end

  it "returns all factors when a bunch of primes are multiplied" do
    primes = [2, 2, 2, 3, 5, 7, 7, 11, 13]
    some_big_number = primes.inject(&:*)
    expect(prime_factors(some_big_number)).to eq(primes)
  end

end
