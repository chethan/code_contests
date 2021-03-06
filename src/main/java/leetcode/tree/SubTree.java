package leetcode.tree;

import ds.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubTree {

    //https://leetcode.com/problems/find-duplicate-subtrees/
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        ArrayList<TreeNode> duplicateNodes = new ArrayList<>();
        collect(root, new HashMap<>(), duplicateNodes);
        return duplicateNodes;
    }

    private String collect(TreeNode node, Map<String, Integer> countMap,
        List<TreeNode> duplicateNodes) {
        if (node == null) {
            return "#";
        }
        String serial = node.val + "," + collect(node.left, countMap, duplicateNodes)
            + "," + collect(node.right, countMap, duplicateNodes);
        countMap.put(serial, countMap.getOrDefault(serial, 0) + 1);
        if (countMap.get(serial) == 2) {
            duplicateNodes.add(node);
        }
        return serial;
    }

    //https://leetcode.com/problems/subtree-of-another-tree/
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (hasSameStructure(s, t)) {
            return true;
        }
        if (s == null) {
            return false;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean hasSameStructure(TreeNode n1, TreeNode n2) {
        if (n1 == null && n2 == null) {
            return true;
        }
        if (n1 == null || n2 == null) {
            return false;
        }
        return n1.val == n2.val && hasSameStructure(n1.left, n2.left) && hasSameStructure(n1.right,
            n2.right);
    }
}
