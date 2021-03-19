package leetcode.tree;

import static org.assertj.core.api.Assertions.assertThat;

import ds.TreeNode;
import java.util.List;
import org.testng.annotations.Test;

public class VerticalOrderTest {

    @Test
    public void testVerticalTraversal() {
        VerticalOrder verticalOrder = new VerticalOrder();
        TreeNode root = TreeNode.builder().val(3)
            .left(TreeNode.builder().val(9)
                .left(TreeNode.builder().val(4).build())
                .right(TreeNode.builder().val(10).build())
                .build())
            .right(TreeNode.builder().val(8)
                .left(TreeNode.builder().val(1).build())
                .right(TreeNode.builder().val(7).build())
                .build())
            .build();
        assertThat(verticalOrder.traverse(root))
            .containsExactly(List.of(4), List.of(9), List.of(3, 10, 1), List.of(8), List.of(7));
    }

    @Test
    public void testVerticalTraversalWithSortedNodesOnSameRow() {
        VerticalOrder verticalOrder = new VerticalOrder();
        TreeNode root = TreeNode.builder().val(3)
            .left(TreeNode.builder().val(9)
                .left(TreeNode.builder().val(4).build())
                .right(TreeNode.builder().val(10).build())
                .build())
            .right(TreeNode.builder().val(8)
                .left(TreeNode.builder().val(1).build())
                .right(TreeNode.builder().val(7).build())
                .build())
            .build();
        assertThat(verticalOrder.verticalTraversal(root))
            .containsExactly(List.of(4), List.of(9), List.of(3, 1, 10), List.of(8), List.of(7));
    }
}