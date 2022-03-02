package leetcode.dp;

import java.util.Arrays;
import java.util.Comparator;

public class Taxi {

    public long maxTaxiEarnings(int n, int[][] rides) {
        Arrays.sort(rides, Comparator.comparingInt(a -> a[0]));
        long[] cache = new long[rides.length + 1];
        Arrays.fill(cache, -1);
        return helper(rides, 0, cache);
    }

    long helper(int[][] rides, int index, long[] cache) {
        if (index >= rides.length) {
            return 0;
        }
        if (cache[index] != -1) {
            return cache[index];
        }
        int i = firstRiderAfterCurrent(rides, index);
        long maxIncludingCurrent = (rides[index][1] - rides[index][0] + rides[index][2])
            + helper(rides, i, cache);
        long maxExcludingCurrent = helper(rides, index + 1, cache);
        return cache[index] = Math.max(maxExcludingCurrent, maxIncludingCurrent);
    }

    private int firstRiderAfterCurrent(int[][] rides, int index) {
        int lo = index, hi = rides.length - 1;
        int toFind = rides[index][1], result = rides.length;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (rides[mid][0] >= toFind) {
                hi = mid - 1;
                result = mid;
            } else {
                lo = mid + 1;
            }
        }
        return result;
    }
}
