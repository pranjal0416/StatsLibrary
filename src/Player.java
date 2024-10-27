import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents a Player in the game, who has a deck, hand, bench, active Pokemon, and other collections of cards.
 * Provides methods for managing the player's actions, including drawing cards, adding to the bench,
 * and playing different types of cards.
 */
public class Player {
    private ArrayList<Card> deck = new ArrayList<>();
    private ArrayList<Card> hand;
    private ArrayList<Card> prizeList;
    private ArrayList<Card> discardList;
    private ArrayList<Card> benchList;
    private ArrayList<Card> active;
    private ArrayList<Pokemon> pokeList;
    private ArrayList<Trainer> trainerList;
    private ArrayList<Energy> energyList;
    private String name;
    private Scanner scan = new Scanner(System.in);

    /**
     * Constructs a new Player with a given name and initializes their collections of cards.
     *
     * @param name The player's name.
     */
    public Player(String name) {
        hand = new ArrayList<>();
        benchList = new ArrayList<>();
        active = new ArrayList<>();
        discardList = new ArrayList<>();
        prizeList = new ArrayList<>();
        trainerList = new ArrayList<>();
        pokeList = new ArrayList<>();
        energyList = new ArrayList<>();
        this.name = name;

        // Add initial Trainer and Pokemon cards to lists
        trainerList.add(new ProfessorsResearch());
        trainerList.add(new GustyPickaxe());
        trainerList.add(new GustofWind());
        trainerList.add(new NestBall());
        pokeList.add(new Pikachu());
        pokeList.add(new Bulbasaur());
        pokeList.add(new Charmander());
        pokeList.add(new Mewtwo());
        pokeList.add(new Lugia());
        makeDeck();
    }

    /**
     * Populates the player's deck with Energy, Trainer, and Pokemon cards, then shuffles the deck.
     */
    public void makeDeck() {
        for (int i = 0; i < 20; i++) {
            deck.add(new Energy());
            deck.add(randomTrainer());
            deck.add(randomPokemon());
        }

        Collections.shuffle(deck);
    }

    /**
     * Draws the initial hand of 7 cards from the deck.
     * If no Pokemon is in the hand, reshuffles the deck and draws again.
     */
    public void getHand() {
        Random rand = new Random();
        for (int i = 0; i < 7; i++) {
            int cardToTakeIndex = rand.nextInt(deck.size());
            hand.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }

      // Check if hand contains at least one Pokemon; reshuffle and redraw if not
        if (!checkHand()) {
            hand.clear();
            deck.clear();
            makeDeck();
            getHand();
        }
    }

    /**
     * Checks if the hand contains at least one Pokemon card.
     *
     * @return true if there is a Pokemon in hand; false otherwise.
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
     * Selects a random Trainer card from the trainer list.
     *
     * @return A randomly selected Trainer card.
     */
    public Trainer randomTrainer() {
        Random rand = new Random();
        return trainerList.get(rand.nextInt(trainerList.size()));
    }

    /**
     * Selects a random Pokemon card from the Pokemon list.
     *
     * @return A randomly selected Pokemon card.
     */
    public Pokemon randomPokemon() {
        Random rand = new Random();
        return pokeList.get(rand.nextInt(pokeList.size()));
    }

    /**
     * Draws 6 prize cards from the deck for the player.
     */
    public void getPrizes() {
        Random rand = new Random();
        for (int i = 0; i < 6; i++) {
            int cardToTakeIndex = rand.nextInt(deck.size());
            prizeList.add(deck.get(cardToTakeIndex));
            deck.remove(cardToTakeIndex);
        }
    }

    /**
     * Draws a single card from the deck to add to the player's hand.
     */
    public void drawCard() {
        Random rand = new Random();
        int cardToTakeIndex = rand.nextInt(deck.size());
        hand.add(deck.get(cardToTakeIndex));
        deck.remove(cardToTakeIndex);
    }

    /**
     * Discards a specified card from the player's hand.
     *
     * @param cardIndex The index of the card to discard.
     */
    public void discardCard(int cardIndex) {
        discardList.add(hand.get(cardIndex));
        hand.remove(cardIndex);
    }

    /**
     * Prints all cards in the player's hand.
     */
    public void printHand() {
        for (int i = 0; i < hand.size(); i++) {
            System.out.println(i + 1 + ": " + hand.get(i).getName() + " ");
        }
    }

    /**
     * Prints all cards in the player's bench list.
     */
    public void printBench() {
        for (int i = 0; i < benchList.size(); i++) {
            System.out.println(i + 1 + ": " + benchList.get(i).getName());
        }
    }

    /**
     * Adds a specified card from the player's hand to their bench.
     *
     * @param cardNumber The index of the card in hand to add to the bench.
     */
    public void addToBench(int cardNumber) {
        if (benchList.size() < 5) {
            benchList.add(hand.get(cardNumber));
            hand.remove(cardNumber);
        } else {
            System.out.println("Bench is full, card is being discarded");
            discardList.add(hand.get(cardNumber));
        }
    }

