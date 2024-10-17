import java.util.ArrayList;

public class GustyPickaxe extends Trainer{
    public GustyPickaxe(){
    }
    public String getName() {
        return "Gusty Pickaxe";
    }

    @Override
    public void playable(Player player, Player target) {
        ArrayList<Card> deck = player.getDeck();
        ArrayList<Card> hand = player.returnHand();
        ArrayList<Card> bench = player.getBenchPile();
        if (deck.get(0) instanceof Energy) {
            Pokemon card = (Pokemon) bench.get(0);
            card.addEnergy((Energy) deck.get(0));
        }
        else{
            hand.add(deck.get(0));
        }
        System.out.println("Gusty Pickaxe has been played");
        System.out.println(player.getName() + " has added an energy to a benched pokemon or added a card to their hand.");

    }
}