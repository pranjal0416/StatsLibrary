import java.util.ArrayList;

/**
 * Represents a trainer named Gust of Wind.
 *
 */
public class GustofWind extends Trainer{
    public GustofWind(){
    }
    /**
     * Returns the name of the card.
     *
     * @return The name of the card.
     */
    public String getName() {
        return "Gust of Wind";
    }


    /**
     * Initiates the playable action "Gust of Wind" where the player switches the opponent's active card with a bench card.
     *
     * @param player The player initiating the action
     * @param target The opponent player whose active card is being switched
     */
    @Override
    public void playable(Player player, Player target) {
        if(!target.getBenchPile().isEmpty()) {
            target.benchToActive(0);
            System.out.println("Gust of Wind has been played");
            System.out.println(player.getName() + " has switched opponent's active card with a bench card");
        }
        else{
            System.out.println("Opponent's bench is empty Gust of Wind can't be played");
        }
    }
}