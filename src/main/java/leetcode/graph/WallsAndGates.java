package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/walls-and-gates/
public class WallsAndGates {

    private static final int[][] directions = new int[][]{{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    public void wallsAndGates(int[][] rooms) {
        int rows = rooms.length;
        if (rows == 0) {
            return;
        }
        int cols = rooms[0].length;
        Queue<int[]> gates = getGates(rooms, rows, cols);
        while (!gates.isEmpty()) {
            int[] current = gates.poll();
            for (int[] direction : directions) {
                int newRow = current[0] + direction[0];
                int newCol = current[1] + direction[1];
                if (newRow < 0 || newCol < 0 || newRow >= rows || newCol >= cols) {
                    continue;
                }
                if (rooms[newRow][newCol] != Integer.MAX_VALUE) {
                    continue;
                }
                rooms[newRow][newCol] = rooms[current[0]][current[1]] + 1;
                gates.offer(new int[]{newRow, newCol});
            }
        }
    }

    private Queue<int[]> getGates(int[][] rooms, int rows, int cols) {
        Queue<int[]> gates = new LinkedList<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (rooms[i][j] == 0) {
                    gates.offer(new int[]{i, j});
                }
            }
        }
        return gates;
    }

}
