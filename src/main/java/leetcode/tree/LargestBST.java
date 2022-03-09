package leetcode.tree;

import ds.TreeNode;

//https://leetcode.com/problems/largest-bst-subtree/
//Time: O(N)
//Space: O(N)
public class LargestBST {

    public int largestBSTSubtree(TreeNode root) {
        return helper(root).count;
    }

    TreeMeta helper(TreeNode root) {
        if (root == null) {
            return new TreeMeta(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }
        TreeMeta left = helper(root.left);
        TreeMeta right = helper(root.right);
        if (left.isBst && right.isBst && root.val > left.maxValue && root.val < right.minValue) {
            return new TreeMeta(true, left.count + right.count + 1,
                Math.min(root.val, left.minValue),
                Math.max(root.val, right.maxValue));
        }
        return new TreeMeta(false, Math.max(left.count, right.count), null, null);

    }


    static class TreeMeta {

        int count;
        boolean isBst;
        Integer minValue;
        Integer maxValue;

        TreeMeta(boolean isBst, int count, Integer minValue, Integer maxValue) {
            this.isBst = isBst;
            this.count = count;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        @Override
        public String toString() {
            return count + ":" + isBst + ":" + minValue + ":" + maxValue;
        }
    }
}
