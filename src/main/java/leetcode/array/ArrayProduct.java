package leetcode.array;

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

    public int[] productExceptSelfWithoutDivision(int[] nums) {
        if (nums.length == 0) {
            return new int[]{};
        }
        int[] leftProduct = new int[nums.length];
        leftProduct[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }

        int[] rightProduct = new int[nums.length];
        rightProduct[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }

        int[] output = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            output[i] = rightProduct[i] * leftProduct[i];
        }

        return output;
    }
}
