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




}
