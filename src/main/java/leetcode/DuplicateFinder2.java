package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chethan on 9/19/16.
 */
public class DuplicateFinder2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexMap.containsKey(nums[i])) {
                if (i - indexMap.get(nums[i]) <= k) return true;
            }
            indexMap.put(nums[i], i);
        }
        return false;
    }
}
