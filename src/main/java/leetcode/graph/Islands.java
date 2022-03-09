package leetcode.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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

    //https://leetcode.com/problems/count-sub-islands/
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        //remove all the islands not matching the grid1 island in grid2
        int row = grid2.length, col = grid2[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid1[i][j] == 0 && grid2[i][j] == 1) {
                    dfsForSubIslands(i, j, grid2);
                }
            }
        }
        //count the islands in grid2
        int count = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid2[i][j] == 1) {
                    dfsForSubIslands(i, j, grid2);
                    count++;
                }
            }
        }
        return count;

    }

    //https://leetcode.com/problems/making-a-large-island/
    //Time: O(N^2)
    //Space: O(N^2)
    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> areaMap = new HashMap<>();
        int islandIndex = 2, maxArea = 0;
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 1) {
                    int area = dfs(r, c, grid, islandIndex);
                    areaMap.put(islandIndex, area);
                    maxArea = Math.max(area, maxArea);
                    islandIndex++;
                }
            }
        }
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == 0) {
                    int area = sumOfNeighbourArea(r, c, areaMap, grid);
                    maxArea = Math.max(area, maxArea);
                }
            }
        }
        return maxArea;


    }

    void dfsForSubIslands(int row, int col, int[][] grid2) {
        if (grid2[row][col] == 0) {
            return;
        }
        grid2[row][col] = 0;
        for (int[] direction : directions) {
            int newX = row + direction[0];
            int newY = col + direction[1];
            if (newX >= 0 && newY >= 0 && newX < grid2.length && newY < grid2[0].length) {
                dfsForSubIslands(newX, newY, grid2);
            }
        }
    }

    private int sumOfNeighbourArea(int r, int c, Map<Integer, Integer> areaMap, int[][] grid) {
        Set<Integer> seen = new HashSet<>();
        for (int[] n : validNeighbours(r, c, grid)) {
            int newR = n[0];
            int newC = n[1];
            if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length &&
                grid[newR][newC] > 1) {
                seen.add(grid[newR][newC]);
            }
        }
        int area = 1;
        for (int index : seen) {
            area += areaMap.get(index);
        }
        return area;
    }

    private int dfs(int r, int c, int[][] grid, int islandIndex) {
        if (grid[r][c] > 1) {
            return 0;
        }
        grid[r][c] = islandIndex;
        int count = 1;
        for (int[] n : validNeighbours(r, c, grid)) {
            int newR = n[0];
            int newC = n[1];
            if (grid[newR][newC] == 1) {
                count += dfs(newR, newC, grid, islandIndex);
            }
        }
        return count;

    }

    private List<int[]> validNeighbours(int r, int c, int[][] grid) {
        List<int[]> neighbours = new ArrayList<>();
        for (int[] direction : directions) {
            int newR = r + direction[0];
            int newC = c + direction[1];
            if (newR >= 0 && newC >= 0 && newR < grid.length && newC < grid[0].length) {
                neighbours.add(new int[]{newR, newC});
            }
        }
        return neighbours;
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
