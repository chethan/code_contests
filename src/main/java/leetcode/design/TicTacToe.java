package leetcode.design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/design-tic-tac-toe/
public class TicTacToe {

    private final Grid grid;

    public TicTacToe(int n) {
        grid = new Grid(n);
    }

    public int move(int row, int col, int player) {
        return grid.move(row, col, player);
    }

    private static class Grid {

        private final int size;
        private final Map<Integer, Count> rowCount;
        private final Map<Integer, Count> colCount;
        private final Map<Integer, Count> diagonalCount;

        Grid(int n) {
            size = n;
            rowCount = new HashMap<>();
            colCount = new HashMap<>();
            diagonalCount = new HashMap<>();
            diagonalCount.put(1, new Count(n));
            diagonalCount.put(2, new Count(n));
            for (int i = 0; i < n; i++) {
                rowCount.put(i, new Count(n));
                colCount.put(i, new Count(n));
            }
        }

        int move(int row, int col, int player) {
            rowCount.get(row).add(player);
            colCount.get(col).add(player);
            getDiagonal(row, col)
                .forEach(d -> diagonalCount.get(d).add(player));
            if (isComplete(row, col)) {
                return player;
            }
            return 0;
        }

        private boolean isComplete(int row, int col) {
            if (rowCount.get(row).isComplete() || colCount.get(col).isComplete()) {
                return true;
            }
            return (diagonalCount.get(1).isComplete() || diagonalCount.get(2).isComplete());
        }

        List<Integer> getDiagonal(int row, int col) {
            List<Integer> diagonals = new ArrayList<>();
            if (row == col) {
                diagonals.add(1);
            }
            if (row + col == size - 1) {
                diagonals.add(2);
            }
            return diagonals;
        }
    }

    private static class Count {

        Map<Integer, Integer> playerCount;
        int size;

        Count(int size) {
            this.size = size;
            this.playerCount = new HashMap<>();
        }

        void add(int player) {
            playerCount.put(player, playerCount.getOrDefault(player, 0) + 1);
        }

        boolean isComplete() {
            for (int player : playerCount.keySet()) {
                if (playerCount.get(player) == size) {
                    return true;
                }
            }
            return false;
        }

    }

}
