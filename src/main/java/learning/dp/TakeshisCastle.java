package learning.dp;

/**
 * Created by Chethan on 10/4/15.
 */
//M[i]=Max{M[j]*p[i]} for all j within jumping distance
//https://www.hackerearth.com/problem/algorithm/takeshis-castle-4/
public class TakeshisCastle {
    public double bestProbability(int jumpSpan, int totalDistance, double[] stones, int[] distances) {
        double[] dp = new double[stones.length + 2];
        dp[0] = 1;
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                int distance = ((i > distances.length) ? totalDistance : distances[i-1]) - ((j != 0) ? distances[j-1] : 0);
                if (distance <= jumpSpan) {
                    double value = dp[j] * ((i > stones.length) ? 1 : stones[i-1]);
                    if (value > dp[i]) {
                        dp[i] = value;
                    }
                }
            }
        }
        return dp[dp.length - 1];
    }
}
