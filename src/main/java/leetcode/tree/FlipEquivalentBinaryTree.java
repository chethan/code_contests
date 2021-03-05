package leetcode.tree;

import ds.TreeNode;

//https://leetcode.com/problems/flip-equivalent-binary-trees/
public class FlipEquivalentBinaryTree {

    public boolean areEqual(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        return root1.val == root2.val && (
            (areEqual(root1.left, root2.left) && areEqual(root1.right, root2.right)) || (
                areEqual(root1.left, root2.right) && areEqual(root1.right, root2.left)));

    }
}
