package leetcode;

import ds.TreeNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/24/15.
 */
public class BalancedBinaryTreeTest {

    @Test
    public void testIsBalanced() throws Exception {
        BalancedBinaryTree balancedBinaryTree = new BalancedBinaryTree();
        TreeNode tree = TreeNode.builder().val(6).
                left(TreeNode.builder().val(2).
                        left(TreeNode.builder().val(0).build()).
                        right(TreeNode.builder().val(4).build()).build()).
                right(TreeNode.builder().val(8).
                        left(TreeNode.builder().val(7).build()).
                        right(TreeNode.builder().val(9).build()).
                        build()).build();
        assertThat(balancedBinaryTree.height(tree)).isEqualTo(3);
        assertThat(balancedBinaryTree.isBalanced(tree)).isTrue();
    }
}
