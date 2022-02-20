package leetcode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class Islands {

    private static final int[][] directions = {{0, -1}, {-1, 0}, {0, 1}, {1, 0}};

    //https://leetcode.com/problems/number-of-islands/
    public int numIslands(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        Set<String> visited = new HashSet<>();
        int numberOfIslands = 0;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (!visited.contains(row + "_" + col) && grid[row][col] == '1') {
                    dfs(grid, row, col, visited);
                    numberOfIslands++;
                }
            }
        }
        return numberOfIslands;
    }

    //https://leetcode.com/problems/max-area-of-island/
    public int maxAreaOfIsland(int[][] grid) {
        int rowSize = grid.length;
        if (rowSize == 0) {
            return 0;
        }
        int colSize = grid[0].length;
        int maxArea = 0;
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                if (grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, areaOfIsland(grid, i, j));
                }
            }
        }
        return maxArea;
    }


    //https://leetcode.com/problems/island-perimeter/
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (!visited[i][j] && grid[i][j] == 1) {
                    return dfsForPerimeter(i, j, visited, grid);

                }
            }
        }
        return 0;
    }

    //https://leetcode.com/problems/shortest-bridge/
    //DFS->to get one Island , BFS -> to find the shortest distance b/w this island to other
    public int shortestBridge(int[][] grid) {
        int rowLength = grid.length;
        if (rowLength == 0) {
            return 0;
        }
        int colLength = grid[0].length;
        Queue<int[]> island = getIslandNodes(grid, rowLength, colLength);
        int bridgeLength = 0;
        while (!island.isEmpty()) {
            int size = island.size();
            for (int i = 0; i < size; i++) {
                int[] current = island.poll();
                for (int[] direction : directions) {
                    int newRow = current[0] + direction[0];
                    int newCol = current[1] + direction[1];
                    if (newRow < 0 || newCol < 0 || newRow >= grid.length
                        || newCol >= grid[0].length || grid[newRow][newCol] == 2) {
                        continue;
                    }
                    if (grid[newRow][newCol] == 1) {
                        return bridgeLength;
                    }
                    island.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 2;
                }


            }
            bridgeLength++;
        }
        return -1;
    }

    private void dfs(char[][] grid, int row, int col, Set<String> visited) {
        visited.add(row + "_" + col);
        for (int[] direction : directions) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];
            if (nextRow < 0 || nextCol < 0
                || nextRow >= grid.length || nextCol >= grid[0].length
                || grid[nextRow][nextCol] == '0' || visited.contains(nextRow + "_" + nextCol)) {
                continue;
            }
            dfs(grid, nextRow, nextCol, visited);
        }
    }

    private int dfsForPerimeter(int i, int j, boolean[][] visited, int[][] grid) {
        if (visited[i][j]) {
            return 0;
        }
        visited[i][j] = true;
        int perimeter = 0;
        for (int[] direction : directions) {
            int newX = i + direction[0];
            int newY = j + direction[1];
            if (newX >= 0 &&
                newX < grid.length && newY < grid[0].length && newY >= 0 && grid[newX][newY] != 0) {
                perimeter += dfsForPerimeter(newX, newY, visited, grid);
            } else {
                perimeter++;
            }
        }
        return perimeter;
    }

    private int areaOfIsland(int[][] grid, int row, int col) {
        int area = 1;
        grid[row][col] = 2;
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length) {
                continue;
            }
            if (grid[newRow][newCol] == 1) {
                area += areaOfIsland(grid, newRow, newCol);
            }
        }
        return area;
    }

        private Queue<int[]> getIslandNodes(int[][] grid, int rowLength, int colLength) {
        Queue<int[]> island = new LinkedList<>();
        for (int i = 0; i < rowLength; i++) {
            if (!island.isEmpty()) {
                break;
            }
            for (int j = 0; j < colLength; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 2;
                    island.offer(new int[]{i, j});
                    islandNodes(grid, i, j, island);
                    break;
                }
            }
        }
        return island;
    }


    private void islandNodes(int[][] grid, int row, int col, Queue<int[]> island) {
        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];
            if (newRow < 0 || newCol < 0 || newRow >= grid.length || newCol >= grid[0].length) {
                continue;
            }
            if (grid[newRow][newCol] == 1) {
                grid[newRow][newCol] = 2;
                island.offer(new int[]{newRow, newCol});
                islandNodes(grid, newRow, newCol, island);
            }
        }
    }
}
