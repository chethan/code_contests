package leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

//https://leetcode.com/problems/word-search/
public class WordSearch {

    public List<String> findWords(char[][] board, String[] words) {
        return Arrays.stream(words).filter(w -> exist(board, w))
            .collect(Collectors.toList());
    }

    public boolean exist(char[][] board, String word) {
        if (board.length == 0) {
            return false;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                boolean found = searchInGrid(board, word, i, j, 0);
                if (found) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean searchInGrid(char[][] board, String word, int row, int col, int index) {
        int rowLength = board.length;
        int colLength = board[0].length;

        if (index >= word.length()) {
            return true;
        }

        if (row < 0 || row >= rowLength ||
            col < 0 || col >= colLength ||
            board[row][col] != word.charAt(index)) {
            return false;
        }

        board[row][col] = '#';
        boolean found = false;
        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; d++) {
            found = searchInGrid(board, word, row + rowOffsets[d], col + colOffsets[d], index + 1);
            if (found) {
                break;
            }
        }

        board[row][col] = word.charAt(index);
        return found;
    }
}
