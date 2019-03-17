package ai.my_excersises_based_on_package.eightqueens_backtrack;

import java.util.Random;

public class Main {


    public static void main(String[] args) {

        EightQueen eightQueen = new EightQueen();
        eightQueen.solve();
        for (int i = 0; i < eightQueen.getBoard().length; i++) {
            for (int j = 0; j < eightQueen.getBoard()[i].length; j++) {
                String s1 = ThreadColor.values()[new Random().nextInt(ThreadColor.values().length)].getColor();
                if (eightQueen.getBoard()[i][j] == 0)
                    System.out.printf("%s%d    ", ThreadColor.ANSI_RESET.getColor(), eightQueen.getBoard()[i][j]);
                else
                    System.out.printf("%s%d    ", s1, eightQueen.getBoard()[i][j]);
            }
            System.out.println();
        }


    }


}
