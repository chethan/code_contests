package leetcode.array;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class MonotonicStack {

    //https://leetcode.com/problems/daily-temperatures/
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Integer> mStack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int currentTemp = temperatures[i];
            while (!mStack.isEmpty() && currentTemp > temperatures[mStack.peek()]) {
                int previousIndex = mStack.pop();
                result[previousIndex] = i - previousIndex;
            }
            mStack.push(i);
        }
        return result;
    }

    //https://leetcode.com/problems/next-greater-element-i/
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> mStack = new Stack<>();
        Map<Integer, Integer> gMap = new HashMap<>();
        for (int value : nums2) {
            while (!mStack.isEmpty() && value > mStack.peek()) {
                gMap.put(mStack.pop(), value);
            }
            mStack.push(value);
        }
        int[] result = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            result[i] = gMap.getOrDefault(nums1[i], -1);
        }
        return result;
    }

    //https://leetcode.com/problems/next-greater-element-ii/
    public int[] nextGreaterElements(int[] nums) {
        int[] linearNums = new int[nums.length + nums.length - 1];
        System.arraycopy(nums, 0, linearNums, 0, nums.length);
        if (nums.length > 1) {
            System.arraycopy(nums, 0, linearNums, nums.length, nums.length - 1);
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = -1;
        }
        Stack<Integer> mStack = new Stack<>();
        for (int i = 0; i < linearNums.length; i++) {
            while (!mStack.isEmpty() && linearNums[i] > linearNums[mStack.peek()]) {
                int previousIndex = mStack.pop();
                if (previousIndex < nums.length) {
                    result[previousIndex] = linearNums[i];
                }
            }
            mStack.push(i);
        }
        return result;
    }

    //https://leetcode.com/problems/sliding-window-maximum/
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> mQ = new ArrayDeque<>();
        int[] result = new int[nums.length - k + 1];
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            if (!mQ.isEmpty() && mQ.peekFirst() == i - k) {
                mQ.removeFirst();
            }
            while (!mQ.isEmpty() && nums[i] > nums[mQ.peekLast()]) {
                mQ.removeLast();
            }
            mQ.addLast(i);
            if (i >= (k - 1)) {
                result[i - k + 1] = nums[mQ.peekFirst()];
            }
        }
        return result;
    }


}
