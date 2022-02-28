package leetcode.tree;

import ds.TreeNode;
import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/maximum-width-of-binary-tree/
public class WidthOfATree {

    public int widthOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Deque<Pair> queue = new ArrayDeque<>();
        queue.offer(new Pair(0, root));
        int maxWidth = 0;
        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            maxWidth = Math.max(maxWidth, queue.peekLast().index - queue.peekFirst().index + 1);
            for (int i = 0; i < levelSize; i++) {
                Pair current = queue.poll();
                int index = current.index;
                TreeNode node = current.node;
                if (node.left != null) {
                    queue.offer(new Pair(index * 2, node.left));
                }
                if (node.right != null) {
                    queue.offer(new Pair((index * 2) + 1, node.right));
                }
            }
        }
        return maxWidth;
    }

    private class Pair {

        int index;
        TreeNode node;

        Pair(int index, TreeNode node) {
            this.index = index;
            this.node = node;
        }
    }
}
