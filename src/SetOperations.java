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

}
