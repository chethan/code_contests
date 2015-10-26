package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Chethan on 10/25/15.
 */
public class BinaryTreeView {

    //https://leetcode.com/problems/binary-tree-right-side-view/
    public List<Integer> rightSideView(TreeNode root) {
        List<List<Integer>> traverse = levelOrderTraverse(root);
        ArrayList<Integer> rightSide = new ArrayList<>();
        for (List<Integer> integers : traverse) {
            rightSide.add(integers.get(integers.size() - 1));
        }
        return rightSide;

    }

    private List<List<Integer>> levelOrderTraverse(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> values = new ArrayList<>();
        if (root != null) queue.add(root);
        while (!queue.isEmpty()) {
            ArrayList<Integer> integers = new ArrayList<>();
            Queue<TreeNode> tempQueue = new LinkedList<>();
            while (!queue.isEmpty()) {
                TreeNode treeNode = queue.poll();
                integers.add(treeNode.val);
                if (treeNode.left != null) tempQueue.add(treeNode.left);
                if (treeNode.right != null) tempQueue.add(treeNode.right);
            }
            queue = tempQueue;
            values.add(integers);
        }
        return values;
    }

}
