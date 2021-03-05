package leetcode.tree;


import static org.assertj.core.api.Assertions.assertThat;

import ds.TreeNode;
import org.testng.annotations.Test;

public class FlipEquivalentBinaryTreeTest {

    @Test
    public void testFlipEquivalentBinaryTree() {
        FlipEquivalentBinaryTree flipEquivalentBinaryTree = new FlipEquivalentBinaryTree();
        TreeNode tree1 = TreeNode.builder().val(1).
            left(TreeNode.builder().val(2).
                left(TreeNode.builder().val(4).build()).
                right(TreeNode.builder().val(5)
                    .left(TreeNode.builder().val(7).build())
                    .right(TreeNode.builder().val(8).build())
                    .build()).build()).
            right(TreeNode.builder().val(3).
                left(TreeNode.builder().val(6).build()).
                build()).build();

        TreeNode tree2 = TreeNode.builder().val(1).
            left(TreeNode.builder().val(3).
                left(TreeNode.builder().val(6).build()).
                build())
            .right(TreeNode.builder().val(2).
                left(TreeNode.builder().val(4).build()).
                right(TreeNode.builder().val(5)
                    .left(TreeNode.builder().val(7).build())
                    .right(TreeNode.builder().val(8).build())
                    .build()).
                build())
            .build();

        assertThat(flipEquivalentBinaryTree.areEqual(tree1, tree2)).isTrue();
        assertThat(flipEquivalentBinaryTree.areEqual(null, tree2)).isFalse();
        assertThat(flipEquivalentBinaryTree.areEqual(tree1, null)).isFalse();
        assertThat(flipEquivalentBinaryTree.areEqual(null, null)).isTrue();

    }
}