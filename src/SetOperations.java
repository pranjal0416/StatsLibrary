
import java.util.ArrayList;

/**
 * The SetOperations class has methods for performing set operations
 * on Integer ArrayLists, as well as calculating probabilities related to independent
 * and dependent events
 */
public class SetOperations {

    /**
     *The union of two integer lists
     *
     * @param list1 The first list of integers.
     * @param list2 The second list of integers.
     * @return An ArrayList containing the union of list1 and list2.
     */
    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> unionList = new ArrayList<>(list1);
        for (Integer element : list2) {
            if (!unionList.contains(element)) {
                unionList.add(element);
            }
        }
        return unionList;
    }

    /**
     * Gets the intersection of two integer lists
     *
     * @param list1 The first list of integers.
     * @param list2 The second list of integers.
     * @return An ArrayList containing the intersection of list1 and list2.
     */
    public static ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> intersectList = new ArrayList<Integer>();
        for (Integer element : list1) {
            if (list2.contains(element) && !intersectList.contains(element)) {
                intersectList.add(element);
            }
        }
        return intersectList;
    }

    /**
     * Computes the complement of a subset
     *
     * @param allValues The larger set of all possible values.
     * @param subset The subset whose complement is to be found.
     * @return An ArrayList containing elements that are in allValues but not in subset.
     */
    public static ArrayList<Integer> complement(ArrayList<Integer> allValues, ArrayList<Integer> subset) {
        ArrayList<Integer> compList = new ArrayList<Integer>();
        for (Integer element : allValues) {
            if (!subset.contains(element)) {
                compList.add(element);
            }
        }
        return compList;
    }

    /**
     * Calculates the probability of the intersection of two independent events.
     *
     * @param probA  probability of event A.
     * @param probB probability of event B.
     * @return The probability of both events occurring.
     */
    public double independentIntersection(double probA, double probB) {
        return probA * probB;
    }

    /**
     * Calculates the probability of the intersection of two dependent events.
     *
     * @param probA The probability of event A.
     * @param conditionalProbBGivenA The conditional probability of event B given A.
     * @return The probability of both events occurring.
     */
    public double dependentIntersection(double probA, double conditionalProbBGivenA) {
        return probA * conditionalProbBGivenA;
    }

    /**
     * Calculates the probability of the union of two exclusive events.
     *
     * @param probA The probability of event A.
     * @param probB The probability of event B.
     * @return The combined probability of either event A or event B occurring.
     */
    public double exclusiveUnion(double probA, double probB) {
        return probA + probB;
    }

    /**
     * Calculates the probability of the union of two non-exclusive events.
     *
     * @param probA The probability of event A.
     * @param probB The probability of event B.
     * @param intersectionProb The probability of both events occurring.
     * @return The  probability of either event A or event B occurring
     *
     */
    public double nonExclusiveUnion(double probA, double probB, double intersectionProb) {
        return probA + probB - intersectionProb;
    }

    /**
     * Test method to demonstrate the functionality of set operations and probability calculations.
     */
    public void testSetOperations() {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);
        set.add(5);
        set.add(6);
        set.add(7);
        set.add(8);
        set.add(9);
        set.add(10);
        set.add(11);
        set.add(12);
        set.add(13);

        ArrayList<Integer> subset = new ArrayList<>();
        subset.add(2);
        subset.add(4);
        subset.add(6);
        subset.add(8);

        System.out.println("Union: " + union(set, subset));
        System.out.println();
        System.out.println("Intersect: " + intersect(set, subset));
        System.out.println();
        System.out.println("Complement: " + complement(set, subset));
        System.out.println();
        System.out.println("Independent Intersection: " + independentIntersection(.43, .57));
        System.out.println();
        System.out.println("Dependent Intersection: " + dependentIntersection(.43, .57));
        System.out.println();
        System.out.println("Exclusive Union: " + exclusiveUnion(.66, .34));
        System.out.println();
        System.out.println("NonExclusive Union: " + nonExclusiveUnion(.66, .34, .22));
        System.out.println();
    }
}
