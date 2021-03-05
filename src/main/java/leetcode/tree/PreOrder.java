package leetcode.tree;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Chethan on 10/20/15.
 */
//https://leetcode.com/problems/binary-tree-preorder-traversal/
public class PreOrder {
    public List<Integer> traverse(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) return values;
        values.add(root.val);
        if (root.left != null) values.addAll(traverse(root.left));
        if (root.right != null) values.addAll(traverse(root.right));
        return values;
    }


    public List<Integer> traverseIteratively(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        if(root!=null) nodes.push(root);
        while (!nodes.isEmpty()){
            TreeNode pop = nodes.pop();
            values.add(pop.val);
            if(pop.right!=null)nodes.push(pop.right);
            if(pop.left!=null)nodes.push(pop.left);
        }
        return values;
    }

}
