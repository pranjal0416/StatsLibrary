import java.util.Random;
public class Person {
    private int birthday;
    Random rand  = new Random();
    public Person(){
        birthday = rand.nextInt(365);
    }

    public int getBirthday(){
        return birthday;
    }


}
