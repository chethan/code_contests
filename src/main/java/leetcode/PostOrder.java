package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chethan on 10/20/15.
 */
//https://leetcode.com/problems/binary-tree-postorder-traversal/
public class PostOrder {
    public List<Integer> traverse(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) return values;
        if (root.left != null) values.addAll(traverse(root.left));
        if (root.right != null) values.addAll(traverse(root.right));
        values.add(root.val);
        return values;
    }


    public List<Integer> traverseIteratively(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> first = new Stack<>();
        Stack<TreeNode> second = new Stack<>();
        if (root != null) first.push(root);
        while (!first.isEmpty()) {
            TreeNode pop = first.pop();
            second.push(pop);
            if(pop.left!=null) first.push(pop.left);
            if(pop.right!=null) first.push(pop.right);
        }
        while (!second.isEmpty()){
            values.add(second.pop().val);
        }
        return values;
    }

}