    /**
     * Adds a specified card from the player's hand to the active slot.
     *
     * @param cardNumber The index of the card in hand to set as active.
     */
    public void addToActive(int cardNumber) {
        if (active.size() < 1) {
            active.add(hand.get(cardNumber));
            hand.remove(cardNumber);
        } else {
            System.out.println("Active slot is full, card will be added to bench");
            addToBench(cardNumber);
        }
    }

    /**
     * Removes a prize card by adding it to the player's hand.
     *
     * @param cardNumber The index of the prize card to remove.
     */
    public void removePrizeCard(int cardNumber) {
        hand.add(prizeList.get(cardNumber));
        prizeList.remove(cardNumber);
    }

    /**
     * Executes a player's turn by drawing a card and allowing player actions.
     *
     * @param player       The player taking the turn.
     * @param targetPlayer The target player (opponent).
     */
    public void turn(Player player, Player targetPlayer) {
        drawCard();
        playerAction(player, targetPlayer);
        System.out.println();
    }

    /**
     * Plays a card from the player's hand. Adds Pokemon to the bench, energy to active Pokemon,
     * or activates trainer cards.
     *
     * @param cardNumber The index of the card in hand to play.
     * @param player     The player playing the card.
     * @param target     The target player (opponent).
     */
    public void playCard(int cardNumber, Player player, Player target) {
        if (hand.get(cardNumber) instanceof Pokemon) {
            addToBench(cardNumber);
            System.out.println("Added to bench");
        } else if (hand.get(cardNumber) instanceof Energy) {
            addEnergy(cardNumber);
            System.out.println("Added to active Pokemon");
        } else if (hand.get(cardNumber) instanceof Trainer) {
            playTrainer(cardNumber, player, target);
            System.out.println("Played trainer card");
        }
    }

    /**
     * Adds an Energy card from hand to the active Pokemon if available.
     *
     * @param cardNumber The index of the Energy card in hand.
     */
    public void addEnergy(int cardNumber) {
        if (active.isEmpty()) {
            System.out.println("No active Pokemon to attach energy to.");
            return;
        }
        if (!(hand.get(cardNumber) instanceof Energy)) {
            System.out.println("Not an energy card");
            return;
        }
        Pokemon activePokemon = (Pokemon) active.get(0);
        Energy energyCard = (Energy) hand.get(cardNumber);
        activePokemon.addEnergy(energyCard);
        discardCard(cardNumber);
        System.out.println("Energy added to active Pokemon");
    }



/**
     * plays trainer card
     * checks if the card is a trainer
     * @param cardNumber inded of card in hand
     * @param player player playing the card for trainer effects
     */
    public void playTrainer(int cardNumber, Player player, Player target){
        //if it is a trainer card, play it
        if (hand.get(cardNumber) instanceof Trainer){
            Trainer trainerCard = (Trainer) hand.get(cardNumber);
            trainerCard.playable(player, target);
            discardCard(cardNumber);
        }
    }

    /**
     * takes
     * @param attackNumber number of attack. interface requires two attacks
     * @param currentPlayer player who is attacking
     * @param targetPlayer player who is getting attacked
     */
    public void Attack(int attackNumber, Player currentPlayer, Player targetPlayer) {
        //if active pile is empty error case
        if (active.isEmpty() || !(active.get(0) instanceof Pokemon)) {
            System.out.println("No active Pokemon to attack with.");
            System.out.println("Your turn is over");
            return;
        }

        // Retrieve the active Pokemon
        Pokemon activePokemon = (Pokemon) active.get(0);


        ArrayList<Card> opponentActivePile = targetPlayer.getActivePile();
        //ArrayList<Card> opponentBenchPile = targetPlayer.getBenchPile();
        if (opponentActivePile.isEmpty()) {
            System.out.println("Opponent has no active Pokemon!");
            return;
        }
        ArrayList<Card> opponentDiscardPile = targetPlayer.getDiscardPile();

        // ArrayList<Card> currentPrizePile = currentPlayer.getPrizePile();
        ArrayList<Card> currentActivePile = currentPlayer.getActivePile();

        //since active pile is card, we need to cast it to pokemon
        Pokemon opponentPokemon = (Pokemon) opponentActivePile.get(0);
        Pokemon currentPokemon = (Pokemon) currentActivePile.get(0);

        // Check the chosen attack and perform the selected attack
        switch (attackNumber) {
            case 1:
                activePokemon.attackOne(opponentPokemon, currentPokemon.getEnergyPile());
                System.out.println("opponent hp: " + opponentPokemon.getHP() + " your hp: " + currentPokemon.getHP());
                break;
            case 2:
                activePokemon.attackTwo(opponentPokemon, currentPokemon.getEnergyPile());
                System.out.println("opponent hp: " + opponentPokemon.getHP() + " your hp: " + currentPokemon.getHP());
                break;
            default:
                System.out.println("Invalid attack number. Please choose 1 or 2.");
                break;
        }
        //checks fainted pokemon
        if (opponentPokemon.getHP() <= 0) {
            System.out.println("Opponent's Pokemon fainted!");
            opponentDiscardPile.add(opponentActivePile.get(0));
            opponentActivePile.remove(0);

            //allows current player to grab a new cardv from prize pile if knockout

            //currentPlayer.printPrizePile();
            //int prizePokemon = scan.nextInt() - 1;
            currentPlayer.hand.add(currentPlayer.prizeList.get(0));
            System.out.println(currentPlayer.prizeList.get(0).getName() + " added to hand");
            currentPlayer.prizeList.remove(0);

        }
    }


