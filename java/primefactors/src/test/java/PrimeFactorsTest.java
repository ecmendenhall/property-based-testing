package primefactors;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class PrimeFactorsTest {

    @Test
    public void testFactorsOfOne() {
        assertEquals(Arrays.asList(), PrimeFactors.factorize(1));
    }

    @Test
    public void testFactorsOfTwo() {
        assertEquals(Arrays.asList(2), PrimeFactors.factorize(2));
    }

    @Test
    public void testFactorsOfFour() {
        assertEquals(Arrays.asList(2, 2), PrimeFactors.factorize(4));
    }


    @Test
    public void testFactorsOfEight() {
        assertEquals(Arrays.asList(2, 2, 2), PrimeFactors.factorize(8));
    }

    @Test
    public void testFactorsOfNine() {
        assertEquals(Arrays.asList(3, 3), PrimeFactors.factorize(9));
    }

    @Test
    public void testFactorsOfThirty() {
        assertEquals(Arrays.asList(2, 3, 5), PrimeFactors.factorize(30));
    }

    @Test
    public void testFactorsOfSeventeen() {
        assertEquals(Arrays.asList(17), PrimeFactors.factorize(17));
    }

    @Test
    public void testFactorsOfSomeBigNumber() {
        List<Integer> primes = Arrays.asList(2, 2, 2, 3, 5, 7, 7, 11, 13);
        Integer bigNumber = primes.stream().reduce(1, (a, b) -> a * b);
        assertEquals(primes, PrimeFactors.factorize(bigNumber));
    }

}
