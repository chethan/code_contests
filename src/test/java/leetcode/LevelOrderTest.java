package leetcode;

import ds.TreeNode;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/20/15.
 */
public class LevelOrderTest {

    @Test
    public void testTraverse() throws Exception {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode tree = TreeNode.builder().val(1).
                left(TreeNode.builder().val(2).build()).right(TreeNode.builder().val(3).build()).build();
        assertThat(levelOrder.traverse(tree)).containsSequence(Arrays.asList(1), Arrays.asList(2, 3));
        assertThat(levelOrder.traverse(null)).isEmpty();
    }

    @Test
    public void testTraverseFromBottom() throws Exception {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode tree = TreeNode.builder().val(1).
                left(TreeNode.builder().val(2).build()).right(TreeNode.builder().val(3).build()).build();
        assertThat(levelOrder.traverseFromBottom(tree)).containsSequence(Arrays.asList(2, 3), Arrays.asList(1));
        assertThat(levelOrder.traverseFromBottom(null)).isEmpty();
    }

    @Test
    public void testZigzagTraversal() throws Exception {
        LevelOrder levelOrder = new LevelOrder();
        TreeNode tree = TreeNode.builder().val(3).
                left(TreeNode.builder().val(9).build()).
                right(TreeNode.builder().val(20).
                        left(TreeNode.builder().val(15).build()).
                        right(TreeNode.builder().val(7).build()).build()).build();

        assertThat(levelOrder.zigzagTraversal(tree)).containsSequence(Arrays.asList(3), Arrays.asList(20, 9), Arrays.asList(15, 7));
        tree = TreeNode.builder().val(1).
                left(TreeNode.builder().val(2).
                        left(TreeNode.builder().val(4).build()).build()).
                right(TreeNode.builder().val(3).
                        right(TreeNode.builder().val(5).build()).build()).build();

        assertThat(levelOrder.zigzagTraversal(tree)).containsSequence(Arrays.asList(1), Arrays.asList(3, 2), Arrays.asList(4, 5));
        assertThat(levelOrder.traverseFromBottom(null)).isEmpty();
    }
}
