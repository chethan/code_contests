package leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Chethan on 9/22/16.
 */
public class DuplicateRemover {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int duplicateCount = 0;
        for (int i = 0, j = 1; j < nums.length; j++) {
            if (nums[j] == nums[i]) {
                duplicateCount++;
            } else {
                if (i + 1 < j) {
                    int temp = nums[i + 1];
                    nums[i + 1] = nums[j];
                    nums[j] = temp;
                }
                i++;
            }
        }
        return nums.length - duplicateCount;
    }

    //https://leetcode.com/problems/remove-all-adjacent-duplicates-in-string/
    public String removeDuplicates(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty() || stack.peekLast() != s.charAt(i)) {
                stack.offerLast(s.charAt(i));
            } else {
                stack.pollLast();

            }
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pollFirst());
        }
        return result.toString();
    }
}
