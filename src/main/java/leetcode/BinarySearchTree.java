package leetcode;

import ds.TreeNode;

import java.util.Arrays;
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

    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        int length = nums.length;
        int i = length / 2;
        TreeNode node = new TreeNode(nums[i]);
        if (length > 1) {
            if (i > 0) node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, i));
            if (i < length - 1) node.right = sortedArrayToBST(Arrays.copyOfRange(nums, i + 1, length));
        }
        return node;
    }

    //https://leetcode.com/problems/closest-binary-search-tree-value/
    public int closestValue(TreeNode root, double target) {
        int returnValue = Integer.MAX_VALUE;
        TreeNode loopnode = root;
        while (loopnode != null) {
            if (Math.abs(target - loopnode.val) < Math.abs(target - returnValue)) {
                returnValue = loopnode.val;
            }
            loopnode = target > loopnode.val ? loopnode.right : loopnode.left;
        }
        return returnValue;
    }

    //https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) return true;
        return verifyPreorderRecursive(preorder, 0, preorder.length - 1);
    }

    private boolean verifyPreorderRecursive(int[] preorder, int low, int high) {
        if (low >= high) return true;
        int root = preorder[low],leftTree = low + 1;
        while (leftTree <= high && preorder[leftTree] < root) leftTree++;
        int rightTree = leftTree;
        while (rightTree <= high && preorder[leftTree] > root) rightTree++;
        if (rightTree <= high) return false;
        return verifyPreorderRecursive(preorder, low + 1, leftTree - 1) &&
                verifyPreorderRecursive(preorder, leftTree, high);
    }


}
