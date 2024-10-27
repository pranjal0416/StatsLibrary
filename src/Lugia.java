import java.util.ArrayList;

/**
 * Represents the Pokemon character Lugia, a subclass of Pokemon with specific
 * attacks and energy requirements.
 */
public class Lugia extends Pokemon {
    private String attackOne; // Name of the first attack, "Gust"
    private String attackTwo; // Name of the second attack, "Energy Loop"
    private ArrayList<Energy> energyPile; // Energy resources available for Lugia's attacks


    public Lugia() {
        setHP(130);
        this.attackOne = "Gust";
        this.attackTwo = "Energy Loop";
        energyPile = new ArrayList<Energy>();
    }

    /**
     * Executes Lugia's Gust attack on a target Pokemon, reducing its HP by 30.
     *
     * @param target     The Pokemon being attacked.
     * @param energyPile The energy resources available for the attack.
     */
    public void attackOne(Pokemon target, ArrayList<Energy> energyPile) {
        // Check if there is enough energy to perform the attack
        if (energyPile.size() < 1) {
            System.out.println("Not enough energy to perform this attack"); // Print error if insufficient energy
            return;
        } else {
            int currentHp = target.getHP(); // Get current HP of the target
            int resultingHp = currentHp - 30; // Calculate new HP after dealing 30 damage
            target.setHP(resultingHp); // Set the target's HP to the new value
            System.out.println("Lugia used Gust on " + target.getName() + " dealing 30 damage"); // Print attack result
        }
    }

    /**
     * Executes Lugia's Energy Loop attack on a target Pokemon, reducing its HP by 120.
     *
     * @param target     The Pokemon being attacked.
     * @param energyPile The energy resources available for the attack.
     */
    public void attackTwo(Pokemon target, ArrayList<Energy> energyPile) {
        // Check if there is enough energy to perform the attack
        if (energyPile.size() < 1) {
            System.out.println("Not enough energy to perform this attack"); // Print error if insufficient energy
            return;
        } else {
            int currentHp = target.getHP(); // Get current HP of the target
            int resultingHp = currentHp - 120; // Calculate new HP after dealing 120 damage
            target.setHP(resultingHp); // Set the target's HP to the new value
            System.out.println("Lugia used Energy Loop on " + target.getName() + " dealing 120 damage"); // Print attack result
        }
    }

    /**
     * Returns the name of this Pokemon
     *
     * @return The name Lugia.
     */
    @Override
    public String getName() {
        return "Lugia";
    }

    /**
     * Returns the name of first attack.
     *
     * @return The name "Gust".
     */
    @Override
    public String getAttackOne() {
        return "Gust";
    }

    /**
     * Returns the name of second attack.
     *
     * @return The name "Energy Loop".
     */
    @Override
    public String getAttackTwo() {
        return "Energy Loop";
    }


    public void setEnergyPile(Energy energyCard) {
        energyPile.add(energyCard);
    }


}