    /**
     * prompts player to choose card to play
     * @param player player that is selecting the card
     */
    public void cardSelection(Player player, Player target){
        // Prompt the player to choose a card to play
        player.printHand();
        System.out.println("Pick a card to play: ");
        int cardNum = scan.nextInt() - 1;
        playCard(cardNum, player, target);
        player.printHand();

    }

    /**
     * this method
     * picks an attack from the two to use using scanner.
     * @param player player who has a turn
     * @param targetPlayer player who is the opponent
     */
    public void attackPhase(Player player, Player targetPlayer){
        String attackOneStr = player.active.get(0).getAttackOne();
        String attackTwoStr = player.active.get(0).getAttackTwo();


        // Prompt player to choose the attack
        System.out.println("Pick an attack:");
        System.out.println("1: Attack One: " + attackOneStr);
        System.out.println("2: Attack Two: " + attackTwoStr);

        int attackNumber = scan.nextInt();
        scan.nextLine(); // Consume newline character

        if (attackNumber == 1 || attackNumber == 2) {
            Attack(attackNumber, player, targetPlayer);
        } else {
            System.out.println("Invalid attack number! Choose 1 or 2.");
        }
    }

    /**
     * chooses card from the bench to add to active
     * if the active pile is full, print active is full
     * @param cardNumber number from the bench
     */
    public void benchToActive(int cardNumber){
        if (active.size() < 1){
            active.add(benchList.get(cardNumber));
            benchList.remove(cardNumber);
        }
        else{
            //swaps active and bench pokemon
            Card temp = active.get(0);
            active.remove(0);
            active.add(benchList.get(cardNumber));
            benchList.remove(cardNumber);
            benchList.add(temp);
            System.out.println("You swapped active pokemon with bench pokemon");
            System.out.println();
        }
    }

    /**
     * while continue turn is true or until the player ends turn
     * allows current player to choose from an action
     * turn continues until player inputs 4 to end turn
     * @param player player who has current turn
     * @param targetPlayer opponent player for that turn
     */
    public void playerAction(Player player, Player targetPlayer){
        //while the continueTurn keep playing turn
        //if the player ends turn, condition turns false causing turn loop to end.
        boolean continueTurn = true;
        while(continueTurn == true){
            // ask the player to choose an action number
            //player.printHand();
            System.out.println();
            System.out.println("Choose an action:");
            System.out.println("1: Play a card");
            System.out.println("2: Move a Pokemon from bench to active");
            System.out.println("3: Attack");
            System.out.println("4: End turn");
            System.out.println();

            int actionChoice = scan.nextInt();
            scan.nextLine();

            if (actionChoice == 1) {
                cardSelection(player,targetPlayer);
            } else if (actionChoice == 2) {
                if (benchList.size() == 0){
                    System.out.println("No Pokemon in bench to move to active.");
                }
                else{
                    System.out.println("Choose a Pokemon to move from bench to active:");
                    player.printBench();
                    int benchPokemon = scan.nextInt() - 1;
                    benchToActive(benchPokemon);}
            }else if (actionChoice == 3) {
                attackPhase(player, targetPlayer);
                System.out.println("Turn ended.");
                continueTurn = false;
            } else if (actionChoice == 4) {
                System.out.println("Turn ended.");
                System.out.println();
                continueTurn = false;
            } else {
                System.out.println("Invalid action number! Choose 1, 2, or 3.");
            }
        }
    }

    /**
     * @return returns deck
     */
    public ArrayList<Card> getDeck(){
        return deck;
    }

    /**
     * @return returns hand
     */
    public ArrayList<Card> returnHand(){
        return hand;
    }

    /**
     * @return returns prize pile
     */
    public ArrayList<Card> getPrizePile(){
        return prizeList;
    }

    /**
     * @return returns discard pile for whatever reason
     */
    public ArrayList<Card> getDiscardPile(){
        return discardList;
    }

    /**
     * @return returns bench pile
     */
    public ArrayList<Card> getBenchPile(){
        return benchList;
    }

    /**
     * @return returns active pile
     */
    public ArrayList<Card> getActivePile(){
        return active;
    }

    /**
     * @return returns name of player
     */
    public String getName(){
        return name;
    }


}
