package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Chethan on 10/24/15.
 */
public class PathSum {
    //https://leetcode.com/problems/path-sum/
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    //https://leetcode.com/problems/binary-tree-paths/
    public List<String> binaryTreePaths(TreeNode root) {
        ArrayList<String> paths = new ArrayList<>();
        if (root == null) return paths;
        List<String> strings = binaryTreePaths(root.left);
        strings.addAll(binaryTreePaths(root.right));
        if (strings.size() == 0) paths.add(root.val + "");
        for (String string : strings) {
            paths.add(root.val + "->" + string);
        }
        return paths;
    }


    //https://leetcode.com/problems/path-sum-ii/
    public List<List<Integer>> binaryTreePathSums(TreeNode root, int sum) {
        ArrayList<List<Integer>> paths = new ArrayList<>();
        if (root == null) return paths;
        if (root.left == null && root.right == null && sum == root.val) {
            paths.add(Arrays.asList(root.val));
        } else {
            List<List<Integer>> sums = binaryTreePathSums(root.right, sum - root.val);
            sums.addAll(binaryTreePathSums(root.left, sum - root.val));
            for (List<Integer> integers : sums) {
                if (integers.size() != 0) {
                    ArrayList<Integer> list = new ArrayList<>();
                    list.add(root.val);
                    list.addAll(integers);
                    paths.add(list);
                }
            }
        }
        return paths;
    }

}
