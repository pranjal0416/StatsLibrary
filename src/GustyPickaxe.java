import java.util.ArrayList;

/**
 * Represents a Gusty Pickaxe trainer entity.
 * Extends the Trainer class.
 */
public class GustyPickaxe extends Trainer{
    public GustyPickaxe(){
    }
    /**
     * Returns the name of the item as a string.
     *
     * @return The name of the card.
     */
    public String getName() {
        return "Gusty Pickaxe";
    }

    /**
     * Simulates the playable action of a Gusty Pickaxe card
     * This method allows a player to either add an Energy card from their deck to a benched Pokemon
     * or add a card from their deck to their hand, based on the top card of their deck.
     *
     * @param player The player who is playing the card
     * @param target The target player for the action (not used in this method)
     */
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