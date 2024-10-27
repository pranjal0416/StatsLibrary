import java.util.ArrayList;


/**
 * Calculates the probability of two people having the same birthday within a list of people.
 *
 * @param people An ArrayList of Person objects representing individuals
 * @return true if there are two people with the same birthday, false otherwise
 */
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

    /**
     * Simulates the probability of having the same birthday among a group of people.
     *
     * @param numPeople The number of people in the group
     * @param prob The current probability count
     * @return The updated probability count after running the simulation
     */
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

    public static void returnProb(){
        int prob = 0;
        for(int i = 0; i < 10000; i++){
            prob = runProb(31,prob);
        }
        System.out.println("Probability is: " + (double) prob/10000 + " to have the same birthday");

    }
}

