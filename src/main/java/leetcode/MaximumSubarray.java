package leetcode;

/**
 * Created by Chethan on 10/15/15.
 */
//M[i]=max{M[i-1]+a[i],a[i]}
//https://leetcode.com/problems/maximum-subarray/
public class MaximumSubarray {

    public int maxSum(int[] nums) {
        int[] dp = new int[nums.length + 1];
        int max = Integer.MIN_VALUE;
        dp[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i - 1], nums[i - 1]);
            max = Math.max(dp[i], max);
        }
        return max;
    }

    /*
    //MaxSoFar[i] = maxProduct including ith element
    //MinSoFar[i] = minProduct including ith element
    //MaxSoFar[i+1] = Max{MaxSoFar[i]*nums[i],nums[i],MinSoFar[i]*nums[i]}
    //MinSoFar[i+1] = Min{MaxSoFar[i]*nums[i],nums[i],MinSoFar[i]*nums[i]}
    //Result = Max{all the MaxSoFar[i]}
     */
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int maxLocal, minlocal, globalMax;
        maxLocal = minlocal = globalMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int temp = maxLocal;
            maxLocal = Math.max(Math.max(nums[i] * maxLocal, nums[i]), nums[i] * minlocal);
            minlocal = Math.min(Math.min(nums[i] * temp, nums[i]), nums[i] * minlocal);
            globalMax = Math.max(globalMax, maxLocal);
        }
        return globalMax;
    }

    /**
     * We only need to consider arrays without 0. If an array has 0 in it, then the
     * array should be divided into two parts on either side of 0 because 0 cannot ever
     * be included in the product.
     * Example: 1,2,0,3,4,5. Max should be on either side of 0.
     *
     * Also, the max product array cannot ever be in the middle of an array. It has to
     * be anchored to either ends of the array.
     * Example case 1: -ve, Max Array, -ve
     * In this case we can include both negative numbers and get a larger product
     * Example case 2: +ve, Max Array, +ve
     * This case is trivial as both +ve numbers need to be included in the product
     * Example case 3: -ve, Max Array, +ve or +ve, Max Array, -ve
     * In both the above cases we can extend Max Array to cover the +ve element to get
     * a larger product and thus anchor the array to the right or left end.
     *
     * Now the problem is reduced to calculating the product of numbers from left, and
     * then doing the same from right, and then calculating the max product.
     */
    public int maxProductWithDifferentApproach(int[] nums) {
        int max = Integer.MIN_VALUE, product = 1;
        for (int num : nums) {
            product *= num;
            max = Math.max(product, max);
            if (product == 0) {
                product = 1;
            }
        }
        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            max = Math.max(product, max);
            if (product == 0) {
                product = 1;
            }
        }
        return max;
    }


}
