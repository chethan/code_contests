package leetcode.array;

import ds.TreeNode;
import java.util.Stack;

//https://leetcode.com/problems/binary-search-tree-iterator/
//Next -> O(N) worst case, O(1) amortized on multiple calls of next
//hasNext -> O(1)
//Space -> O(H) where H is the height of the tree which at worst case is N
public class BSTIterator {

    private final Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        leftTreeInorder(root, stack);
    }

    void leftTreeInorder(TreeNode node, Stack<TreeNode> stack) {
        if (node == null) {
            return;
        }
        TreeNode loopNode = node;
        while (loopNode != null) {
            stack.push(loopNode);
            loopNode = loopNode.left;
        }
    }

    public int next() {
        if (hasNext()) {
            TreeNode current = stack.pop();
            leftTreeInorder(current.right, stack);
            return current.val;
        }
        return -1;

    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
