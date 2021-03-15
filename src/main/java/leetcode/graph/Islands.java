package leetcode.graph;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-islands/
public class Islands {

    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        int numberOfIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (!visited.contains(row + "_" + col) && grid[row][col] == '1') {
                    bfs(grid, row, col, visited);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    void bfs(char[][] grid, int row, int col, Set<String> visited) {
        visited.add(row + "_" + col);
        int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow < 0 || nextCol < 0
                || nextRow >= grid.length || nextCol >= grid[0].length
                || grid[nextRow][nextCol] == '0' || visited.contains(nextRow + "_" + nextCol)) {
                continue;
            }
            bfs(grid, nextRow, nextCol, visited);
        }
    }
}
