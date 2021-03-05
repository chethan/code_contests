package learning.dp;

//https://www.geeksforgeeks.org/cutting-a-rod-dp-13/
//D[j] = max(price[i]+D[j-i-]) for all i in (0 to j-1)
public class RodCutter {

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        if (prices.length == 1) {
            return prices[0];
        }

        int[] dp = new int[prices.length + 1];
        dp[1] = prices[0];
        for (int i = 2; i <= prices.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + prices[j - 1]);
            }
        }
        return dp[prices.length];
    }
}
