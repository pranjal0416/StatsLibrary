import java.util.ArrayList;


public class Birthday {

    public static boolean calcProb(ArrayList<Person> people){

        for(int i = 0; i < people.size()-1; i++){
            for (int j = i+1; j < people.size(); j++) {
                if(people.get(i).getBirthday() == people.get(j).getBirthday()){
                    return true;
                }

            }
            }
        return false;
    }

    public static int runProb(int numPeople, int prob){
        ArrayList<Person> people = new ArrayList<>();
        for(int i = 0; i < numPeople; i++){
            Person person = new Person();
            people.add(person);
        }

        if(calcProb(people)){
            prob++;
        }
        return prob;

        }
}
