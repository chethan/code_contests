package leetcode.tree;

import ds.TreeNode;

/**
 * Created by Chethan on 10/24/15.
 */
public class DepthOfATree {
    //https://leetcode.com/problems/minimum-depth-of-binary-tree/
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        return minRecur(root);
    }

    //https://leetcode.com/problems/maximum-depth-of-binary-tree/
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return maxRecur(root);
    }

    private int minRecur(TreeNode root){
        if(root==null) return Integer.MAX_VALUE;
        if (root.left==null && root.right==null) return 1;
        return 1 + Math.min(minRecur(root.left), minRecur(root.right));
    }

    private int maxRecur(TreeNode root){
        if(root==null) return Integer.MIN_VALUE;
        if (root.left==null && root.right == null) return 1;
        return 1 + Math.max(maxRecur(root.left), maxRecur(root.right));
    }
}
