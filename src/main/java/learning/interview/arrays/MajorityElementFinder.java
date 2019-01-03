package learning.interview.arrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by Chethan on 9/19/16.
 */
//https://leetcode.com/problems/majority-element/
//http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
class MajorityElementFinder {
    int majorityElement(int[] nums) {
        int count = 0, candidate = 0;
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}
