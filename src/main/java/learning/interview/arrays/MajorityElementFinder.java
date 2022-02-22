package learning.interview.arrays;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


//http://www.cs.utexas.edu/~moore/best-ideas/mjrty/index.html
class MajorityElementFinder {

    //https://leetcode.com/problems/majority-element/
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

    //https://leetcode.com/problems/majority-element-ii/
    List<Integer> majorityElements(int[] nums) {
        int count1 = 0, count2 = 0;
        Integer candidate1 = null, candidate2 = null;
        List<Integer> elements = new ArrayList<>();
        for (int num : nums) {
            if (candidate1 != null && num == candidate1) {
                count1++;
            } else if (candidate2 != null && num == candidate2) {
                count2++;
            } else if (count1 == 0) {
                candidate1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = num;
                count2 = 1;
            } else {
                count2--;
                count1--;
            }
        }
        count1 = 0;
        count2 = 0;
        for (int num : nums) {
            if (num == candidate1) {
                count1++;
            }
            if (candidate2 != null && num == candidate2) {
                count2++;
            }

        }
        if (count1 > (nums.length / 3)) {
            elements.add(candidate1);
        }
        if (count2 > (nums.length / 3)) {
            elements.add(candidate2);
        }
        return elements;
    }


    //https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
    public boolean isMajorityElement(int[] nums, int target) {
        return Arrays.stream(nums)
            .filter(n -> n == target)
            .count() > nums.length / 2;
    }

    //https://leetcode.com/problems/check-if-a-number-is-majority-element-in-a-sorted-array/
    public boolean isMajorityElementUsingBinarySearch(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        int leftMostIndex = binarySearch(nums, target, true);
        if (leftMostIndex == -1) {
            return false;
        }
        int rightMostIndex = binarySearch(nums, target, false);
        return (rightMostIndex - leftMostIndex) >= nums.length / 2;
    }

    private int binarySearch(int[] nums, int target, boolean left) {
        int lo = 0, hi = nums.length - 1, lastFoundIndex = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                lastFoundIndex = mid;
                if (left) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return lastFoundIndex;
    }
}
