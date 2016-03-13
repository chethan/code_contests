package learning.dp;

/**
 * Created by Chethan on 3/12/16.
 */
//M[n]=MAX{n,SUM(M[n/3]+M[n/2]+M[n/4])}
public class Trading {
    // This one is not good for bottom as the values that are used are very sparse
    public int finalCash(int coinValue) {
        int[] dp = new int[coinValue + 1];
        dp[0] = 0;
        for (int i = 1; i <= coinValue; i++) {
            dp[i] = Math.max(i, dp[i / 2] + dp[i / 3] + dp[i / 4]);
        }
        return dp[coinValue];
    }

    public int finalCashTD(int coinValue) {
        int[] memo = new int[coinValue + 1];
        memo[0] = 0;
        for (int i = 1; i < memo.length; i++) {
            memo[i] = -1;
        }
        return finalCashTDTHelper(coinValue, memo);
    }

    private int finalCashTDTHelper(int coinValue, int[] memo) {
        if (memo[coinValue] != -1) return memo[coinValue];
        int c2 = finalCashTDTHelper(coinValue / 2, memo);
        int c3 = finalCashTDTHelper(coinValue / 3, memo);
        int c4 = finalCashTDTHelper(coinValue / 4, memo);
        memo[coinValue] = Math.max(coinValue, c2 + c3 + c4);
        return memo[coinValue];

    }
}
