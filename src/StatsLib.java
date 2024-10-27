import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * The StatsLib class provides methods for computing mean, median,
 * modes, standard deviation, and probability distributions, as well as
 * methods for determining independence and dependence
 */
public class StatsLib {

    /**
     * Computes the mean of a list of integers.
     *
     * @param listOfNumbers The list of integers to compute the mean of.
     * @return The mean of the integers in the list.
     */
    public double computeMean(ArrayList<Integer> listOfNumbers) {
        int sum = 0;
        for (int singleNumber : listOfNumbers) {
            sum = sum + singleNumber;
        }
        return sum / (double) listOfNumbers.size();
    }

    /**
     * Computes the median of a list of integers.
     *
     * @param listOfNumbers The list of integers
     * @return The median value of the integers in the list.
     */
    public double computeMedian(ArrayList<Integer> listOfNumbers) {
        double median = 0;
        listOfNumbers.sort(Integer::compareTo);
        int midPoint = listOfNumbers.size() / 2;
        if (listOfNumbers.size() % 2 == 0) {
            median = (listOfNumbers.get(midPoint) + listOfNumbers.get(midPoint - 1)) / 2;
        } else {
            median = listOfNumbers.get(midPoint);
        }
        return median;
    }

    /**
     * Computes the modes of a list of integers.
     *
     * @param numbers The list of integers
     * @return An ArrayList containing the modes of the numbers.
     */
    public ArrayList<Integer> computeModes(ArrayList<Integer> numbers) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (Integer number : numbers) {
            frequencyMap.put(number, frequencyMap.getOrDefault(number, 0) + 1);
        }

        int maxFrequency = 0;
        for (Integer frequency : frequencyMap.values()) {
            if (frequency > maxFrequency) {
                maxFrequency = frequency;
            }
        }

