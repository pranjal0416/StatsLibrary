import java.util.ArrayList;
/**
 * pikachu is a pokemon
 * attacks are quick attack and electroball
 */
public class Pikachu extends Pokemon{
    private String attackOne;
    private String attackTwo;
    private String cardName;
    public Pikachu(){
        this.setHP(70);
        this.attackOne = "Quick Attack";
        this.attackTwo = "Electroball";
        this.cardName = "Pikachu";

    }


    /**
     * Executes Pikachu's Quick Attack on a target Pokemon, reducing its HP by 10.
     *
     * @param target     The Pokemon being attacked.
     * @param energyPile The energy available for the attack.
     */
    public void attackOne(Pokemon target, ArrayList<Energy> energyPile) {
        // Check if there is enough energy to perform the attack
        if (energyPile.size() < 1) {
            System.out.println("Not enough energy to perform this attack"); // Print message if insufficient energy
            return;
        } else {
            // Deal 10 damage to the target
            int currentHp = target.getHP(); // Get current HP of the target
            int resultingHp = currentHp - 10; // Calculate new HP after dealing 10 damage
            target.setHP(resultingHp); // Update target's HP
            System.out.println("Pikachu used Quick Attack on " + target.getName() + " dealing 10 damage!"); // Print attack result
        }
    }

    /**
     * Executes Pikachu's Electroball on a target Pokemon, reducing its HP by 60.
     *
     * @param target     The Pokemon being attacked.
     * @param energyPile The energy resources available for the attack.
     */
    public void attackTwo(Pokemon target, ArrayList<Energy> energyPile) {
        // Check if there is enough energy to perform the attack
        if (energyPile.size() < 1) {
            System.out.println("Not enough energy to perform this attack"); // Print message if insufficient energy
            return;
        } else {
            // Deal 60 damage to the target
            int currentHp = target.getHP(); // Get current HP of the target
            int resultingHp = currentHp - 60; // Calculate new HP after dealing 60 damage
            target.setHP(resultingHp); // Update target's HP
            System.out.println("Pikachu used Electroball on " + target.getName() + " dealing 60 damage!"); // Print attack result
        }
    }

    @Override
    public String getName(){
        return cardName;
    }

    @Override
    public String getAttackOne(){
        return "Quick Attack";
    }

    @Override
    public String getAttackTwo(){
        return "Electroball";
    }
}
