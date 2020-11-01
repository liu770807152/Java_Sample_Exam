package comp1110.exam;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * COMP1110 Final Exam, Question 1ii
 *
 * Discover all victims (reachable white pieces), given a the initial board
 * and a black knight placed at a particular start position.  The initial board
 * may contain black and/or white pieces in addition to the black knight.
 *
 * A black knight may tour an 8 x 8 chess board according to the following
 * rules:
 *   1. It may move from its current square to any of the eight nearby squares
 *      reachable by either: moving sideways two and vertically one; or vertically
 *      two and sideways one.  Given the board below, a piece at '*' may move to
 *      any of the positions marked with an 'X'.
 *
 *       . X . X .
 *       X . . . X
 *       . . * . .
 *       X . . . X
 *       . X . X .
 *
 *   2. It may not move to a square off the 8 x 8 board
 *
 *   3. It may not move to a square already occupied by another piece
 *
 * The number of 'victims' of the black knight is equal to all of the
 * white pieces that it could ever have reached on a tour according to the
 * above rules for touring the board.
 */
public class Q1Tour {
    enum Piece { black, white }
    Piece[][] pieces = new Piece[8][8];

    /**
     * Construct a new instance with a particular placement
     * @param placement
     */
    Q1Tour(String placement) {
        populateBoard(placement);
    }

    /**
     * Take a placement string and populate the board
     * @param placement A string describing placement of black and white pieces
     */
    private void populateBoard(String placement) {
        for(int i = 0; i < placement.length(); i+=3) {
            String piece = placement.substring(i,i+3);
            int col = (piece.charAt(1)-'A');
            int row = (piece.charAt(2)-'1');
            this.pieces[col][row] = (piece.charAt(0) == 'B') ? Piece.black : Piece.white;
        }
    }


    private ArrayList parse(String pos) {
        int col = (pos.charAt(0)-'A');
        int row = (pos.charAt(1)-'1');
        ArrayList<Integer> result = new ArrayList<>(){{
            add(row);
            add(col);
        }};
        return result;
    }

    private boolean isReachable(int row, int col) {
        if (row > 7 || row < 0 || col > 7 || col < 0) {
            return false;
        }
        return pieces[row][col] == null || !pieces[row][col].equals(Piece.black);
    }

    private boolean isVictim(int row, int col) {
        return pieces[row][col] != null && pieces[row][col].equals(Piece.white);
    }

    private ArrayList getNextPosition(ArrayList pos) {
        int[][] rules = {{-2, -1}, {-2, 1}, {2, -1}, {2, 1}, {-1, 2}, {-1, -2}, {1, -2}, {1, 2}};
        int row = (int) pos.get(0);
        int col = (int) pos.get(1);
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int[] current : rules) {
            int r = current[0], c = current[1];
            int newRow = row + r;
            int newCol = col + c;
            ArrayList temp = new ArrayList<>(){{
                add(newRow);
                add(newCol);
            }};
            if (isReachable(newRow, newCol)) {
                result.add(temp);
            }
        }
        return result;
    }

    /**
     * Find the number of victims for a black knight's tour, starting at a specific
     * position (according to the rules described above).
     *
     * @param start  The starting point for the black knight is described as a two letter
     *               string, the column ('A'-'H')followed by the row ('1'-'8').
     * @return The number of white pieces reachable by a knight's tour from the
     * starting point (according to the rules above).
     */
    public int tourVictims(String start) {
        Set<ArrayList<Integer>> visited = new HashSet<>();
        return traverse(parse(start), visited);
    }

    private int traverse(ArrayList pos, Set visited) {
        if (visited.contains(pos)) {
            return 0;
        }
        visited.add(pos);
        int row = (int) pos.get(0);
        int col = (int) pos.get(1);
        int count = 0;
        if (isVictim(row, col)) {
            count++;
        }
        ArrayList<ArrayList<Integer>> nextPositions = getNextPosition(pos);
        for (ArrayList current : nextPositions) {
            count += traverse(current, visited);
        }
        return count;
    }
}
