import java.util.ArrayList;
import java.util.Random;
/**
 * The Deal class simulates the Monty Hall problem where a contestant picks a door
 * in hopes of winning a car. The class has methods to create doors with car and goat options,
 * simulate the scenario without changing the door choice, and simulate the scenario with changing the door choice.
 */
public class Deal {

    /**
     * Creates an array of three doors with random assignments of "Goat" and "Car".
     *
     * @return An array of three strings representing the doors with "Goat" or "Car" behind them.
     */
    public static String[] createDoors(){
        ArrayList<String> doorOptions = new ArrayList<>();
        doorOptions.add("Goat");
        doorOptions.add("Car");
        doorOptions.add("Goat");

        Random rand = new Random();
        String[] doors = new String[3];

        for(int i=0; i<3; i++){
            int randomDoor = rand.nextInt(doorOptions.size());
            doors[i] = doorOptions.get(randomDoor);
            doorOptions.remove(randomDoor);
        }
        return doors;
    }

    /**
     * Simulates a scenario where a player picks a door without changing their choice.
     * The method runs 10,000 iterations and calculates the probability of winning.
     *
     */
    public static void noChange(){
        Random rand = new Random();
        String[] doors = createDoors();
        int wins = 0;
        for(int i=0; i<10000; i++){
            int randomDoor = rand.nextInt(doors.length);
            if(doors[randomDoor].equals("Car")){
                wins++;
            }
            System.out.println("Result of door picked with no change: " + doors[randomDoor]);
        }
        double result = (double) wins / 10000;
        System.out.println("Probability of wins was: " + result);

    }

    /**
     * Simulates the Monty Hall problem by changing the chosen door after revealing a non-car door.
     * Prints the results of the simulation and the probability of winning by changing the door.
     */
    public static void change(){
        Random rand = new Random();
        String[] doors = createDoors();
        int wins = 0;
        int dud = 0;
        for(int i=0; i<10000; i++){
            int randomDoor = rand.nextInt(doors.length);
            System.out.println("Original door picked: " + randomDoor);
            for(int j=0; j<doors.length; j++){
                if(j != randomDoor && !doors[j].equals("Car")) {
                    System.out.println("Result of door number " + j + ": " + doors[j]);
                    dud = j;
                    break;
                }
            }
            for(int j=0; j<doors.length; j++){
                if(j != randomDoor && j!=dud) {
                    if(doors[j].equals("Car")){
                        wins++;
                    }
                    System.out.println("Result of final door picked after change: " + doors[j]);
                }
            }

        }
        double result = (double) wins / 10000;
        System.out.println("Probability of wins was: " + result);
    }


}

//a- 1/3
//b1- 33%
//b2- 0/dud everytime
//b3- 100% winning chance
//b4- 66%
//b5- switching to the other curtain
