package primefactors;

import net.java.quickcheck.Generator;
import org.junit.Test;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someLists;
import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someOneOf;
import static org.junit.Assert.assertEquals;

class PrimeGenerator implements Generator<Integer> {

    byte[] encoded = Files.readAllBytes(Paths.get("../../primes.txt"));
    List<Integer> primes = Arrays.asList(new String(encoded, StandardCharsets.UTF_8).split("\\s+")).stream().map(Integer::valueOf).collect(Collectors.toList()).subList(0, 200);
    Random random = new Random();

    PrimeGenerator() throws java.io.IOException {}

    @Override
    public Integer next() {
        return primes.get(random.nextInt(primes.size()));
    }
}

public class PrimeFactorsCheck {

    @Test
    public void testOneHasNoPrimeFactors() {
        assertEquals(Arrays.asList(), PrimeFactors.factorize(1));
    }

    @Test
    public void testAPrimesOnlyPrimeFactorIsItself() throws IOException {
        for (Integer prime : someOneOf(new PrimeGenerator())) {
            assertEquals(Arrays.asList(prime), PrimeFactors.factorize(prime));
        }
    }

    @Test
    public void testFactoringTwoTimesAPrimeReturnsTwoAndThePrime() throws IOException {
        for (Integer prime : someOneOf(new PrimeGenerator())) {
            assertEquals(Arrays.asList(2, prime), PrimeFactors.factorize(2 * prime));
        }
    }

    @Test
    public void testFactoringPrimeTimesPrimeReturnsBothPrimes() throws IOException {
        for (Integer prime : someOneOf(new PrimeGenerator())) {
            assertEquals(Arrays.asList(prime, prime), PrimeFactors.factorize(prime * prime));
        }
    }

    @Test
    public void testFactoringProductOfPrimesReturnsAllPrimes() throws IOException {
        for (List<Integer> primes : someLists(new PrimeGenerator(), 3, 3)) {
            Integer someBigNumber = primes.stream().reduce(1, (a, b) -> a * b);
            primes.sort(Comparator.naturalOrder());
            List<Integer> factors = PrimeFactors.factorize(someBigNumber);
            factors.sort(Comparator.naturalOrder());
            assertEquals(primes, factors);
        }
    }

}
