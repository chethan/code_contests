package leetcode;

import ds.TreeNode;

/**
 * Created by Chethan on 10/24/15.
 */
public class InvertBinaryTree {

    //https://leetcode.com/problems/invert-binary-tree/
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            invertTree(root.left);
            invertTree(root.right);
            TreeNode tempRight = root.right;
            root.right = root.left;
            root.left = tempRight;
        }
        return root;
    }

}
