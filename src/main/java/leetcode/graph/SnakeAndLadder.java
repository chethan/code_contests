package leetcode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class SnakeAndLadder {

    //https://leetcode.com/problems/snakes-and-ladders/
    public int minMoves(int[][] board) {
        if (board == null || board.length == 0) {
            return -1;
        }
        int moves = 0, end = board.length * board[0].length;
        int[] linearBoard = toLinerBoard(board, end);

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        Set<Integer> visited = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int current = queue.poll();
                if (current == end) {
                    return moves;
                }
                if (visited.contains(current)) {
                    continue;
                }
                visited.add(current);

                for (int j = 1; j <= 6 && (current + j) <= end; j++) {
                    int value = linearBoard[current + j];
                    queue.offer(value != -1 ? value : current + j);
                }
            }
            moves++;
        }
        return -1;
    }

    private int[] toLinerBoard(int[][] board, int end) {
        int[] linearBoard = new int[end + 1];
        boolean left = true;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int boardYIndex = left ? j : board[0].length - j - 1;
                int boardXIndex = board[0].length - i - 1;
                linearBoard[i * board[0].length + j + 1] = board[boardXIndex][boardYIndex];
            }
            left = !left;
        }
        return linearBoard;
    }
}
