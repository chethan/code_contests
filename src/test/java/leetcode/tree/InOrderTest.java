package leetcode.tree;

import ds.TreeNode;
import leetcode.tree.InOrder;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/20/15.
 */
public class InOrderTest {

    @Test
    public void testTraverse() throws Exception {
        InOrder inOrder = new InOrder();
        TreeNode tree = TreeNode.builder().val(1).
                left(TreeNode.builder().val(2).build()).right(TreeNode.builder().val(3).build()).build();
        assertThat(inOrder.traverse(tree)).containsSequence(2,1,3);
        assertThat(inOrder.traverse(null)).isEmpty();
        assertThat(inOrder.traverseIteratively(tree)).containsSequence(2,1,3);
        assertThat(inOrder.traverseIteratively(null)).isEmpty();
    }
}
