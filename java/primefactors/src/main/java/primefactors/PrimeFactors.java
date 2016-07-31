package primefactors;

import java.util.ArrayList;
import java.util.List;

public class PrimeFactors {

    public static List<Integer> factorize(Integer n) {
        return trialDivision(n, 2, new ArrayList<>());
    }

    private static List<Integer> trialDivision(Integer n, Integer divisor, List<Integer> factors) {
        if (n < 2) {
            return factors;
        } else {
            if (n % divisor == 0) {
                factors.add(divisor);
                return trialDivision(n / divisor, divisor, factors);
            } else {
                return trialDivision(n, divisor + 1, factors);
            }
        }
    }
}
