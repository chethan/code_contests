package leetcode.tree;

import ds.TreeNode;
import java.util.Arrays;
import java.util.Stack;
import leetcode.Pair;

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
            || (max != null && root.val >= max)) {
            return false;
        }
        boolean isLeftBST = root.left == null ||
            root.left.val < root.val && isValidBSTRecursive(root.left, min, root.val);
        boolean isRightBST = root.right == null ||
            root.right.val > root.val && isValidBSTRecursive(root.right, root.val, max);
        return isLeftBST && isRightBST;
    }

    //https://leetcode.com/problems/kth-smallest-element-in-a-bst/
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode loopNode = root;
        while (!nodes.isEmpty() || loopNode != null) {
            if (loopNode != null) {
                nodes.push(loopNode);
                loopNode = loopNode.left;
            } else {
                TreeNode pop = nodes.pop();
                k--;
                if (k == 0) {
                    return pop.val;
                }
                loopNode = pop.right;
            }
        }
        return 0;
    }

    //https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int length = nums.length;
        int i = length / 2;
        TreeNode node = new TreeNode(nums[i]);
        if (length > 1) {
            if (i > 0) {
                node.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, i));
            }
            if (i < length - 1) {
                node.right = sortedArrayToBST(Arrays.copyOfRange(nums, i + 1, length));
            }
        }
        return node;
    }

    //https://leetcode.com/problems/closest-binary-search-tree-value/
    public int closestValue(TreeNode root, double target) {
        int returnValue = Integer.MAX_VALUE;
        TreeNode loopNode = root;
        while (loopNode != null) {
            if (Math.abs(target - loopNode.val) < Math.abs(target - returnValue)) {
                returnValue = loopNode.val;
            }
            loopNode = target > loopNode.val ? loopNode.right : loopNode.left;
        }
        return returnValue;
    }

    //https://leetcode.com/problems/verify-preorder-sequence-in-binary-search-tree/
    public boolean verifyPreorder(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        return verifyPreorderRecursive(preorder, 0, preorder.length - 1);
    }

    //https://leetcode.com/problems/convert-binary-search-tree-to-sorted-doubly-linked-list/
    public TreeNode treeToDoublyList(TreeNode root) {
        if (root == null) {
            return null;
        }
        Pair<TreeNode, TreeNode> pair = toDoublyList(root, new Pair<>(null, null));
        pair.getLast().right = pair.getFirst();
        pair.getFirst().left = pair.getLast();
        return pair.getFirst();
    }

    private Pair<TreeNode, TreeNode> toDoublyList(TreeNode node, Pair<TreeNode, TreeNode> data) {
        if (node == null) {
            return data;
        }
        TreeNode last = data.getLast();
        TreeNode first = data.getFirst();
        if (last != null) {
            last.right = node;
            node.left = last;
        } else {
            first = node;
        }
        last = node;
        return toDoublyList(node.right, new Pair<>(first, last));
    }

    private boolean verifyPreorderRecursive(int[] preorder, int low, int high) {
        if (low >= high) {
            return true;
        }
        int root = preorder[low], leftTree = low + 1;
        while (leftTree <= high && preorder[leftTree] < root) {
            leftTree++;
        }
        int rightTree = leftTree;
        while (rightTree <= high && preorder[leftTree] > root) {
            rightTree++;
        }
        if (rightTree <= high) {
            return false;
        }
        return verifyPreorderRecursive(preorder, low + 1, leftTree - 1) &&
            verifyPreorderRecursive(preorder, leftTree, high);
    }


}
