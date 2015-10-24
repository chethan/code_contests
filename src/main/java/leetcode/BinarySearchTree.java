package leetcode;

import ds.TreeNode;

/**
 * Created by Chethan on 10/24/15.
 */
public class BinarySearchTree {
    //https://leetcode.com/problems/validate-binary-search-tree/
    public boolean isValidBST(TreeNode root) {
        return root == null || isValidBSTRecursive(root, null, null);
    }

    public boolean isValidBSTRecursive(TreeNode root, Integer min, Integer max) {
        if ((min != null && root.val <= min)
                || (max != null && root.val >= max)) return false;
        boolean isLeftBST = root.left == null ||
                root.left.val < root.val && isValidBSTRecursive(root.left, min, root.val);
        boolean isrightBST = root.right == null ||
                root.right.val > root.val && isValidBSTRecursive(root.right, root.val, max);
        return isLeftBST && isrightBST;
    }
}
