import java.util.ArrayList;

public class Revive extends Trainer{
    public Revive(){
    }
    public String getName() {
        return "Revive";
    }

    @Override
    public void playable(Player player, Player target) {
        ArrayList<Card> discard = player.getDiscardPile();
        ArrayList<Card> bench = player.getBenchPile();
        int i = 0;
        while(i < discard.size()){
            if(discard.get(i) instanceof Pokemon){
                bench.add(discard.get(i));
                break;
            }
            else{
                i++;
            }
        }
        System.out.println("Revive has been played");
        System.out.println(player.getName() + " has added a Pokemon from the discard pile to their bench");

    }
}