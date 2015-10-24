package leetcode;

import ds.TreeNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/24/15.
 */
public class DepthOfATreeTest {

    @Test
    public void testDepth() throws Exception {
        DepthOfATree depthOfATree = new DepthOfATree();
        TreeNode tree = TreeNode.builder().val(3).
                left(TreeNode.builder().val(9).build()).
                right(TreeNode.builder().val(20).
                        left(TreeNode.builder().val(15).build()).
                        right(TreeNode.builder().val(7).build()).build()).build();

        assertThat(depthOfATree.minDepth(tree)).isEqualTo(2);
        assertThat(depthOfATree.maxDepth(tree)).isEqualTo(3);


        tree = TreeNode.builder().val(1).
                left(TreeNode.builder().val(2).
                        left(TreeNode.builder().val(4).build()).build()).
                right(TreeNode.builder().val(3).
                        right(TreeNode.builder().val(5).build()).build()).build();

        assertThat(depthOfATree.minDepth(tree)).isEqualTo(3);
        assertThat(depthOfATree.maxDepth(tree)).isEqualTo(3);


        tree = TreeNode.builder().val(1).
                left(TreeNode.builder().val(2).build()).build();

        assertThat(depthOfATree.minDepth(tree)).isEqualTo(2);
        assertThat(depthOfATree.maxDepth(tree)).isEqualTo(2);
    }
}
