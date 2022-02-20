package leetcode.tree;

import ds.TreeNode;
import java.util.LinkedList;
import java.util.List;

public class Codec {

    //https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }
        return root.val + "," + serialize(root.left) + "," + serialize(root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String s) {
        if (s == null || s.isEmpty()) {
            return null;
        }
        String[] nodes = s.split(",");
        return helper(new LinkedList<>(List.of(nodes)));
    }

    private TreeNode helper(LinkedList<String> nodes) {
        if (nodes.get(0).equals("#")) {
            nodes.remove(0);
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(nodes.get(0)));
        nodes.remove(0);
        node.left = helper(nodes);
        node.right = helper(nodes);
        return node;
    }
}
