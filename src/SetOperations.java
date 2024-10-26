import java.util.ArrayList;

public class SetOperations {

    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        ArrayList<Integer> unionList = new ArrayList<>(list1);
        for (Integer element : list2) {
            if (!unionList.contains(element)) {
                unionList.add(element);
            }
        }
    return unionList;
    }
    public static ArrayList<Integer> intersect(ArrayList<Integer> list1, ArrayList<Integer> list2)
    {
        ArrayList<Integer> intersectList = new ArrayList<Integer>();
        for (Integer element : list1) {
            if (list2.contains(element) && !intersectList.contains(element)) {
                intersectList.add(element);
            }
        }
        return intersectList;
    }
    public static ArrayList<Integer> complement(ArrayList<Integer> allValues, ArrayList<Integer> subset)
    {
        ArrayList<Integer> compList = new ArrayList<Integer>();
        for (Integer element : allValues) {
            if (!subset.contains(element)) {
                compList.add(element);
            }
        }
        return compList;
    }
    public double independentIntersection(double probA, double probB) {
        return probA * probB;
    }


    public double dependentIntersection(double probA, double conditionalProbBGivenA) {
        return probA * conditionalProbBGivenA;
    }


    public double exclusiveUnion(double probA, double probB) {
        return probA + probB;
    }


    public double nonExclusiveUnion(double probA, double probB, double intersectionProb) {
        return probA + probB - intersectionProb;
    }

    public void testSetOperations(){

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
        System.out.println("Independent Intersection: " + independentIntersection(.43,.57));
        System.out.println();
        System.out.println("Dependent Intersection: " + dependentIntersection(.43, .57));
        System.out.println();
        System.out.println("Exclusive Union: " + exclusiveUnion(.66, .34));
        System.out.println();
        System.out.println("NonExclusive Union: " + nonExclusiveUnion(.66, .34, .22));
        System.out.println();
    }



}
