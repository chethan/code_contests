package leetcode.tree;

import ds.TreeNode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import leetcode.Pair;


public class VerticalOrder {

    //https://leetcode.com/problems/binary-tree-vertical-order-traversal/
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

    //https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> columns = new ArrayList<>();
        if (root == null) {
            return columns;
        }

        Map<Integer, List<Integer>> columnMap = new HashMap<>();
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        int minColumn = 0, maxColumn = 0;
        queue.add(new Pair<>(root, 0));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            Map<Integer, List<Integer>> columnMapAtOneLevel = new HashMap<>();
            for (int i = 0; i < levelSize; i++) {
                Pair<TreeNode, Integer> current = queue.poll();
                TreeNode currentNode = current.getKey();
                Integer currentColumn = current.getValue();
                columnMapAtOneLevel.putIfAbsent(currentColumn, new ArrayList<>());
                columnMapAtOneLevel.get(currentColumn).add(currentNode.val);
                minColumn = Math.min(minColumn, currentColumn);
                maxColumn = Math.max(maxColumn, currentColumn);
                if (currentNode.left != null) {
                    queue.add(new Pair<>(currentNode.left, currentColumn - 1));
                }
                if (currentNode.right != null) {
                    queue.add(new Pair<>(currentNode.right, currentColumn + 1));
                }
            }
            for (int column : columnMapAtOneLevel.keySet()) {
                Collections.sort(columnMapAtOneLevel.get(column));
                columnMap.putIfAbsent(column, new ArrayList<>());
                columnMap.get(column).addAll(columnMapAtOneLevel.get(column));
            }
        }

        for (int i = minColumn; i <= maxColumn; i++) {
            columns.add(columnMap.get(i));
        }
        return columns;
    }
}
