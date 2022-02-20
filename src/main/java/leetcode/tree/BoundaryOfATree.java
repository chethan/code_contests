package leetcode.tree;

import ds.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class BoundaryOfATree {

    //https://leetcode.com/problems/boundary-of-binary-tree/
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        addRoot(root, result);
        addLeftBoundary(root.left, result);
        addLeaves(root, result);
        addRightBoundary(root.right, result);
        return result;
    }

    private void addRoot(TreeNode root, List<Integer> result) {
        if (!isLeaf(root)) {
            result.add(root.val);
        }
    }


    private void addLeftBoundary(TreeNode loopNode, List<Integer> result) {
        while (loopNode != null) {
            if (!isLeaf(loopNode)) {
                result.add(loopNode.val);
            }
            if (loopNode.left != null) {
                loopNode = loopNode.left;
            } else {
                loopNode = loopNode.right;
            }
        }
    }

    private void addRightBoundary(TreeNode loopNode, List<Integer> result) {
        List<Integer> rightBoundary = new ArrayList<>();
        while (loopNode != null) {
            if (!isLeaf(loopNode)) {
                rightBoundary.add(loopNode.val);
            }
            if (loopNode.right != null) {
                loopNode = loopNode.right;
            } else {
                loopNode = loopNode.left;
            }
        }
        for (int i = rightBoundary.size() - 1; i >= 0; i--) {
            result.add(rightBoundary.get(i));
        }
    }

    private void addLeaves(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }
        addLeaves(node.left, result);
        addLeaves(node.right, result);

    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
