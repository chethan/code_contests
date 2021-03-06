package leetcode.tree;

import static org.assertj.core.api.Assertions.assertThat;

import ds.TreeNode;
import org.testng.annotations.Test;

public class SubTreeTest {

    @Test
    public void testDuplicateSubTree() {
        SubTree subTree = new SubTree();
        TreeNode treeNode = TreeNode.builder().val(1)
            .left(TreeNode.builder().val(2)
                .left(TreeNode.builder().val(4).build())
                .build())
            .right(TreeNode.builder().val(3)
                .left(TreeNode.builder().val(2)
                    .left(TreeNode.builder().val(4).build())
                    .build())
                .right(TreeNode.builder().val(4).build())
                .build())
            .build();

        assertThat(subTree.findDuplicateSubtrees(treeNode)).hasSize(2);
    }

    @Test
    public void testWhetherTreeIsSubTree() {
        SubTree subTree = new SubTree();
        TreeNode tree1 = TreeNode.builder().val(3)
            .left(TreeNode.builder().val(2)
                .left(TreeNode.builder().val(4).build())
                .build())
            .right(TreeNode.builder().val(4).build())
            .build();
        TreeNode tree2 = TreeNode.builder().val(1)
            .left(TreeNode.builder().val(2)
                .left(TreeNode.builder().val(4).build())
                .build())
            .right(tree1)
            .build();

        assertThat(subTree.isSubtree(tree2,tree1)).isTrue();
    }
}