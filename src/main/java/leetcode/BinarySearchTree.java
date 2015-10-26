package leetcode;

import ds.TreeNode;

import java.util.Stack;

/**
 * Created by Chethan on 10/24/15.
 */
public class BinarySearchTree {
    //https://leetcode.com/problems/validate-binary-search-tree/
    public boolean isValidBST(TreeNode root) {
        return root == null || isValidBSTRecursive(root, null, null);
    }

    private boolean isValidBSTRecursive(TreeNode root, Integer min, Integer max) {
        if ((min != null && root.val <= min)
                || (max != null && root.val >= max)) return false;
        boolean isLeftBST = root.left == null ||
                root.left.val < root.val && isValidBSTRecursive(root.left, min, root.val);
        boolean isrightBST = root.right == null ||
                root.right.val > root.val && isValidBSTRecursive(root.right, root.val, max);
        return isLeftBST && isrightBST;
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode loopNode = root;
        while (!nodes.isEmpty() || loopNode != null) {
            if (loopNode != null) {
                nodes.push(loopNode);
                loopNode = loopNode.left;
            } else if (!nodes.isEmpty()) {
                TreeNode pop = nodes.pop();
                k--;
                if (k == 0) return pop.val;
                loopNode = pop.right;
            }
        }
        return 0;
    }

}
