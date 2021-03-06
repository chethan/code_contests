package leetcode.tree;

import ds.TreeNode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import leetcode.Pair;

//https://leetcode.com/problems/binary-tree-vertical-order-traversal/
public class VerticalOrder {

    public List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> columns = new ArrayList<>();
        if (root == null) {
            return columns;
        }
        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int minColumn = 0, maxColumn = 0;
        queue.offer(new Pair<>(root, 0));
        while (!queue.isEmpty()) {
            Pair<TreeNode, Integer> p = queue.poll();
            TreeNode node = p.getKey();
            int column = p.getValue();
            if (node != null) {
                columnMap.putIfAbsent(column, new ArrayList<>());
                columnMap.get(column).add(node.val);
                minColumn = Math.min(minColumn, column);
                maxColumn = Math.max(maxColumn, column);
                queue.offer(new Pair<>(node.left, column - 1));
                queue.offer(new Pair<>(node.right, column + 1));
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) {
            columns.add(columnMap.get(i));
        }

        return columns;
    }
}
