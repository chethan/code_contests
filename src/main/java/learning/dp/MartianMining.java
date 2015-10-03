package learning.dp;

/**
 * Created by Chethan on 10/2/15.
 */
//http://www.spoj.com/problems/MARTIAN/
public class MartianMining {
    //M[i][j] = max { M[i-1][j]+Horizontal Sum of i,M[i][j-1]+VerticalSum Of j}
    //TODO: generate sum matrix
    public int mineOptimized(int[][] bloggium, int[][] yeyenum) {
        int height = bloggium.length;
        int width = bloggium[0].length;
        int[][] dp = new int[height][width];

        dp[0][0] = Math.max(bloggium[0][0], yeyenum[0][0]);

        for (int i = 1; i < height; i++) {
            dp[i][0] = Math.max(verticalSum(bloggium, 0, i), dp[i - 1][0] + yeyenum[i][0]);
        }
        for (int i = 1; i < width; i++) {
            dp[0][i] = Math.max(horizantalSum(yeyenum, 0, i), dp[0][i - 1] + bloggium[0][i]);
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                dp[i][j] = Math.max(dp[i - 1][j] + horizantalSum(yeyenum, i, j), dp[i][j - 1] + verticalSum(bloggium, j, i));
            }
        }
        return dp[height - 1][width - 1];
    }

    //V[i][j]= max { H[i][j-1],v[i][j-1]}+VerticalSum Of J
    //H[i][j]= max { H[i-1][j],v[i-1][j]}+ Horizontal Sum of I
    public int mine(int[][] bloggium, int[][] yeyenum) {
        int height = bloggium.length;
        int width = bloggium[0].length;
        int[][] vertical = new int[height][width];
        int[][] horizontal = new int[height][width];

        vertical[0][0] = bloggium[0][0];
        horizontal[0][0] = yeyenum[0][0];

        for (int i = 1; i < height; i++) {
            vertical[i][0] = vertical[i - 1][0] + bloggium[i][0];
            horizontal[i][0] = Math.max(horizontal[i - 1][0], vertical[i - 1][0]) + yeyenum[i][0];
        }
        for (int i = 1; i < width; i++) {
            vertical[0][i] = Math.max(horizontal[0][i - 1], vertical[0][i - 1]) + bloggium[0][i];
            horizontal[0][i] = horizontal[0][i - 1] + yeyenum[0][i];
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                vertical[i][j] = Math.max(horizontal[i][j - 1], vertical[i][j - 1]) + verticalSum(bloggium, j, i);
                horizontal[i][j] = Math.max(horizontal[i - 1][j], vertical[i - 1][j]) + horizantalSum(yeyenum, i, j);
            }
        }
        return Math.max(horizontal[height - 1][width - 1], vertical[height - 1][width - 1]);
    }

    public int verticalSum(int[][] values, int column, int tillRow) {
        int sum = 0;
        for (int i = 0; i <= tillRow; i++) {
            sum += values[i][column];
        }
        return sum;
    }

    public int horizantalSum(int[][] values, int row, int tillColumn) {
        int sum = 0;
        for (int i = 0; i <= tillColumn; i++) {
            sum += values[row][i];
        }
        return sum;
    }

}
