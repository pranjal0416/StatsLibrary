import java.util.ArrayList;

public class GustofWind extends Trainer{
    public GustofWind(){
    }
    public String getName() {
        return "Gust of Wind";
    }

    @Override
    public void playable(Player player, Player target) {
        ArrayList<Card> active = target.getActivePile();
        ArrayList<Card> bench = player.getBenchPile();
        target.benchToActive(0);
        System.out.println("Gust of Wind has been played");
        System.out.println(player.getName() + " has switched opponent's active card with a bench card");
    }
}