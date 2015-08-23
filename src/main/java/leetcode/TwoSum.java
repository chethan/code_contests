package leetcode;

import java.util.HashMap;

/**
 * Created by Chethan on 8/9/15.
 */
//https://leetcode.com/problems/two-sum/
public class TwoSum {

    int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int difference = target - nums[i];
            if (map.containsKey(difference) && (map.get(difference)!=i)) {
                result[1] = map.get(difference)+1;
                result[0] = i + 1;
                break;
            }
        }
        return result;
    }
}
