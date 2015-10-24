package leetcode;

import ds.TreeNode;

/**
 * Created by Chethan on 10/24/15.
 */

public class TreeComparator {
    //https://leetcode.com/problems/symmetric-tree/
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetric(root.left, root.right);
    }

    //https://leetcode.com/problems/same-tree/
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        return (p.val == q.val &&
                isSameTree(p.left, q.left) &&
                isSameTree(p.right, q.right));

    }

    private boolean isSymmetric(TreeNode tree1, TreeNode tree2) {
        if (tree1 == null && tree2 == null) return true;
        if (tree1 == null || tree2 == null) return false;
        return (tree1.val == tree2.val &&
                isSymmetric(tree1.left, tree2.right) &&
                isSymmetric(tree1.right, tree2.left));
    }

}
