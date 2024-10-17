import java.util.ArrayList;

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

    @Override
    public String getName(){
        return "Charmander";
    }

    public void setEnergyPile(Energy energyCard) {
        energyPile.add(energyCard);
    }


}


