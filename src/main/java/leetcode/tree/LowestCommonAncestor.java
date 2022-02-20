package leetcode.tree;

import ds.TreeNode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Stack;

/**
 * Created by Chethan on 10/24/15.
 */
public class LowestCommonAncestor {

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
    public TreeNode lowestCommonAncestorBST(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root.val > p.val && root.val > q.val) {
            return lowestCommonAncestorBST(root.left, p, q);
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestorBST(root.right, p, q);
        }
        return root;
    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) {
            return null;
        }
        if (root == p || root == q) {
            return root;
        }
        TreeNode lcaInLeftTree = lowestCommonAncestor(root.left, p, q);
        TreeNode lcaInRightTree = lowestCommonAncestor(root.right, p, q);
        if (lcaInLeftTree != null && lcaInRightTree != null) {
            return root;
        }
        return lcaInLeftTree != null ? lcaInLeftTree : lcaInRightTree;
    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
    public TreeNode lowestCommonAncestorOptimized(TreeNode root, TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return null;
        }
        return countAtNode(root, p, q).lca;
    }

    public TreeNode lowestCommonAncestorIterative(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> stack = new Stack<>();
        Map<TreeNode, TreeNode> parents = new HashMap<>();
        if (root == null) {
            return null;
        }
        stack.push(root);
        parents.put(root, null);
        while (!parents.containsKey(p) || !parents.containsKey(q)) {
            TreeNode current = stack.pop();
            if (current.left != null) {
                stack.push(current.left);
                parents.put(current.left, current);
            }
            if (current.right != null) {
                stack.push(current.right);
                parents.put(current.right, current);
            }
        }
        Set<TreeNode> ancestors = new HashSet<>();
        while (p != null) {
            ancestors.add(p);
            p = parents.get(p);
        }
        while (!ancestors.contains(q)) {
            q = parents.get(q);
        }
        return q;
    }

    //https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree-iii/
    public Node lowestCommonAncestor(Node p, Node q) {
        if (p == null || q == null) {
            return null;
        }
        Set<Node> ancestors = new HashSet<>();
        ancestors.add(p);
        ancestors.add(q);
        while (p.parent != null || q.parent != null) {
            if (p.parent != null) {
                if (ancestors.contains(p.parent)) {
                    return p.parent;
                }
                ancestors.add(p.parent);
                p = p.parent;
            }
            if (q.parent != null) {
                if (ancestors.contains(q.parent)) {
                    return q.parent;
                }
                ancestors.add(q.parent);
                q = q.parent;
            }

        }
        return null;
    }

    private static class Status {

        private final int count;
        private final TreeNode lca;

        public Status(int count, TreeNode lca) {
            this.count = count;
            this.lca = lca;
        }
    }

    private class Node {

        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }

    private Status countAtNode(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null) {
            return new Status(0, null);
        }
        Status leftStatus = countAtNode(node.left, p, q);
        if (leftStatus.count == 2) {
            return leftStatus;
        }
        Status rightStatus = countAtNode(node.right, p, q);
        if (rightStatus.count == 2) {
            return rightStatus;
        }
        int count = leftStatus.count + rightStatus.count +
            (node == p ? 1 : 0) + (node == q ? 1 : 0);
        return new Status(count, count == 2 ? node : null);
    }

}
