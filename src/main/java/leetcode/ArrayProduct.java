package leetcode;

/**
 * Created by Chethan on 9/19/15.
 */
//https://leetcode.com/problems/product-of-array-except-self/
//http://www.programcreek.com/2014/07/leetcode-product-of-array-except-self-java/
public class ArrayProduct {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        int product = 1, nonZeroProduct = 1, zeroCount = 0;
        for (int num : nums) {
            if (num != 0) {
                nonZeroProduct = nonZeroProduct * num;
            } else {
                zeroCount++;
            }
            product = product * num;
        }
        for (int i = 0; i < nums.length; i++) {
            if (zeroCount <= 1) {
                output[i] = nums[i] == 0 ? nonZeroProduct : product / nums[i];
            }
        }
        return output;

    }
}
