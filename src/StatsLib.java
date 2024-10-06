import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class StatsLib {


    public double computeMean(ArrayList<Integer> listOfNumbers){
        int sum = 0;
        for (int singleNumber:listOfNumbers)
        {
            sum = sum + singleNumber;
        }
        return sum / (double) listOfNumbers.size();
    }
    public double computeMedian(ArrayList<Integer> listOfNumbers)
    {
        double median = 0;
        listOfNumbers.sort(Integer::compareTo);
        int  midPoint = listOfNumbers.size()/2;
        if (listOfNumbers.size()%2 == 0){
            median = (listOfNumbers.get(midPoint)+listOfNumbers.get(midPoint-1))/2;
        }
        else{
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

    public double standardDeviation(ArrayList<Integer> listOfNumbers)
    {
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
        BigInteger numerator =factorial(n);
        BigInteger denominator = factorial(k).multiply(factorial(n - k));
        return numerator.divide(denominator);
    }




}
