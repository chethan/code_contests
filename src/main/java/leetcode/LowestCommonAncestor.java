package leetcode;

import ds.TreeNode;

/**
 * Created by Chethan on 10/24/15.
 */
public class LowestCommonAncestor {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null || p==null || q==null) return null;
        if(root.val > p.val && root.val > q.val) return lowestCommonAncestorBST(root.left,p,q);
        if(root.val < p.val && root.val < q.val) return lowestCommonAncestorBST(root.right,p,q);
        return root;
    }
}
