package leetcode;

import ds.TreeNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/25/15.
 */
public class CompleteBinaryTreeTest {

    @Test
    public void testCountNodes() throws Exception {
        CompleteBinaryTree completeBinaryTree = new CompleteBinaryTree();
        TreeNode treeNode = TreeNode.builder().val(6).
                left(TreeNode.builder().val(2).
                        left(TreeNode.builder().val(0).build()).
                        right(TreeNode.builder().val(4).build()).build()).
                right(TreeNode.builder().val(8).
                        left(TreeNode.builder().val(7).build()).
                        right(TreeNode.builder().val(9).build()).
                        build()).build();
        assertThat(completeBinaryTree.countNodes(treeNode)).isEqualTo(7);

    }
}
