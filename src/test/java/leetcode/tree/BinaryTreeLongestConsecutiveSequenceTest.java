package leetcode.tree;

import static org.assertj.core.api.Assertions.assertThat;

import ds.TreeNode;
import org.testng.annotations.Test;

public class BinaryTreeLongestConsecutiveSequenceTest {

    @Test
    public void testLongestConsecutiveSequence() {
        TreeNode treeNode = TreeNode.builder().val(2)
            .right(TreeNode.builder().val(3)
                .left(TreeNode.builder().val(2)
                    .left(TreeNode.builder().val(1).build())
                    .build())
                .build())
            .build();
        BinaryTreeLongestConsecutiveSequence consecutiveSequence = new BinaryTreeLongestConsecutiveSequence();
        assertThat(consecutiveSequence.longestConsecutive(treeNode)).isEqualTo(2);
    }
}