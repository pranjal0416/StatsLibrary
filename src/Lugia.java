import java.util.ArrayList;

public class Lugia extends Pokemon{
    private String attackOne;
    private String attackTwo;
    private ArrayList<Energy> energyPile;
    public Lugia(){
        setHP(130);
        this.attackOne = "Gust";
        this.attackTwo = "Energy Loop";
        energyPile = new ArrayList<Energy>();
    }


    public void attackOne(Pokemon target, ArrayList<Energy> energyPile){

        if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{
            int currentHp = target.getHP();
            int resultingHp = currentHp - 30;
            target.setHP(resultingHp);
            System.out.println("Lugia used Gust on " + target.getName() + " dealing 30 damage");
        }
    }

    public void attackTwo(Pokemon target, ArrayList<Energy> energyPile){
        if (energyPile.size() < 1){
            System.out.println("Not enough energy to perform this attack");
            return;
        }
        else{

            int currentHp = target.getHP();
            int resultingHp = currentHp - 120;
            target.setHP(resultingHp);
            System.out.println("Lugia used Energy Loop on " + target.getName() + " dealing 120 damage");
        }
    }

    @Override
    public String getName(){
        return "Lugia";
    }

    public void setEnergyPile(Energy energyCard) {
        energyPile.add(energyCard);
    }


}
