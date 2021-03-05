package leetcode.tree;

import static org.assertj.core.api.Assertions.assertThat;

import ds.TreeNode;
import org.testng.annotations.Test;

public class DiameterOfATreeTest {

    @Test
    public void testDiameterOfATree() {
        DiameterOfATree diameterOfATree = new DiameterOfATree();
        TreeNode tree = TreeNode.builder().val(1)
            .left(TreeNode.builder().val(2)
                .left(TreeNode.builder().val(4).build())
                .right(TreeNode.builder().val(5).build())
                .build())
            .right(TreeNode.builder().val(3).build())
            .build();
        assertThat(diameterOfATree.diameter(tree)).isEqualTo(3);
    }
}