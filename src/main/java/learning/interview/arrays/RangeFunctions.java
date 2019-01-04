package learning.interview.arrays;

import java.util.List;
import java.util.ArrayList;

class RangeFunctions {

    List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        if (nums.length == 0) {
            return ranges;
        }

        int startRange = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1] - 1) {
                continue;
            }
            if (startRange == nums[i]) {
                ranges.add(startRange + "");
            } else {
                ranges.add(startRange + "->" + nums[i]);
            }
            startRange = nums[i + 1];
        }

        if (startRange == nums[nums.length - 1]) {
            ranges.add(startRange + "");
        } else {
            ranges.add(startRange + "->" + nums[nums.length - 1]);
        }

        return ranges;
    }
}
