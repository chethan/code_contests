package leetcode;

import ds.TreeNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/20/15.
 */
public class PostOrderTest {

    @Test
    public void testTraverse() throws Exception {
        PostOrder postOrder = new PostOrder();
        TreeNode tree = TreeNode.builder().val(1).
                left(TreeNode.builder().val(2).build()).right(TreeNode.builder().val(3).build()).build();
        assertThat(postOrder.traverse(tree)).containsSequence(2, 3, 1);
        assertThat(postOrder.traverse(null)).isEmpty();
        assertThat(postOrder.traverseIteratively(tree)).containsSequence(2,3,1);
        assertThat(postOrder.traverseIteratively(null)).isEmpty();
    }
}
