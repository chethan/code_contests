package leetcode;

/**
 * Created by Chethan on 9/20/16.
 */
//https://leetcode.com/problems/rotate-function/
public class RotateFunction {
    public int maxRotateFunction(int[] A) {
        if (A.length == 0) return 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = 0; j < A.length; j++) {
                sum += ((i + j) % A.length) * A[j];
            }
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}
