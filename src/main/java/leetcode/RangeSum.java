package leetcode;

public class RangeSum {

    //https://leetcode.com/problems/range-sum-query-2d-immutable/
    static class RangeSum2D {

        private final int[][] dp;

        public RangeSum2D(int[][] matrix) {
            if (matrix.length == 0 || matrix[0].length == 0) {
                throw new IllegalArgumentException();
            }
            dp = new int[matrix.length + 1][matrix[0].length + 1];
            for (int r = 0; r < matrix.length; r++) {
                for (int c = 0; c < matrix.length; c++) {
                    dp[r + 1][c + 1] = dp[r][c + 1] + dp[r + 1][c] + matrix[r][c] - dp[r][c];
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1]
                + dp[row1][col1];
        }
    }

    //https://leetcode.com/problems/range-sum-query-mutable/
    static class RangeSumArray {

        private final int[] dp;

        public RangeSumArray(int[] nums) {
            dp = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                dp[i + 1] = dp[i] + nums[i];
            }
        }

        public int sumRange(int left, int right) {
            if (left == 0) {
                return dp[right + 1];
            }
            return dp[right + 1] - dp[left];
        }
    }
}
