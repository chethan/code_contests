package leetcode.tree;

import ds.TreeNode;
import java.util.Stack;

/**
 * Created by Chethan on 10/25/15.
 */
//https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
public class BinaryTreeFlattening {

    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode loopNode = root;
        Stack<TreeNode> nodes = new Stack<>();
        while (loopNode != null || !nodes.isEmpty()) {
            if (loopNode.right != null) {
                nodes.push(loopNode.right);
            }
            if (loopNode.left != null) {
                loopNode.right = loopNode.left;
                loopNode.left = null;
            } else if (!nodes.isEmpty()) {
                TreeNode pop = nodes.pop();
                loopNode.right = pop;
            }
            loopNode = loopNode.right;
        }
    }

    public void flattenRecur(TreeNode root) {
        flattenTreeRecur(root);
    }

    private TreeNode flattenTreeRecur(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode leftTail = flattenTreeRecur(root.left);
        TreeNode rightTail = flattenTreeRecur(root.right);
        if (leftTail != null) {
            leftTail.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        return rightTail != null ? rightTail : leftTail;
    }
}
