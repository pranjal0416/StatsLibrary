import java.util.ArrayList;
import java.util.Random;

public class Deal {

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
