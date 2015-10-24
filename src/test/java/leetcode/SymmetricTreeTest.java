package leetcode;

import ds.TreeNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/24/15.
 */
public class SymmetricTreeTest {

    @Test
    public void testIsSymmetric() throws Exception {
        SymmetricTree symmetricTree = new SymmetricTree();
        TreeNode tree = TreeNode.builder().val(1).
                left(TreeNode.builder().val(2).
                        left(TreeNode.builder().val(4).build()).build()).
                right(TreeNode.builder().val(2).
                        right(TreeNode.builder().val(4).build()).build()).build();

        assertThat(symmetricTree.isSymmetric(tree)).isTrue();

    }
}
