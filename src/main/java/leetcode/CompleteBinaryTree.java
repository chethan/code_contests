package leetcode;

import ds.TreeNode;

/**
 * Created by Chethan on 10/25/15.
 */
//https://leetcode.com/problems/count-complete-tree-nodes/
public class CompleteBinaryTree {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int lh = getLeftHeight(root, true);
        int rh = getLeftHeight(root, false);
        if (lh == rh) {
            return (2 << lh - 1) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    private int getLeftHeight(TreeNode root, boolean left) {
        if (root == null) return 0;
        int height = 1;
        TreeNode loopNode = root;
        while (getTreeNode(left, loopNode) != null) {
            height++;
            loopNode = getTreeNode(left, loopNode);
        }
        return height;
    }

    private TreeNode getTreeNode(boolean left, TreeNode loopNode) {
        return left ? loopNode.left : loopNode.right;
    }
}
