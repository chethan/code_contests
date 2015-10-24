package leetcode;

import ds.TreeNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/24/15.
 */
public class LowestCommonAncestorTest {

    @Test
    public void testLowestCommonAncestorBST() throws Exception {
        TreeNode tree = TreeNode.builder().val(6).
                left(TreeNode.builder().val(2).
                        left(TreeNode.builder().val(0).build()).
                        right(TreeNode.builder().val(4).build()).build()).
                right(TreeNode.builder().val(8).
                        left(TreeNode.builder().val(7).build()).
                        right(TreeNode.builder().val(9).build()).
                        build()).build();


        LowestCommonAncestor lowestCommonAncestor = new LowestCommonAncestor();
        assertThat(lowestCommonAncestor.lowestCommonAncestorBST(tree,TreeNode.builder().val(0).build(),
                TreeNode.builder().val(9).build() ).val).isEqualTo(6);
    }
}
