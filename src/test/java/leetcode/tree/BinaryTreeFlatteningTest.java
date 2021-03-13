package leetcode.tree;

import ds.TreeNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/25/15.
 */
public class BinaryTreeFlatteningTest {

    @Test
    public void testFlatten() throws Exception {
        BinaryTreeFlattening binaryTreeFlattening = new BinaryTreeFlattening();
        InOrder inOrder = new InOrder();
        TreeNode tree = TreeNode.builder().val(1).
                left(TreeNode.builder().val(2).
                        left(TreeNode.builder().val(4).build()).build()).
                right(TreeNode.builder().val(3).
                        right(TreeNode.builder().val(5).build()).build()).build();
        binaryTreeFlattening.flatten(tree);
        assertThat(inOrder.traverse(tree)).containsSequence(1,2,4,3,5);

    }
}
