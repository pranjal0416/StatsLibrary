import java.util.ArrayList;

/**
 * The Pokemon class represents a Pokemon card in the game, inheriting from the Card class.
 * It encapsulates the attributes and behaviors associated with a Pokemon, including its
 * health points (HP) and the energy required for its attacks.
 *
 **/
 public class Pokemon extends Card{
    private int HP;

    private ArrayList<Energy> energyPile;

    public Pokemon(){
        this.HP = 70;
        energyPile = new ArrayList<Energy>();

    }

    /**
     * Retrieves the list of Energy cards attached to the Pokemon.
     *
     * @return An ArrayList of Energy cards currently attached to the Pokemon.
     */
    public ArrayList<Energy> getEnergyPile() {
        return energyPile;
    }

    /**
     * Adds a specified Energy card to the Pokemon's energy pile.
     *
     * @param energy The Energy card to be added to the energyPile.
     */
    public void addEnergy(Energy energy) {
        energyPile.add(energy); // Add the Energy card to the energy pile.
    }


    public void attackOne(Pokemon target, ArrayList<Energy> energyPile) {
    }


    public void attackTwo(Pokemon target, ArrayList<Energy> energyPile) {
        // Implementation of the attack will be defined in subclasses.
    }

    /**
     * Returns the Hp of the Pokemon.
     *
     * @return The Hp of the Pokemon.
     */
    public int getHP() {
        return HP;
    }

    /**
     * Sets the hp of the Pokemon.
     *
     * @param userInputHp The new HP for the Pokemon.
     */
    public void setHP(int userInputHp) {
        this.HP = userInputHp; // Update the HP of the Pokemon.
    }

}
