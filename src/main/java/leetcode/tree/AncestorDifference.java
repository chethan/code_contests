package leetcode.tree;

import ds.TreeNode;

//https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
public class AncestorDifference {

    //bottom up approach (pre order traversal)
    public int maxAncestorDiff(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helper(root).maxDiff;
    }

    //top down (post order traversal)
    public int maxAncestorDiffPostOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return helperPostOrder(root, root.val, root.val);
    }

    private int helperPostOrder(TreeNode root, int currentMax, int currentMin) {
        if (root == null) {
            return currentMax - currentMin;
        }
        currentMax = Math.max(currentMax, root.val);
        currentMin = Math.min(currentMin, root.val);
        int left = helperPostOrder(root.left, currentMax, currentMin);
        int right = helperPostOrder(root.right, currentMax, currentMin);
        return Math.max(left, right);
    }

    private TreeMeta helper(TreeNode node) {
        if (node == null) {
            return new TreeMeta(Integer.MAX_VALUE, 0, -1);
        }
        TreeMeta left = helper(node.left);
        TreeMeta right = helper(node.right);
        int minChildValue = Math.min(left.minValue, right.minValue);
        int maxChildValue = Math.max(left.maxValue, right.maxValue);
        int maxDiff = Math.max(
            Math.max(Math.max(left.maxDiff, right.maxDiff), node.val - minChildValue),
            maxChildValue - node.val);
        int minValue = Math.min(minChildValue, node.val);
        int maxValue = Math.max(maxChildValue, node.val);
        return new TreeMeta(minValue, maxDiff, maxValue);
    }

    private static class TreeMeta {

        int minValue;
        int maxDiff;
        int maxValue;

        TreeMeta(int minValue, int maxDiff, int maxValue) {
            this.minValue = minValue;
            this.maxDiff = maxDiff;
            this.maxValue = maxValue;
        }
    }
}
