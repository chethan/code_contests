package learning.interview.arrays;


import java.util.ArrayList;
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
        if (count1 > (nums.length / 3)) elements.add(candidate1);
        if (count2 > (nums.length / 3)) elements.add(candidate2);

        return elements;
    }
}
