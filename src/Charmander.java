import java.util.ArrayList;

public class Charmander extends Pokemon{

    private String attackOne;
    private String attackTwo;
    private ArrayList<Energy> energyPile;
    public Charmander(){
        setHp(50);
        this.attackOne = "Scratch";
        this.attackTwo = "Ember";
        energyPile = new ArrayList<Energy>();
    }

    //leechseed
    public void attackOne(Pokemon target, ArrayList<Energy> energyPile){
        //deal 20 damage heal 20
        if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{
            int currentHp = target.getHp();
            int resultingHp = currentHp - 20;

            int thisCurrentHp = this.getHp();
            this.setHp(thisCurrentHp + 20);

            target.setHp(resultingHp);
            System.out.println("Charmander used Leech Seed on " + target.getName() + " dealing 20 damage");
            System.out.println("Charmander healed 20 hp");
        }
    }
    //vine whip
    public void attackTwo(Pokemon target, ArrayList<Energy> energyPile){
        if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{
            //deal 45 damage
            int currentHp = target.getHp();
            int resultingHp = currentHp - 45;
            target.setHp(resultingHp);
            System.out.println("Charmander used Vine Whip on " + target.getName() + " dealing 45 damage");
        }
    }

    @Override
    public String getName(){
        return "Charmander";
    }

    public void setEnergyPile(Energy energyCard) {
        energyPile.add(energyCard);
    }


}


