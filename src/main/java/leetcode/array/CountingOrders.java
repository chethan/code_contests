package leetcode.array;

public class CountingOrders {

    int mod = 1_000_000_007;

    //Time: O(N)
    //Space: O(1)
    //Permutation method
    public int countOrders(int n) {
        long ans = 1;
        for (int i = 1; i <= n; i++) {
            // Ways to arrange all pickups, 1*2*3*4*5*...*n
            ans = ans * i;
            // Ways to arrange all deliveries, 1*3*5*...*(2n-1)
            ans = ans * (2L * i - 1);
            ans %= mod;
        }
        return (int) ans;
    }
    // If we want to pick one order then,
    //waysToPick = unpicked * totalWays(unpicked - 1, undelivered)

    // If we want to deliver one order then,
    //waysToDeliver = (undelivered - unpicked) * totalWays(unpicked, undelivered
    public int countOrdersUsingTopUpDP(int n) {
        return (int) totalWays(n, n, new long[n + 1][n + 1]);
    }

    private long totalWays(int unpicked, int undelivered, long[][] cache) {
        if (unpicked == 0 && undelivered == 0) {
            return 1L;
        }
        if (unpicked < 0 || undelivered < 0 || undelivered < unpicked) {
            // We can't pick or deliver more than N items
            // Number of deliveries can't exceed number of pickups
            // as we can only deliver after a pickup.
            return 0L;
        }
        if (cache[unpicked][undelivered] != 0) {
            // Return cached value, if already present.
            return cache[unpicked][undelivered];
        }
        long ans = 0;
        ans += (unpicked * totalWays(unpicked - 1, undelivered, cache));
        ans %= mod;
        ans += ((undelivered - unpicked) * totalWays(unpicked, undelivered - 1, cache));
        ans %= mod;
        cache[unpicked][undelivered] = ans;
        return ans;
    }
}
