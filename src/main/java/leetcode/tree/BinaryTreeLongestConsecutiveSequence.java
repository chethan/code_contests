package leetcode.tree;

import ds.TreeNode;

//https://leetcode.com/problems/binary-tree-longest-consecutive-sequence/
public class BinaryTreeLongestConsecutiveSequence {

    private int maxLength = 0;

    public int longestConsecutive(TreeNode root) {
        maxLength = 0;
        if (root == null) {
            return 0;
        }
        dfs(root, 1);
        return maxLength;
    }

    private void dfs(TreeNode node, Integer chainLength) {
        if (node == null) {
            return;
        }
        if (chainLength > maxLength) {
            maxLength = chainLength;
        }

        if (node.left != null) {
            if ((node.val - node.left.val) != -1) {
                dfs(node.left, 1);
            } else {
                dfs(node.left, chainLength + 1);
            }
        }

        if (node.right != null) {
            if ((node.val - node.right.val) != -1) {
                dfs(node.right, 1);
            } else {
                dfs(node.right, chainLength + 1);
            }
        }
    }
}
