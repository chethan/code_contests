package leetcode;

import java.util.HashMap;

/**
 * Created by Chethan on 8/9/15.
 */
public class TwoSum {

    //https://leetcode.com/problems/two-sum/
    int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference) && (map.get(difference) != i)) {
                result[1] = map.get(difference);
                result[0] = i;
                break;
            }
        }
        return result;
    }

    //https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
    int[] twoSumSorted(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{-1, -1};
        }
        int low = 0, high = nums.length - 1;
        while (low < high) {
            int sum = nums[low] + nums[high];
            if (sum == target) {
                return new int[]{low, high};
            }
            if (sum < target) {
                low++;
            } else {
                high--;
            }
        }
        return new int[]{-1, -1};
    }
}
