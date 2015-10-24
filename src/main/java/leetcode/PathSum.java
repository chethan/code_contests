package leetcode;

import ds.TreeNode;

/**
 * Created by Chethan on 10/24/15.
 */
public class PathSum {
    //https://leetcode.com/problems/path-sum/
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

}
