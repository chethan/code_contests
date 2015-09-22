package leetcode;

/**
 * Created by Chethan on 9/22/15.
 */
//https://leetcode.com/problems/unique-paths/
//M[i,j]=SUM{M[i-1,j],M[i,j-1]}
public class UniquePaths {
    public int uniquePaths(int m, int n) {
        int[][] paths = new int[m][n];
        paths[0][0] = 1;
        for (int i = 1; i < m; i++) {
            paths[i][0] = 1;
        }
        for (int i = 1; i < n; i++) {
            paths[0][i] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
            }
        }
        return paths[m - 1][n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;
        int[][] paths = new int[height][width];
        paths[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
        for (int i = 1; i < height; i++) {
            paths[i][0] = obstacleGrid[i][0] == 1 ? 0 : paths[i - 1][0];
        }
        for (int i = 1; i < width; i++) {
            paths[0][i] = obstacleGrid[0][i] == 1 ? 0 : paths[0][i - 1];
        }

        for (int i = 1; i < height; i++) {
            for (int j = 1; j < width; j++) {
                if (obstacleGrid[i][j] != 1) {
                    paths[i][j] = paths[i - 1][j] + paths[i][j - 1];
                }
            }
        }
        return paths[height - 1][width - 1];
    }

}
