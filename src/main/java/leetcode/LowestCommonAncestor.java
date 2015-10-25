package leetcode;

import ds.TreeNode;

import java.util.Stack;

/**
 * Created by Chethan on 10/24/15.
 */
public class LowestCommonAncestor {
    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root.val > p.val && root.val > q.val) return lowestCommonAncestorBST(root.left, p, q);
        if (root.val < p.val && root.val < q.val) return lowestCommonAncestorBST(root.right, p, q);
        return root;
    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        if (root == p || root == q) return root;
        TreeNode lcaInLeftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode lcaInRightTree = lowestCommonAncestor(root.right, p, q);
        if (lcaInLeftTree != null && lcaInRightTree != null) return root;
        return lcaInLeftTree != null ? lcaInLeftTree : lcaInRightTree;
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> pStack = new Stack<>();
        Stack<TreeNode> qStack = new Stack<>();
        TreeNode target = null;
        if (findPath(root, p, pStack) && findPath(root, q, qStack)) {
            while (!pStack.isEmpty() && !qStack.isEmpty()) {
                TreeNode pt = pStack.pop();
                TreeNode qt = qStack.pop();
                if (pt == qt) {
                    target = pt;
                }
            }
        }
        return target;
    }

    private boolean findPath(TreeNode root, TreeNode node, Stack<TreeNode> stack) {
        if (root == null) return false;
        if (root.val == node.val) {
            stack.push(root);
            return true;
        }
        if (findPath(root.left, node, stack) || findPath(root.right, node, stack)) {
            stack.push(root);
            return true;
        }
        return false;
    }


}
