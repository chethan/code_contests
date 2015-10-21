package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chethan on 10/20/15.
 */
//https://leetcode.com/problems/binary-tree-inorder-traversal/
public class InOrder {
    public List<Integer> traverse(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) return values;
        if (root.left != null) values.addAll(traverse(root.left));
        values.add(root.val);
        if (root.right != null) values.addAll(traverse(root.right));
        return values;
    }


    public List<Integer> traverseIteratively(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        TreeNode loopNode = root;
        while (true) {
            if (loopNode != null) {
                nodes.push(loopNode);
                loopNode = loopNode.left;
            } else if (!nodes.isEmpty()) {
                TreeNode pop = nodes.pop();
                values.add(pop.val);
                loopNode = pop.right;
            } else {
                break;
            }
        }
        return values;
    }

}
