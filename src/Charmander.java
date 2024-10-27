import java.util.ArrayList;

/**
 * Represents a Charmander Pokemon, a subclass of the Pokemon class.
 * Charmander has two attacks, "Scratch" and "Ember", and an initial HP of 50.
 * It also has an energy pile to store energy cards.
 */
public class Charmander extends Pokemon{

    private String attackOne;
    private String attackTwo;
    private ArrayList<Energy> energyPile;
    public Charmander(){
        setHP(50);
        this.attackOne = "Scratch";
        this.attackTwo = "Ember";
        energyPile = new ArrayList<Energy>();
    }

    //scratch
    /**
     * Attacks the target Pokemon using an energy card.
     *
     * @param target The Pokemon to be attacked
     * @param energyPile The pile of energy available for the attack
     */
    public void attackOne(Pokemon target, ArrayList<Energy> energyPile){
        //deal 10 damage
        if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{
            int currentHp = target.getHP();
            int resultingHp = currentHp - 20;
            target.setHP(resultingHp);

            System.out.println("Charmander used Scratch on " + target.getName() + " dealing 10 damage");

        }
    }
    //Ember
    /**
     * Performs an attack on the target Pokemon using energy from the energy pile.
     *
     * @param target The Pokemon to be attacked
     * @param energyPile The pile of energy available for the attack
     */
    public void attackTwo(Pokemon target, ArrayList<Energy> energyPile){
        if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{
            //deal 30 damage
            int currentHp = target.getHP();
            int resultingHp = currentHp - 30;
            target.setHP(resultingHp);
            System.out.println("Charmander used Ember on " + target.getName() + " dealing 30 damage");
        }
    }

    /**
     * Returns the name of the Pokemon which is "Charmander".
     *
     * @return The name of the Pokemon
     */
    @Override
    public String getName(){
        return "Charmander";
    }

    /**
     * Returns the name of the first attack.
     *
     * @return The name of the first attack, which is "Scratch".
     */
    @Override
    public String getAttackOne(){
        return "Scratch";
    }

    /**
     * Returns the name of the second attack.
     *
     * @return The name "Ember".
     */
    @Override
    public String getAttackTwo(){
        return "Ember";
    }

    /**
     * Adds an energy card to the energy pile.
     *
     * @param energyCard The energy card to add to the energy pile
     */
    public void setEnergyPile(Energy energyCard) {
        energyPile.add(energyCard);
    }


}





