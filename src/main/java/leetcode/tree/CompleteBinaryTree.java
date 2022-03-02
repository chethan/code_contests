package leetcode.tree;

import ds.TreeNode;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Chethan on 10/25/15.
 */
//https://leetcode.com/problems/count-complete-tree-nodes/
public class CompleteBinaryTree {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = getLeftHeight(root, true);
        int rh = getLeftHeight(root, false);
        if (lh == rh) {
            return (2 << lh - 1) - 1;
        } else {
            return 1 + countNodes(root.left) + countNodes(root.right);
        }

    }

    //https://leetcode.com/problems/check-completeness-of-a-binary-tree/
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean end = false;
        //No nodes should be present after seeing first null node
        while (!queue.isEmpty()) {
            TreeNode loopNode = queue.poll();
            if (loopNode == null) {
                end = true;
            } else {
                if (end) {
                    return false;
                }
                queue.offer(loopNode.left);
                queue.offer(loopNode.right);
            }
        }
        return true;
    }

    private int getLeftHeight(TreeNode root, boolean left) {
        if (root == null) {
            return 0;
        }
        int height = 1;
        TreeNode loopNode = root;
        while (getTreeNode(left, loopNode) != null) {
            height++;
            loopNode = getTreeNode(left, loopNode);
        }
        return height;
    }

    private TreeNode getTreeNode(boolean left, TreeNode loopNode) {
        return left ? loopNode.left : loopNode.right;
    }
}