        ArrayList<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }

        return modes;
    }

    /**
     * Computes the standard deviation of a list of integers.
     *
     * @param listOfNumbers The list of integers to compute the standard deviation of.
     * @return The standard deviation of the integers in the list.
     */
    public double standardDeviation(ArrayList<Integer> listOfNumbers) {
        double mean = computeMean(listOfNumbers);
        double varianceSum = 0.0;
        for (double number : listOfNumbers) {
            varianceSum += Math.pow(number - mean, 2);
        }
        double variance = varianceSum / listOfNumbers.size();
        return Math.sqrt(variance);
    }

    /**
     * Computes the factorial of a given integer.
     *
     * @param n The integer to compute the factorial of.
     * @return The factorial of n as a BigInteger.
     */
    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    /**
     * Computes the number of permutations
     *
     * @param n The total number of items.
     * @param k The number of items to choose.
     * @return The number of permutations as a BigInteger.
     */
    public static BigInteger permutations(int n, int k) {
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(n - k);
        return numerator.divide(denominator);
    }

    /**
     * Computes the number of combinations
     *
     * @param n The total number of items.
     * @param k The number of items to choose.
     * @return The number of combinations as a BigInteger.
     */
    public static BigInteger combinations(int n, int k) {
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(k).multiply(factorial(n - k));
        return numerator.divide(denominator);
    }

    /**
     * Determines if two events are independent based on their probabilities.
     *
     * @param pA The probability of event A.
     * @param pB The probability of event B.
     * @param pAGivenB The conditional probability of A given B.
     * @param pBGivenA The conditional probability of B given A.
     * @param pAAndB The joint probability of A and B.
     * @return True if the events are independent; otherwise, false.
     */
    public boolean isIndependent(double pA, double pB, double pAGivenB, double pBGivenA, double pAAndB) {
        if(pAGivenB == pA){
            return true;
        }
        else if(pBGivenA == pB){
            return true;
        }
        else if(pAAndB == pA * pB){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Determines if two events are dependent
     *
     * @param pA The probability of event A.
     * @param pB The probability of event B.
     * @param pAGivenB The conditional probability of A given B.
     * @param pBGivenA The conditional probability of B given A.
     * @param pAAndB The joint probability of A and B.
     * @return True if the events are dependent
     */
    public boolean isDependent(double pA, double pB, double pAGivenB, double pBGivenA, double pAAndB) {
        if(pAGivenB != pA){
            return true;
        }
        else if(pBGivenA != pB){
            return true;
        }
        else if(pAAndB != pA * pB){
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Computes the conditional probability.
     *
     * @param pAAndB The joint probability of A and B.
     * @param pB The marginal probability of B.
     * @return The conditional probability of A given B.
     */
    public double conditionalProbability(double pAAndB, double pB) {
        double cProb = (pAAndB) / (pB);
        return cProb;
    }

    /**
     * Computes the binomial probability distribution for parameters.
     *
     * @param p The probability of success on a single trial.
     * @param q The probability of failure on a single trial.
     * @param n The number of trials.
     * @param y The number of successes.
     * @return The binomial probability.
     */
    public double binomialProbabilityDistribution(double p, double q, int n, int y) {
        double binomial = combinations(n, y).doubleValue() * Math.pow(p, y) * Math.pow(q, n - y);
        return binomial;
    }

    /**
     * Computes the geometric probability distribution for parameters.
     *
     * @param q The probability of failure.
     * @param p The probability of success.
     * @param y The number of trials until the first success.
     * @return The geometric probability.
     */
    public double geometricProbabilityDistribution(double q, double p, int y) {
        double gD = Math.pow(q, y - 1) * p;
        return gD;
    }

    /**
     * Runs tests
     */
    public void runTest() {
        ArrayList<Integer> sampleNumbersOdd = new ArrayList<>();
        sampleNumbersOdd.add(1);
        sampleNumbersOdd.add(3);
        sampleNumbersOdd.add(5);
        sampleNumbersOdd.add(7);
        sampleNumbersOdd.add(9);
        sampleNumbersOdd.add(11);
        sampleNumbersOdd.add(13);
        ArrayList<Integer> sampleNumbersEven = new ArrayList<>();
        sampleNumbersEven.add(2);
        sampleNumbersEven.add(4);
        sampleNumbersEven.add(6);
        sampleNumbersEven.add(8);
        sampleNumbersEven.add(10);
        sampleNumbersEven.add(12);
        ArrayList<Integer> sampleNumbersMode = new ArrayList<>();
        sampleNumbersMode.add(1);
        sampleNumbersMode.add(3);
        sampleNumbersMode.add(5);
        sampleNumbersMode.add(8);
        sampleNumbersMode.add(4);
        sampleNumbersMode.add(3);
        sampleNumbersMode.add(6);
        sampleNumbersMode.add(7);
        sampleNumbersMode.add(1);
        sampleNumbersMode.add(9);
        sampleNumbersMode.add(8);
        sampleNumbersMode.add(3);

        double mean = computeMean(sampleNumbersOdd);
        System.out.println("The Mean is " + mean);

        double medianEven = computeMedian(sampleNumbersEven);
        double medianOdd = computeMedian(sampleNumbersOdd);
        System.out.println("The Median with even input is " + medianEven);
        System.out.println("The Median with odd input is " + medianOdd);

        ArrayList<Integer> answerMode = new ArrayList<>();
        answerMode = computeModes(sampleNumbersMode);
        System.out.println("The Mode is " + answerMode.get(0));

        double standardDeviationPop = standardDeviation(sampleNumbersEven);
        System.out.println("The standard deviation of the Population is " + standardDeviationPop);

        System.out.println("the factorial is: " + factorial(9));

        System.out.println("The number of permutations is " + permutations(10, 3));
        System.out.println("The number of combinations is " + combinations(10, 3));

        System.out.println("Is the problem independent? " + isIndependent(0.5, 0.5, 0.5, 0.5, 0.25));
        System.out.println("Is the problem dependent? " + isDependent(0.5, 0.5, 0.5, 0.5, 0.25));;

        System.out.println("The conditional probability is " + conditionalProbability(.2, .4));

        System.out.println("The binomial probability distribution is " + binomialProbabilityDistribution(0.8, 0.2, 10, 7));

        System.out.println("The geometric probability distribution is " + geometricProbabilityDistribution(0.8, 0.2, 5));


    }
}
