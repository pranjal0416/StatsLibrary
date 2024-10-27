import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatsLib {


    public double computeMean(ArrayList<Integer> listOfNumbers) {
        int sum = 0;
        for (int singleNumber : listOfNumbers) {
            sum = sum + singleNumber;
        }
        return sum / (double) listOfNumbers.size();
    }

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

    public double standardDeviation(ArrayList<Integer> listOfNumbers) {
        double mean = computeMean(listOfNumbers);
        double varianceSum = 0.0;
        for (double number : listOfNumbers) {
            varianceSum += Math.pow(number - mean, 2);
        }
        double variance = varianceSum / listOfNumbers.size();
        return Math.sqrt(variance);
    }

    public static BigInteger factorial(int n) {
        BigInteger result = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            result = result.multiply(BigInteger.valueOf(i));
        }
        return result;
    }

    public static BigInteger permutations(int n, int k) {
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(n - k);
        return numerator.divide(denominator);
    }

    public static BigInteger combinations(int n, int k) {
        BigInteger numerator = factorial(n);
        BigInteger denominator = factorial(k).multiply(factorial(n - k));
        return numerator.divide(denominator);
    }

    public boolean isIndependent(double pA, double pB, double pAGivenB, double pBGivenA, double pAAndB){
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

    public boolean isDependent(double pA, double pB, double pAGivenB, double pBGivenA, double pAAndB){
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

    public double conditionalProbability(double pAAndB, double pB){
        double cProb = (pAAndB) / (pB);
        return cProb;
    }



    public double binomialProbabilityDistribution(double p, double q, int n, int y) {
        double binomial = combinations(n, y).doubleValue() * Math.pow(p, y) * Math.pow(q, n - y);
        return binomial;
    }

    public double geometricProbabilityDistribution(double q, double p, int y) {
        double gD = Math.pow(q, y - 1) * p;
        return gD;
    }

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

        System.out.println("The conditional probability is " + conditionalProbability(2, 4));

        System.out.println("The binomial probability distribution is " + binomialProbabilityDistribution(0.8, 0.2, 10, 7));

        System.out.println("The geometric probability distribution is " + geometricProbabilityDistribution(0.8, 0.2, 5));


    }
}
