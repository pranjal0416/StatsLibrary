import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //Deal.noChange();
        //Deal.change();

        //int prob = 0;
        //for(int i = 0; i < 10000; i++){
            //prob = Birthday.runProb(31,prob);
        //}
        //System.out.println("Probability is: " + (double) prob/10000);


        int reshuffles = 0;
        int numPokemon = 0;
        for(int j = 1; j < 61; j++) {
            numPokemon = j;
            reshuffles = 0;
            for (int i = 0; i < 10000; i++) {
                CardGame game = new CardGame();
                reshuffles = game.run(reshuffles, numPokemon);
            }
            System.out.println("Probability is: " + (double) reshuffles / 10000 + " for " + numPokemon + " Pokemon" );

        }
        }
    }
