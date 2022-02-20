package leetcode.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    private static final int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    //https://leetcode.com/problems/rotting-oranges/
    public int orangesRotting(int[][] grid) {
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    count++;
                }
            }
        }
        return totalMinutes(grid, queue, count);
    }

    private int totalMinutes(int[][] grid, Queue<int[]> queue, int count) {
        int minutes = 0;
        while (!queue.isEmpty() && count > 0) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                int[] current = queue.poll();
                for (int[] direction : directions) {
                    int nextX = direction[0] + current[0];
                    int nextY = direction[1] + current[1];
                    if (nextX >= 0 && nextY >= 0 &&
                        nextX < grid.length && nextY < grid[0].length) {
                        if (grid[nextX][nextY] == 1) {
                            count--;
                            grid[nextX][nextY] = 2;
                            queue.offer(new int[]{nextX, nextY});
                        }
                    }
                }
            }
            minutes++;
        }
        return count == 0 ? minutes : -1;
    }
}
