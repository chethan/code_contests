package leetcode.array;

public class ArithmeticSlices {

    //https://leetcode.com/problems/arithmetic-slices/
    //Time O(N)
    //Space O(N)
    public int numberOfArithmeticSlicesTopDown(int[] nums) {
        return slice(nums, nums.length - 1).sum;
    }

    //Time O(N)
    //Space O(1)
    public int numberOfArithmeticSlicesDP(int[] nums) {
        int count = 0, sum = 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] - nums[i - 1] == nums[i - 1] - nums[i - 2]) {
                count = 1 + count;
                sum += count;
            } else {
                count = 0;
            }
        }
        return sum;
    }

    //Time O(N^2)
    //Space O(N)
    public int numberOfArithmeticSlicesBruteForce(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 2; j < nums.length; j++) {
                if (isArithmetic(nums, i, j)) {
                    count++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    private static class Pair {

        int count;
        int sum;

        Pair(int count, int sum) {
            this.count = count;
            this.sum = sum;
        }
    }

    Pair slice(int[] nums, int index) {
        if (index < 2) {
            return new Pair(0, 0);
        }
        Pair pair = slice(nums, index - 1);
        if (nums[index] - nums[index - 1] == nums[index - 1] - nums[index - 2]) {
            int count = 1 + pair.count;
            return new Pair(count, count + pair.sum);
        } else {
            return new Pair(0, pair.sum);
        }
    }

    boolean isArithmetic(int[] nums, int i, int j) {
        int diff = nums[i] - nums[i + 1];
        for (int k = i; k < j; k++) {
            if (nums[k] - nums[k + 1] != diff) {
                return false;
            }
        }
        return true;
    }
}
