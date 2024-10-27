import java.util.Random;

/**
 * Represents a Person with a randomly assigned birthday (day of the year).
 * The birthday is an integer value between 0 and 364, representing one of the
 * 365 days in a year.
 */
public class Person {
    private int birthday; // Day of the year assigned as the birthday
    Random rand = new Random();

    /**
     * Constructor for the Person class. Assigns a random day of the year (0-364) as the birthday.
     */
    public Person() {
        birthday = rand.nextInt(365);
    }

    /**
     * Returns the birthday of the person.
     *
     * @return An integer representing the day of the year
     */
    public int getBirthday() {
        return birthday;
    }
}

