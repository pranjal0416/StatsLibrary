import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Represents a card game with a deck, hand, and prize pile.
 */
public class CardGame {
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prize;

    public CardGame() {
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        prize = new ArrayList<>();

    }

    /**
     * Fills a deck with a specified number of Pokemon, Trainer, and Energy cards.
     *
     * @param numPokemon The number of Pokemon cards to add to the deck
     * @param numTrainer The number of Trainer cards to add to the deck
     * @param numEnergy The number of Energy cards to add to the deck
     */
    public void fillDeck(int numPokemon, int numTrainer, int numEnergy) {
        for (int i = 0; i < 60 - numPokemon - numTrainer; i++) {
            deck.add(new Energy());
        }
        int i = 0;
        while (i < numPokemon) {
            deck.add(new Charmander());
            i++;
        }
        int j = 0;
        while (j < numTrainer) {
            deck.add(new RareCandy());
            j++;
        }
        Collections.shuffle(deck);
    }



    /**
     * Draws 7 cards from the deck randomly and adds them to the hand and removes them from the deck.
     */
    public void drawHand() {
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            int cardToTakeIndex = rand.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
    }

    /**
     * Checks if the player's hand contains any Pokemon cards.
     *
     * @return true if the hand contains at least one Pokemon card, false otherwise
     */
    public boolean checkHand() {
        for (Card card : hand) {
            if (card instanceof Pokemon) {
                return true;

            }
        }
        return false;
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle() {
        Collections.shuffle(deck);
    }

    /**
     * Simulates a card game by filling the deck, shuffling it, drawing a hand, and checking if the hand is valid.
     *
     * @param reshuffles The number of reshuffles that have been done so far
     * @param numPokemon The number of Pokemon cards in the deck
     * @return The updated number of reshuffles after checking the hand
     */
    public int run(int reshuffles, int numPokemon) {
        fillDeck(numPokemon,0,0);
        shuffle();
        drawHand();

        if (checkHand()) {
            reshuffles++;
        }
        return reshuffles;
    }


    /**
     * Simulates multiple runs of a card game with varying numbers of Pokemon cards.
     * Calculates the probability of reshuffling needed for a valid hand in the game for each number of Pokemon cards.
     */
    public void monte1() {
        int reshuffles = 0;
        int numPokemon = 0;
        for (int j = 1; j < 61; j++) {
            numPokemon = j;
            reshuffles = 0;
            for (int i = 0; i < 10000; i++) {
                CardGame game = new CardGame();
                reshuffles = game.run(reshuffles, numPokemon);
            }
            System.out.println("Probability is: " + (double) reshuffles / 10000 + " for " + numPokemon + " Pokemon");

        }
    }

    /**
     * Runs a simulation of Pokemon rare candies and prints the resulting matrix.
     * The matrix represents the simulation results.
     */
    public void monte2(){
        String[][] resultMatrix = pokemonRareCandiesSimulation();
        for (int i = 0; i < resultMatrix.length; i++) {
            System.out.println();
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + "    ");
            }
        }
        /*System.out.println();
        for(int i =1; i< 5; i++){
            for(int j =1; j< 5; j++){
                System.out.println("probability of prizing " + j + " candy(s) when there's " + i + " candy(s) in the deck: " + probabilityOfPrized(i,j));
            }
        }*/
    }

    /**
     * Places 6 prize cards from the deck into the prize pile.
     * The method iterates through the deck and adds the first card to the prize pile,
     * then removes that card from the deck. This process is repeated 6 times.
     */
    public void placePrizeCards() {
        for (int i = 0; i < 6; i++) {
            prize.add(deck.get(0));
            deck.remove(0);
        }
    }

    /**
     * Simulates the opening hand phase for a player in a card game.
     * The player draws a hand, checks if the hand is valid, reshuffles the deck if needed,
     * and gets prize cards once the opening hand is ready.
     *
     * @param player The player for whom the opening hand is being simulated
     */
    public void openingHand(CardGame player) {
        player.drawHand();
        boolean openingHandsReady = false;
        while (!openingHandsReady) {
            if (!player.checkHand()) {
                deck.addAll(hand);
                hand.clear();
                Collections.shuffle(deck);
                player.drawHand();
            } else {
                openingHandsReady = true;
            }
        }
        player.placePrizeCards();
    }



    /**
     * Simulates the chance of bricking based on the number of Rare Candies in a deck of 60 cards.
     * The simulation runs for 10,000 test cases and calculates the probability of not bricking.
     *
     * @return A 2D array containing the number of Rare Candies and the corresponding chance of not bricking.
     */
    public String[][] pokemonRareCandiesSimulation() {

        String[][] resultMatrix = new String[5][2];
        resultMatrix[0][0] = "Number of Rare Candies in a Deck of 60";
        resultMatrix[0][1] = "Chance (%) of Bricking";
        int testCount = 10000;
        for (int i = 1; i <= 4; i++) {
            int candyInPrizeCount = 0;
            for (int j = 0; j < testCount; j++) {
                CardGame game = new CardGame();
                game.fillDeck(20, i, 40-i);
                //game.drawHand();
                openingHand(game);

                if(isCandyBricked(game)) {
                    candyInPrizeCount++;
                }
            }
            double rareCandiesProbability = (1-(double) candyInPrizeCount / testCount) * 100.0;
            resultMatrix[i][0] = String.valueOf(i);
            resultMatrix[i][1] = String.valueOf(rareCandiesProbability + "%");
        }
        return resultMatrix;
    }

    /**
     * Checks if a player's prize cards contain a Trainer card, indicating the players deck is bricked.
     *
     * @param player  player whose deck to check
     * @return true if the player has a Trainer card in their prize cards
     */
    private boolean isCandyBricked(CardGame player) {
        boolean isPrize = false;


        for (int i = 0; i < player.prize.size(); i++) {
            if (player.prize.get(i) instanceof Trainer) {
                isPrize = true;
                break;
            }
        } return isPrize;
    }

    public static BigInteger probabilityOfPrized(int totalRareCandies, int prizedCandies) {
        if (prizedCandies > totalRareCandies)
            return null;
        int total_cards = 60;
        int total_prized = 6;

        BigInteger waysToChoosePrized = StatsLib.combinations(totalRareCandies, prizedCandies);

        BigInteger waysToChooseNonPrized = StatsLib.combinations(total_cards - totalRareCandies, total_prized - prizedCandies);

        BigInteger totalWaysToChoose = StatsLib.combinations(total_cards, total_prized);

        return ( waysToChoosePrized.multiply(waysToChooseNonPrized)).divide(totalWaysToChoose) ;
    }

}


