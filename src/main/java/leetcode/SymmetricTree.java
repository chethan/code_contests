package leetcode;

import ds.TreeNode;

/**
 * Created by Chethan on 10/24/15.
 */
//https://leetcode.com/problems/symmetric-tree/
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    private boolean isSymmetric(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        return (tree1.val == tree2.val &&
                isSymmetric(tree1.left, tree2.right) &&
                isSymmetric(tree1.right, tree2.left));
    }

}
