package leetcode.array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {

    //https://leetcode.com/problems/missing-ranges/
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int startLimit = lower - 1;
        List<String> missingRanges = new ArrayList<>();
        for (int i = 0; i <= nums.length; i++) {
            int currentValue = i == nums.length ? upper + 1 : nums[i];
            int diff = currentValue - startLimit;
            if (diff > 1) {
                int low = startLimit + 1;
                int high = currentValue - 1;
                missingRanges.add(low == high ? low + "" : low + "->" + high);
            }
            startLimit = currentValue;
        }
        return missingRanges;
    }
}
