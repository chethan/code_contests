package leetcode.tree;

import ds.TreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * Created by Chethan on 10/20/15.
 */
public class LevelOrder {

    //https://leetcode.com/problems/binary-tree-level-order-traversal/
    public List<List<Integer>> traverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> values = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            ArrayList<Integer> integers = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                integers.add(treeNode.val);
                if (treeNode.left != null) {
                    tempQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    tempQueue.add(treeNode.right);
                }
            }
            queue = tempQueue;
            values.add(integers);
        }
        return values;
    }

    //https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
    public List<List<Integer>> traverseFromBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        Stack<List<Integer>> values = new Stack<>();
        List<List<Integer>> bottomUpValues = new ArrayList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            ArrayList<Integer> integers = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                integers.add(treeNode.val);
                if (treeNode.left != null) {
                    tempQueue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    tempQueue.add(treeNode.right);
                }
            }
            queue = tempQueue;
            values.push(integers);
        }

        while (!values.isEmpty()) {
            bottomUpValues.add(values.pop());
        }

        return bottomUpValues;
    }

    //https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
    public List<List<Integer>> zigzagTraversal(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> values = new ArrayList<>();
        boolean isRightDirection = true;
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            isRightDirection = !isRightDirection;
            ArrayList<Integer> integers = new ArrayList<>();
            Deque<TreeNode> tempQueue = new ArrayDeque<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.pollLast();
                integers.add(treeNode.val);
                if (isRightDirection) {
                    if (treeNode.right != null) {
                        tempQueue.add(treeNode.right);
                    }
                    if (treeNode.left != null) {
                        tempQueue.add(treeNode.left);
                    }
                } else {
                    if (treeNode.left != null) {
                        tempQueue.add(treeNode.left);
                    }
                    if (treeNode.right != null) {
                        tempQueue.add(treeNode.right);
                    }
                }
            }
            queue = tempQueue;
            values.add(integers);
        }
        return values;
    }

    //https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
    public void connect(TreeLinkNode root) {
        Queue<TreeLinkNode> queue = new LinkedList<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            Queue<TreeLinkNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeLinkNode poll = queue.poll();
                if (!queue.isEmpty()) {
                    poll.next = queue.peek();
                }
                if (poll.left != null) {
                    tempQueue.add(poll.left);
                }
                if (poll.right != null) {
                    tempQueue.add(poll.right);
                }
            }
            queue = tempQueue;
        }
    }


    public static class TreeLinkNode {

        public TreeLinkNode(int val) {
            this.val = val;
        }

        public int val;
        public TreeLinkNode left, right, next;
    }

}
