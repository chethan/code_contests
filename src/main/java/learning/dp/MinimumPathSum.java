package learning.dp;

/**
 * Created by Chethan on 9/21/15.
 */
//https://leetcode.com/problems/minimum-path-sum/
//M[m,n]=min{M[m-1][n],M[n-1][m]}+A[m][n]
public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int width = grid[0].length;
        int[][] minPathSum = new int[height][width];
        minPathSum[0][0] = grid[0][0];
        for (int i = 1; i < height; i++) {
            minPathSum[i][0] = grid[i][0] + minPathSum[i - 1][0];
        }
        for (int j = 1; j < width; j++) {
            minPathSum[0][j] = grid[0][j] + minPathSum[0][j - 1];
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                minPathSum[i][j] = Math.min(minPathSum[i - 1][j], minPathSum[i][j - 1]) + grid[i][j];
            }
        }
        return minPathSum[height - 1][width - 1];
    }
}
