package ai.my_excersises_based_on_package.eightqueens_backtrack;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class EightQueen {

    private Queue<Integer> queens = new PriorityQueue<>();
    private int[][] board = new int[8][8];
    private int EMPTY = 0;

    public int[][] getBoard() {
        return board;
    }

    EightQueen() {
        for (int i = 1; i <= 8; i++)
            queens.add(i);
    }

    public boolean isOkTo(int[][] matrix, int indexOfRow, int indexOfCol) {
        for (int i = 0; i < matrix.length ; i++) {
            for (int j = 0; j < matrix[i].length ; j++) {
                //delta on each step
                int reminderRow = Math.abs(indexOfRow - i);
                int reminderCol = Math.abs(indexOfCol - j);
                //checks \ positions of given position on matrix
                if (reminderRow > 0 && reminderRow == reminderCol && matrix[i][j] != EMPTY) {
                    System.out.printf("failure in row col %d %d with %d %n", i, j, matrix[i][j]);
                    return false;
                }
                if (matrix[indexOfRow][j] != EMPTY) {
                    System.out.printf("failure in col %d with %d %n", j, matrix[i][j]);
                    return false;
                }
            }
            if (matrix[i][indexOfCol] != EMPTY) {
                System.out.printf("failure in row %d with %d %n", i, matrix[i][indexOfCol]);
                return false;
            }
        }
        for (int i = matrix.length - 1; i > 0 ; i--) {
            for (int j = matrix[i].length - 1; j > 0; j--) {
                //delta on each step
                int reminderRow = Math.abs(indexOfRow - i);
                int reminderCol = Math.abs(indexOfCol - j);
                //checks / positions of given position on matrix
                if (reminderRow > 0 && reminderRow == reminderCol && matrix[i][j] != EMPTY) {
                    //System.out.printf("failure in col row %d %d with %d %n", i, j, matrix[i][j]);
                    return false;
                }
            }
        }
        return true;
    }

    public boolean solve() {
        if (!queens.isEmpty()) {
            if (queens.size()==8) {
                int myQueen = queens.poll();
                board[5][0] = myQueen;
            }
            int myQueen = queens.poll();
            for (int i = 0; i <= board.length - 1; i++) {
                for (int j = 0; j <= board[i].length - 1; j++) {
                    if (board[i][j] == EMPTY ) {
                        if (isOkTo(board, i, j)) {
                            board[i][j] = myQueen;
                            String s1 = ThreadColor.values()[new Random().nextInt(ThreadColor.values().length)].getColor();
                            System.out.printf("%s queen of %d has been placed in %d %d %n", s1, myQueen, i, j);
                            if (solve()) {
                                return true;
                            } else {
                                board[i][j] = EMPTY;
                            }
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


}
