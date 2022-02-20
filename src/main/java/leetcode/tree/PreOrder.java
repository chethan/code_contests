package leetcode.tree;

import ds.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by Chethan on 10/20/15.
 */
//https://leetcode.com/problems/binary-tree-preorder-traversal/
public class PreOrder {

    public List<Integer> traverse(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        if (root == null) {
            return values;
        }
        values.add(root.val);
        if (root.left != null) {
            values.addAll(traverse(root.left));
        }
        if (root.right != null) {
            values.addAll(traverse(root.right));
        }
        return values;
    }


    public List<Integer> traverseIteratively(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        Stack<TreeNode> nodes = new Stack<>();
        if (root != null) {
            nodes.push(root);
        }
        while (!nodes.isEmpty()) {
            TreeNode pop = nodes.pop();
            values.add(pop.val);
            if (pop.right != null) {
                nodes.push(pop.right);
            }
            if (pop.left != null) {
                nodes.push(pop.left);
            }
        }
        return values;
    }

    public List<Integer> traverseUsingMorrisAlgorithm(TreeNode root) {
        List<Integer> output = new LinkedList<>();
        TreeNode node = root;
        while (node != null) {
            if (node.left == null) {
                output.add(node.val);
                node = node.right;
            } else {
                TreeNode predecessor = node.left;
                while ((predecessor.right != null) && (predecessor.right != node)) {
                    predecessor = predecessor.right;
                }
                if (predecessor.right == null) {
                    output.add(node.val);
                    predecessor.right = node;
                    node = node.left;
                } else {
                    predecessor.right = null;
                    node = node.right;
                }
            }
        }
        return output;
    }

    private int pIndex = 0;

    //https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder - first element is the root
        // inorder - if you know the root, two halfes of the tree can be found
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        if (inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        return buildTree(preorder, inorder, 0, inorder.length - 1, inorderMap);

    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int left, int right,
        Map<Integer, Integer> inorderMap) {
        if (left > right) {
            return null;
        }
        int rootValue = preorder[pIndex++];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = inorderMap.get(rootValue);
        root.left = buildTree(preorder, inorder, left, rootIndex - 1, inorderMap);
        root.right = buildTree(preorder, inorder, rootIndex + 1, right, inorderMap);
        return root;
    }

}
