import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardGame {
    private ArrayList<Card> deck;
    private ArrayList<Card> hand;
    private ArrayList<Card> prize;

    public CardGame() {
        deck = new ArrayList<>();
        hand = new ArrayList<>();
        prize = new ArrayList<>();

    }

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



    public void drawHand() {
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            int cardToTakeIndex = rand.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
    }

    public boolean checkHand() {
        for (Card card : hand) {
            if (card instanceof Pokemon) {
                return true;

            }
        }
        return false;
    }

    public void shuffle() {
        Collections.shuffle(deck);
    }

    public int run(int reshuffles, int numPokemon) {
        fillDeck(numPokemon,0,0);
        shuffle();
        drawHand();

        if (checkHand()) {
            reshuffles++;
        }
        return reshuffles;
    }


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

    public void monte2(){
        String[][] resultMatrix = pokemonRareCandiesSimulation();
        for (int i = 0; i < resultMatrix.length; i++) {
            System.out.println();
            for (int j = 0; j < resultMatrix[i].length; j++) {
                System.out.print(resultMatrix[i][j] + "    ");
            }
        }
    }

    public void placePrizeCards() {
        for (int i = 0; i < 6; i++) {
            prize.add(deck.get(0));
            deck.remove(0);
        }
    }

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

                    if(!isCandyBricked(game)) {
                        candyInPrizeCount++;
                    }
                }
                double rareCandiesProbability = ((double) candyInPrizeCount / testCount) * 100.0;
                resultMatrix[i][0] = String.valueOf(i);
                resultMatrix[i][1] = String.valueOf(rareCandiesProbability + "%");
            }
            return resultMatrix;
        }

        private boolean isCandyBricked(CardGame player) {
            boolean isPrize = false;


            for (int i = 0; i < player.prize.size(); i++) {
                if (player.prize.get(i) instanceof Trainer) {
                    isPrize = true;
                    break;
                }
            } return isPrize;
        }

    }

