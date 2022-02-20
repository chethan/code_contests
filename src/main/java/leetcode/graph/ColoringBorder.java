package leetcode.graph;

public class ColoringBorder {

    private int[][] directions = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    //https://leetcode.com/problems/coloring-a-border/
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        int currentColor = grid[row][col];
        int[][] newGrid = new int[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            System.arraycopy(grid[i], 0, newGrid[i], 0, grid[0].length);
        }
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        dfs(grid, row, col, color, currentColor, visited, newGrid);
        return newGrid;
    }

    private void dfs(int[][] grid, int row, int col, int color, int currentColor,
        boolean[][] visited, int[][] newGrid) {
        if (visited[row][col]) {
            return;
        }
        visited[row][col] = true;
        for (int[] direction : directions) {
            int newX = row + direction[0];
            int newY = col + direction[1];
            if (newX < 0 || newY < 0 || newX >= grid.length || newY >= grid[0].length
                || grid[newX][newY] != currentColor) {
                newGrid[row][col] = color;
            } else {
                dfs(grid, newX, newY, color, currentColor, visited, newGrid);
            }
        }
    }
}
