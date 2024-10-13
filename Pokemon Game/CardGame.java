import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardGame {
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    public CardGame() {
        deck = new ArrayList<>();
        hand = new ArrayList<>();
    }
    public void fillDeck(int numPokemon){
        for(int i = 0; i<60-numPokemon; i++){
            deck.add(new Energy());
        }
        int i = 0;
        while(i < numPokemon){
            deck.add(new Charmander());
            i++;
        }
    }

    public void drawHand(){
        Random rand = new Random();
        for(int i = 0; i<7; i++){
            int cardToTakeIndex = rand.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
    }
    public boolean checkHand(){
        for(Card card: hand) {
            if (card instanceof Pokemon) {
                return true;

            }
        }
        return false;
    }

    public void shuffle(){
        Collections.shuffle(deck);
    }

    public int run(int reshuffles, int numPokemon){
        fillDeck(numPokemon);
        shuffle();
        drawHand();

        if(checkHand()){
            reshuffles++;
        }
        return reshuffles;
    }
}
