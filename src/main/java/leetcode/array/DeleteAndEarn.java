package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class DeleteAndEarn {

    //dp[n]= Max(gain+dp[n-2],dp[n-1]) where n is the maxNumber
    // and gain is the credit by deleting number ns
    //Time: O(N+K) N is the length of array,K is the max number
    //Space: O(N+K)
    //We can reduce the space complexity by replacing array with two variables

    public int deleteAndEarn(int[] nums) {
        Map<Integer, Integer> points = new HashMap();
        int maxNumber = 0;
        for (int num : nums) {
            points.put(num, points.getOrDefault(num, 0) + num);
            maxNumber = Math.max(maxNumber, num);
        }
        int[] dp = new int[maxNumber + 1];
        dp[1] = points.getOrDefault(1, 0);
        for (int i = 2; i <= maxNumber; i++) {
            int point = points.getOrDefault(i, 0);
            dp[i] = Math.max(point + dp[i - 2], dp[i - 1]);
        }
        return dp[maxNumber];
    }

}
