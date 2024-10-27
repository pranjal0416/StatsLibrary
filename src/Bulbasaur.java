import java.util.ArrayList;
/**
 * Bulbasaur is a pokemon
 * extends pokemon
 * attacks are leechseed and vine whip
 */

public class Bulbasaur extends Pokemon{
    private String attackOne;
    private String attackTwo;
    private ArrayList<Energy> energyPile;
    public Bulbasaur(){
        setHP(70);
        this.attackOne = "Leech Seed";
        this.attackTwo = "Vine Whip";
        energyPile = new ArrayList<Energy>();
    }

    //leechseed
    /**
     * Performs an attack on a target Pokemon using the Leech Seed move.
     * If there is not enough energy to perform the attack, a message is printed.
     * Otherwise, the attack deals 20 damage to the target, and the attacking Pokemon
     * heals 20 HP.
     *
     * @param target The Pokemon being attacked
     * @param energyPile The list of energy cards available for the attack
     */
    public void attackOne(Pokemon target, ArrayList<Energy> energyPile){
        //deal 20 damage heal 20
        if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{
            int currentHp = target.getHP();
            int resultingHp = currentHp - 20;

            int thisCurrentHp = this.getHP();
            this.setHP(thisCurrentHp + 20);

            target.setHP(resultingHp);
            System.out.println("Bulbasaur used Leech Seed on " + target.getName() + " dealing 20 damage");
            System.out.println("Bulbasaur healed 20 hp");
        }
    }
    //vine whip
    /**
     * Performs an attack on a target Pokemon using a specific attack (Vine Whip).
     * If there is not enough energy to perform the attack, a message is printed.
     *
     * @param target The Pokemon to be attacked
     * @param energyPile The list of energy cards available for the attack
     */
    public void attackTwo(Pokemon target, ArrayList<Energy> energyPile){
        if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{
            //deal 45 damage
            int currentHp = target.getHP();
            int resultingHp = currentHp - 45;
            target.setHP(resultingHp);
            System.out.println("Bulbasaur used Vine Whip on " + target.getName() + " dealing 45 damage");
        }
    }

    /**
     * Getters for name, attack one, and attack two
     */
    @Override
    public String getName(){
        return "Bulbasaur";
    }

    @Override
    public String getAttackOne(){
        return "Leech Seed";
    }

    @Override
    public String getAttackTwo(){
        return "Vine Whip";
    }

    /**
     * Setter for adding energy card to energy pile
     */
    public void setEnergyPile(Energy energyCard) {
        energyPile.add(energyCard);
    }


}
