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

    //https://leetcode.com/problems/maximum-average-subtree/
    public double maximumAverageSubtree(TreeNode root) {
        if (root == null) {
            return 0.0;
        }
        return compute(root).maxAverage;
    }

    //https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
    //https://leetcode.com/problems/lowest-common-ancestor-of-deepest-leaves/
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        if (root == null) {
            return null;
        }
        return helper(root, 1).node;
    }

    TreeDepth helper(TreeNode node, int depth) {
        if (node == null) {
            return null;
        }
        TreeDepth left = helper(node.left, depth + 1);
        TreeDepth right = helper(node.right, depth + 1);
        //leaf node
        if (left == null && right == null) {
            return new TreeDepth(node, depth);
        }
        //has both children
        if (left != null && right != null) {
            if (left.depth > right.depth) {
                return left;
            } else if (left.depth < right.depth) {
                return right;
            }
            return new TreeDepth(node, left.depth);
        }
        //has one of the children
        return left != null ? left : right;

    }

    private static class TreeDepth {

        int depth;
        TreeNode node;

        TreeDepth(TreeNode node, int depth) {
            this.node = node;
            this.depth = depth;
        }

    }

    private static class TreeMeta {

        double sum;
        double maxAverage;
        int nodes;

        TreeMeta(double sum, double maxAverage, int nodes) {
            this.sum = sum;
            this.maxAverage = maxAverage;
            this.nodes = nodes;
        }
    }

    private TreeMeta compute(TreeNode node) {
        if (node == null) {
            return new TreeMeta(0.0, 0.0, 0);
        }
        TreeMeta left = compute(node.left);
        TreeMeta right = compute(node.right);
        int nodes = left.nodes + right.nodes + 1;
        double sum = (left.sum + right.sum + node.val);
        double currentAverage = (left.sum + right.sum + node.val) / nodes;
        double maxAverage = Math.max(currentAverage, Math.max(left.maxAverage, right.maxAverage));
        return new TreeMeta(sum, maxAverage, nodes);
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
