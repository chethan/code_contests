package leetcode.array;

public class CitySkyline {


    //https://leetcode.com/problems/max-increase-to-keep-city-skyline/
    public int maxIncreaseKeepingSkyline(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length, col = grid[0].length;
        //Decides the skyline for east and west
        int[] maxRows = new int[row];
        //Decides the skyline for north  and south
        int[] maxCols = new int[col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxRows[i] = Math.max(maxRows[i], grid[i][j]);
                maxCols[j] = Math.max(maxCols[j], grid[i][j]);
            }
        }
        int maxHeight = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                maxHeight += Math.min(maxRows[i], maxCols[j]) - grid[i][j];
            }
        }
        return maxHeight;
    }
}
