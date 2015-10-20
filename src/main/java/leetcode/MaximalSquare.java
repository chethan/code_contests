package leetcode;

/**
 * Created by Chethan on 10/19/15.
 */
//https://leetcode.com/problems/maximal-square/
public class MaximalSquare {
    public int findMaximalSquare(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int height = matrix.length, width = matrix[0].length, max = 0;

        int[][] dp = new int[height][width];
        for (int i = 0; i < height; i++) {
            dp[i][0] = matrix[i][0] == '1' ? 1 : 0;
            max = Math.max(dp[i][0], max);
        }
        for (int i = 0; i < width; i++) {
            dp[0][i] = matrix[0][i] == '1' ? 1 : 0;
            max = Math.max(dp[0][i], max);
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    max = Math.max(dp[i][j], max);
                }
            }
        }
        return max * max;
    }
}
