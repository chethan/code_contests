package leetcode.tree;

import static org.assertj.core.api.Assertions.assertThat;

import ds.TreeNode;
import org.testng.annotations.Test;

public class ArithmeticProgressionTest {

    @Test
    public void testArithmeticProgression() {
        TreeNode treeNode = TreeNode.builder().val(3)
            .left(TreeNode.builder().val(2)
                .left(TreeNode.builder().val(3)
                    .right(TreeNode.builder().val(-1).build())
                    .build())
                .right(TreeNode.builder().val(4)
                    .left(TreeNode.builder().val(6).build())
                    .right(TreeNode.builder().val(2).build())
                    .build())
                .build())
            .right(TreeNode.builder().val(2)
                .build())
            .build();

        ArithmeticProgression arithmeticProgression = new ArithmeticProgression();
        assertThat(arithmeticProgression.maxArithmeticProgression(treeNode)).isEqualTo(3);
        assertThat(arithmeticProgression.maxArithmeticProgression(TreeNode.builder().val(2)
            .left(TreeNode.builder().val(1).build())
            .build()))
            .isEqualTo(2);
        assertThat(arithmeticProgression.maxArithmeticProgression(TreeNode.builder().val(2)
            .left(TreeNode.builder().val(1)
                .left(TreeNode.builder().val(0).build())
                .build())
            .build()))
            .isEqualTo(3);
    }
}