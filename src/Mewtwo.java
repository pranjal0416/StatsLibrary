import java.util.ArrayList;

/**
 * Mewtwo is a subclass of Pokemon with two unique attacks:
 * "Super Psy Bolt" and "Transfer Break".
 */
public class Mewtwo extends Pokemon {
    private String attackOne;
    private String attackTwo;
    private String cardName;

    public Mewtwo() {
        this.setHP(120);
        this.attackOne = "Super Psy Bolt";
        this.attackTwo = "Transfer Break";
    }

    /**
     * Executes Mewtwo's Super Psy Bolt attack on a target Pokemon,
     * reducing its HP by 50.
     *
     * @param target     The Pokemon being attacked.
     * @param energyPile The energy resources available for the attack.
     */
    public void attackOne(Pokemon target, ArrayList<Energy> energyPile) {
        // Check if there is enough energy to perform the attack
        if (energyPile.size() < 1) {
            System.out.println("Not enough energy to perform this attack"); // Print message if not enough energy
        } else {
            int currentHp = target.getHP(); // Get current HP of the target
            int resultingHp = currentHp - 50; // Calculate new HP after dealing 50 damage
            target.setHP(resultingHp); // Update target's HP
            System.out.println("Mewtwo used Super Psy Bolt on " + target.getName() + " dealing 50 damage!"); // Print attack result
        }
    }

    /**
     * Executes Mewtwo's Transfer Break attack on a target Pokemon,
     * reducing its HP by 160.
     *
     * @param target     The Pokemon being attacked.
     * @param energyPile The energy resources available for the attack.
     */
    public void attackTwo(Pokemon target, ArrayList<Energy> energyPile) {
        // Check if there is enough energy to perform the attack
        if (energyPile.size() < 1) {
            System.out.println("Not enough energy to perform this attack"); // Print message if not enough energy
        } else {
            int currentHp = target.getHP(); // Get current HP of the target
            int resultingHp = currentHp - 160; // Calculate new HP after dealing 160 damage
            target.setHP(resultingHp); // Update target's HP
            System.out.println("Mewtwo used Transfer Break on " + target.getName() + " dealing 160 damage!"); // Print attack result
        }
    }

    /**
     * Returns the name of this Pokemon, "Mewtwo".
     *
     * @return The name of the Pokemon.
     */
    @Override
    public String getName() {
        return "Mewtwo";
    }

    /**
     * Returns the name of first attack.
     *
     * @return The name "Super Psy Bolt".
     */
    @Override
    public String getAttackOne() {
        return "Super Psy Bolt";
    }

    /**
     * Returns the name of second attack.
     *
     * @return The name "Transfer Break".
     */
    @Override
    public String getAttackTwo() {
        return "Transfer Break";
    }
}

