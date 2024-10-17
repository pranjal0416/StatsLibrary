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
        for(int i = 0; i < 7; i++){
            hand.add(deck.get(0));
            deck.remove(0);
        }
        System.out.println("Professor's Research has been played");
        System.out.println(player.getName() + " has discarded their hand and drawn 7 cards from their deck.");

    }

    @Override
    public String getName(){
        return "Professor's Research";
    }



}
