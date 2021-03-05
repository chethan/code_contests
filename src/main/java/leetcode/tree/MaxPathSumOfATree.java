package leetcode.tree;

import ds.TreeNode;

//https://leetcode.com/problems/binary-tree-maximum-path-sum/
public class MaxPathSumOfATree {

    public int sum(TreeNode root) {
        return maxPathSum(root).pathSum;
    }

    private TreeMetadata maxPathSum(TreeNode node) {
        if (node == null) {
            return new TreeMetadata(Integer.MIN_VALUE, 0);
        }
        TreeMetadata left = maxPathSum(node.left);
        TreeMetadata right = maxPathSum(node.right);
        int currentSum = node.val + Math.max(left.sum, right.sum);
        int currentPathSum = node.val + right.sum + left.sum;
        int maxPathSum = Math.max(currentPathSum,
            Math.max(left.pathSum, right.pathSum));
        return new TreeMetadata(maxPathSum, Math.max(currentSum, 0));
    }

    static class TreeMetadata {

        int pathSum;
        int sum;

        TreeMetadata(int pathSum, int sum) {
            this.pathSum = pathSum;
            this.sum = sum;
        }
    }
}
