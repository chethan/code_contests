package leetcode.tree;

import ds.TreeNode;

//https://leetcode.com/problems/maximum-sum-bst-in-binary-tree/
//Time: O(N)
//Space: O(N)
public class MaximumSumBST {

    public int maxSumBST(TreeNode root) {
        return Math.max(0, helper(root).maxSum);
    }

    TreeMeta helper(TreeNode root) {
        if (root == null) {
            return new TreeMeta(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
        }
        TreeMeta left = helper(root.left);
        TreeMeta right = helper(root.right);
        if (left.isBst && right.isBst && root.val > left.maxValue && root.val < right.minValue) {
            int sum = left.sum + right.sum + root.val;
            return new TreeMeta(true, sum,
                Math.min(root.val, left.minValue),
                Math.max(root.val, right.maxValue),
                Math.max(sum, Math.max(left.maxSum, right.maxSum)));
        }
        return new TreeMeta(false, Math.max(left.sum, right.sum), null, null,
            Math.max(left.maxSum, right.maxSum));
    }


    static class TreeMeta {

        int sum;
        int maxSum;
        boolean isBst;
        Integer minValue;
        Integer maxValue;

        TreeMeta(boolean isBst, int count, Integer minValue, Integer maxValue, Integer maxSum) {
            this.isBst = isBst;
            this.sum = count;
            this.minValue = minValue;
            this.maxValue = maxValue;
            this.maxSum = maxSum;
        }
    }
}
