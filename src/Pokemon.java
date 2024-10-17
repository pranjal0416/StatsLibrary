import java.util.ArrayList;

public class Pokemon extends Card{
    private int HP;
    private ArrayList<Energy> energyPile;

    public Pokemon(){
        this.HP = 70;
        energyPile = new ArrayList<Energy>();

    }

    public ArrayList<Energy> getEnergyPile(){
        return energyPile;
    }

    public void addEnergy(Energy energy){
        energyPile.add(energy);
    }

    public void attackOne(Pokemon target, ArrayList<Energy> energyPile){

    }
    public void attackTwo(Pokemon target, ArrayList<Energy> energyPile){
    }

    public int getHP(){
        return HP;
    }

    public void setHP(int userInputHp){
        this.HP = userInputHp;
    }

}
