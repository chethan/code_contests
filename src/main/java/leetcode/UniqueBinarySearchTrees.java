package leetcode;

import ds.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chethan on 10/19/15.
 */
public class UniqueBinarySearchTrees {
    //https://leetcode.com/problems/unique-binary-search-trees/
    public int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += (dp[j] * dp[i - j - 1]);
            }
        }
        return dp[n];
    }

    //https://leetcode.com/problems/unique-binary-search-trees-ii/
    public List<TreeNode> generateTrees(int n) {
        return generateTreesRecursive(1, n);
    }

    private List<TreeNode> generateTreesRecursive(int start, int end) {
        List<TreeNode> treeNodes = new ArrayList<>();
        if (start > end) {
            treeNodes.add(null);
            return treeNodes;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTreesRecursive(start, i - 1);
            List<TreeNode> rightTrees = generateTreesRecursive(i + 1, end);
            for (TreeNode rightTree : rightTrees) {
                for (TreeNode leftTree : leftTrees) {
                    TreeNode treeNode = new TreeNode(i);
                    treeNode.left = leftTree;
                    treeNode.right = rightTree;
                    treeNodes.add(treeNode);
                }
            }
        }
        return treeNodes;
    }
}
