package leetcode.tree;

import ds.TreeNode;
import java.util.ArrayList;
import java.util.List;


public class BalancedBinarySearchTree {

    //Time: O(N)
    //Space: O(N)
    //https://leetcode.com/problems/balance-a-binary-search-tree/
    public TreeNode balanceBST(TreeNode root) {
        //sort nodes
        List<Integer> sortedList = new ArrayList<>();
        sort(root, sortedList);
        // sortedNodes to bst
        return toBST(sortedList, 0, sortedList.size() - 1);
    }

    TreeNode toBST(List<Integer> sortedList, int lo, int hi) {
        if (hi < lo) {
            return null;
        }
        int mid = lo + (hi - lo) / 2;
        TreeNode node = new TreeNode(sortedList.get(mid));
        node.left = toBST(sortedList, lo, mid - 1);
        node.right = toBST(sortedList, mid + 1, hi);
        return node;
    }

    void sort(TreeNode node, List<Integer> sortedList) {
        if (node == null) {
            return;
        }
        sort(node.left, sortedList);
        sortedList.add(node.val);
        sort(node.right, sortedList);
    }
}
