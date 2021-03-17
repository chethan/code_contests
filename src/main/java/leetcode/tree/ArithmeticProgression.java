package leetcode.tree;

import ds.TreeNode;

public class ArithmeticProgression {

    int maxLength = 0;

    public int maxArithmeticProgression(TreeNode node) {
        maxLength = 0;
        if (node == null) {
            return 0;
        }
        dfs(node, null, 1);
        return maxLength;
    }

    private void dfs(TreeNode node, Integer diff, Integer chainLength) {
        if (node == null) {
            return;
        }
        if (chainLength >= maxLength) {
            maxLength = chainLength;
        }

        if (node.left != null) {
            if (diff != null && diff != (node.val - node.left.val)) {
                dfs(node.left, node.val - node.left.val, 2);
            } else {
                dfs(node.left, node.val - node.left.val, chainLength + 1);
            }
        }

        if (node.right != null) {
            if (diff != null && diff != (node.val - node.right.val)) {
                dfs(node.right, node.val - node.right.val, 2);
            } else {
                dfs(node.right, node.val - node.right.val, chainLength + 1);
            }
        }

    }


}
