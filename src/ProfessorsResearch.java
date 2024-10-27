import java.util.ArrayList;
/**
 * trainer card that discards hand and draws new hand
 */
public class ProfessorsResearch extends Trainer {
    public ProfessorsResearch(){
    }
    @Override
    public void playable(Player player, Player target){
        ArrayList<Card> deck = player.getDeck();
        ArrayList<Card> hand = player.returnHand();
        ArrayList<Card> discard = player.getDiscardPile();;
        hand.clear();
        player.getHand();
        System.out.println("Professor's Research has been played");
        System.out.println(player.getName() + " has discarded their hand and drawn 7 cards from their deck.");

    }

    @Override
    public String getName(){
        return "Professor's Research";
    }



}
