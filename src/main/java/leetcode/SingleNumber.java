package leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Chethan on 9/19/15.
 */
//https://leetcode.com/problems/single-number/
public class SingleNumber {
    public int singleNumberOne(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        for (int i = 1, numsLength = nums.length; i < numsLength; i++) {
            nums[i] = nums[i] ^ nums[i - 1];
        }
        return nums[nums.length - 1];
    }

    //https://leetcode.com/problems/single-number-ii/
    //http://traceformula.blogspot.com/2015/08/single-number-ii-how-to-come-up-with.html
    public int singleNumberTwo(int[] nums) {
        if (nums.length == 0) return 0;
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bitNumber = 1 << i;
            int numberOfOneBits = 0;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & bitNumber) != 0) numberOfOneBits++;
            }
            if (numberOfOneBits % 3 == 1) result |= bitNumber;
        }
        return result;
    }


    // https://leetcode.com/problems/single-number-iii/
    // http://traceformula.blogspot.com/2015/09/single-number-iii-leetcode.html
    public int[] singleNumberThree(int[] nums) {
        if (nums.length == 0) return new int[]{};
        int aXb = 0, a = 0, b = 0;
        for (int num : nums) {
            aXb ^= num;
        }
        // get any one of the set bit
        aXb = (aXb & (aXb - 1)) ^ aXb;
        for (int num : nums) {
            if ((aXb & num) == 0) {
                a ^= num;
            } else {
                b ^= num;
            }
        }

        return new int[]{a, b};
    }

}
