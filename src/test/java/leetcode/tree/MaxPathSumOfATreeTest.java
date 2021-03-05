package leetcode.tree;

import static org.assertj.core.api.Assertions.assertThat;

import ds.TreeNode;
import org.testng.annotations.Test;

public class MaxPathSumOfATreeTest {

    @Test
    public void testMaxPathSumOfATree() {
        MaxPathSumOfATree maxPathSumOfATree = new MaxPathSumOfATree();
        TreeNode tree = TreeNode.builder().val(-10)
            .left(TreeNode.builder().val(9).build())
            .right(TreeNode.builder().val(20)
                .left(TreeNode.builder().val(15).build())
                .right(TreeNode.builder().val(7).build())
                .build())
            .build();

        assertThat(maxPathSumOfATree.sum(tree)).isEqualTo(42);
    }
}