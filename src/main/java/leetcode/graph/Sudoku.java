package leetcode.graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/sudoku-solver/
public class Sudoku {

    private Map<Integer, Set<Integer>> rowCache;
    private Map<Integer, Set<Integer>> colCache;
    private Map<Integer, Set<Integer>> boxCache;

    public void solveSudoku(char[][] board) {
        resetCache();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int digit = Character.getNumericValue(board[i][j]);
                    placeDigit(digit, i, j, board);
                }
            }
        }
        solveSudoku(board, 0, 0);
    }

    public boolean isValidSudoku(char[][] board) {
        resetCache();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    int digit = Character.getNumericValue(board[i][j]);
                    if (!canPlaceDigit(digit, i, j, board)) {
                        return false;
                    }
                    placeDigit(digit, i, j, board);
                }
            }
        }
        return true;
    }

    private void resetCache() {
        rowCache = new HashMap<>();
        colCache = new HashMap<>();
        boxCache = new HashMap<>();
    }

    private boolean solveSudoku(char[][] board, int row, int col) {
        if (row >= board.length) {
            return true;
        }
        if (col >= board[0].length) {
            return solveSudoku(board, row + 1, 0);
        }
        if (board[row][col] == '.') {
            for (int d = 1; d < 10; d++) {
                if (canPlaceDigit(d, row, col, board)) {
                    placeDigit(d, row, col, board);
                    boolean solved = solveSudoku(board, row, col + 1);
                    if (solved) {
                        return true;
                    }
                    removeDigit(d, row, col, board);
                }
            }
            return false;
        }
        return solveSudoku(board, row, col + 1);
    }

    private boolean canPlaceDigit(int d, int row, int col, char[][] board) {
        int boxNumber = box(row, col, board.length);
        return !rowCache.getOrDefault(row, new HashSet<>()).contains(d) &&
            !colCache.getOrDefault(col, new HashSet<>()).contains(d) &&
            !boxCache.getOrDefault(boxNumber, new HashSet<>()).contains(d);
    }


    private void placeDigit(int d, int row, int col, char[][] board) {
        board[row][col] = (char) (d + '0');
        rowCache.putIfAbsent(row, new HashSet<>());
        rowCache.get(row).add(d);
        colCache.putIfAbsent(col, new HashSet<>());
        colCache.get(col).add(d);
        int boxNumber = box(row, col, board.length);
        boxCache.putIfAbsent(boxNumber, new HashSet<>());
        boxCache.get(boxNumber).add(d);
    }

    private void removeDigit(int d, int row, int col, char[][] board) {
        board[row][col] = '.';
        rowCache.get(row).remove(d);
        colCache.get(col).remove(d);
        int boxNumber = box(row, col, board.length);
        boxCache.get(boxNumber).remove(d);
    }

    private int box(int row, int col, int n) {
        return ((row / 3) * 3) + (col / 3);
    }
}
