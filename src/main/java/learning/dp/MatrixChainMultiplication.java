package learning.dp;

/**
 * Created by Chethan on 10/3/15.
 */
//M[i][j]=Min{M[i][k]+M[k+1][i]+p[i-1]p[k]p[j]}
public class MatrixChainMultiplication {
//http://www.geeksforgeeks.org/dynamic-programming-set-8-matrix-chain-multiplication/
    public int minimumMultiplications(int[] matricies) {
        int n = matricies.length;
        int[][] dp = new int[n][n];
        for (int i = 1; i < n; i++) {
            dp[i][i] = 0;
        }

        for (int l = 2; l < n; l++) {
            for (int i = 1; i < (n - (l - 1)); i++) {
                int j = i + l - 1;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int value = dp[i][k] + dp[k + 1][j] + (matricies[i - 1] * matricies[k] * matricies[j]);
                    if (value < dp[i][j]) {
                        dp[i][j] = value;
                    }
                }
            }
        }
        return dp[1][n - 1];
    }

//http://www.spoj.com/problems/MIXTURES/
    public int minimumSmoke(int[] mixtures) {
        int n = mixtures.length;
        int[][] smoke = new int[n][n];
        int[][] resultantMixture = new int[n][n];
        for (int i = 0; i < n; i++) {
            resultantMixture[i][i] = mixtures[i];
        }

        for (int l = 2; l <= n; l++) {
            for (int i = 0; i < (n - (l - 1)); i++) {
                int j = i + l - 1;
                smoke[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int value = smoke[i][k]+smoke[k+1][j]+(resultantMixture[i][k] * resultantMixture[k + 1][j]);
                    int result = (resultantMixture[i][k] + resultantMixture[k + 1][j]) % 100;
                    if (value < smoke[i][j]) {
                        smoke[i][j] = value;
                        resultantMixture[i][j] = result;
                    }
                }
            }
        }
        return smoke[0][n - 1];

    }
}
