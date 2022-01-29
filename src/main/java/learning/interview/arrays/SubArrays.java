package learning.interview.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArrays {

    //https://leetcode.com/problems/subarray-sum-equals-k/
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSumMap = new HashMap<>();
        int currentSum = 0, count = 0;
        for (int num : nums) {
            currentSum += num;
            if (currentSum == k) {
                count++;
            }
            count += prefixSumMap.getOrDefault(currentSum - k, 0);
            prefixSumMap.put(currentSum, prefixSumMap.getOrDefault(currentSum, 0) + 1);
        }
        return count;
    }

    //https://leetcode.com/problems/maximum-size-subarray-sum-equals-k/
    public int maxSubArrayLen(int[] nums, int k) {
        int prefixSum = 0, longestArray = 0;
        Map<Integer, Integer> reverseIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            if (prefixSum == k) {
                longestArray = Math.max(longestArray, i + 1);
            }
            if (reverseIndex.containsKey(prefixSum - k)) {
                longestArray = Math.max(longestArray, i - reverseIndex.get(prefixSum - k));
            }
            if (!reverseIndex.containsKey(prefixSum)) {
                reverseIndex.put(prefixSum, i);
            }
        }
        return longestArray;
    }
}
