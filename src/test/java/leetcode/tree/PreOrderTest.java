package leetcode.tree;

import ds.TreeNode;
import leetcode.tree.PreOrder;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/20/15.
 */
public class PreOrderTest {

    @Test
    public void testTraverse() throws Exception {
        PreOrder preOrder = new PreOrder();
        TreeNode tree = TreeNode.builder().val(1).
                left(TreeNode.builder().val(2).build()).right(TreeNode.builder().val(3).build()).build();
        assertThat(preOrder.traverse(tree)).containsSequence(1,2,3);
        assertThat(preOrder.traverse(null)).isEmpty();
        assertThat(preOrder.traverseIteratively(tree)).containsSequence( 1,2, 3);
        assertThat(preOrder.traverseIteratively(null)).isEmpty();
    }
}
