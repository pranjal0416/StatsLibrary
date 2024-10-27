public class RunMonteCarlo {

    public static void main(String[] args) {
        Deal.noChange();
        System.out.println();
        System.out.println();
        System.out.println();

        Deal.change();
        System.out.println();
        System.out.println();
        System.out.println();

        Birthday.returnProb();
        System.out.println();
        System.out.println();
        System.out.println();

        CardGame game = new CardGame();
        game.monte1();
        System.out.println();
        System.out.println();
        System.out.println();
        game.monte2();

    }

}
