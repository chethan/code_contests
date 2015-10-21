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
        assertThat(levelOrder.traverseFromBottom(tree)).containsSequence(Arrays.asList(2,3), Arrays.asList(1));
        assertThat(levelOrder.traverseFromBottom(null)).isEmpty();
    }
}
