import java.util.ArrayList;
import java.util.Random;

/**
 * Represents the Nest Ball Trainer card, which allows a player to search their deck for a Pokemon
 * and place a randomly selected one onto their bench.
 */
public class NestBall extends Trainer {

    // Constructor for NestBall
    public NestBall() {
    }

    /**
     * Executes the playable action of Nest Ball, allowing the player to search
     * their deck for a Pokemon and add a random one to their bench.
     *
     * @param player The player using the Nest Ball card.
     * @param target The target player (not used in this method).
     */
    @Override
    public void playable(Player player, Player target) {
        ArrayList<Card> deck = player.getDeck();
        ArrayList<Card> bench = player.getBenchPile();

        ArrayList<Card> tempPokemon = new ArrayList<Card>(); // Temporary list for Pokemon cards

        int i = 0;
        while (i < deck.size()) {
            if (deck.get(i) instanceof Pokemon) {
                tempPokemon.add(deck.get(i)); // Add Pokemon to temporary list
                deck.remove(i); // Remove Pokemon from deck
            } else {
                i++; // Move to next card if not a Pokemon
            }
        }

        // Select a random Pokemon from tempPokemon and add to bench
        Random rng = new Random();
        int saveRandomNumber = rng.nextInt(tempPokemon.size());
        bench.add(tempPokemon.get(saveRandomNumber)); // Add selected Pokemon to bench
        tempPokemon.remove(saveRandomNumber); // Remove selected Pokemon from temp list

        // Return remaining Pokemon in tempPokemon back to deck
        for (int j = 0; j < tempPokemon.size(); j++) {
            deck.add(tempPokemon.get(j));
        }

        // Print action summary
        System.out.println("Nest Ball has been played");
        System.out.println(player.getName() + " has searched their deck for a Pokemon");
        System.out.println(player.getName() + " has added a random Pokemon to their bench.");
    }

    /**
     * Returns the name of the Trainer card.
     *
     * @return The name "Nest Ball".
     */
    @Override
    public String getName() {
        return "Nest Ball";
    }

}
