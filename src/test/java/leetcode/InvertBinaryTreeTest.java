package leetcode;

import ds.TreeNode;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/24/15.
 */
public class InvertBinaryTreeTest {

    @Test
    public void testInvertTree() throws Exception {
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode tree = TreeNode.builder().val(1).
                left(TreeNode.builder().val(2).
                        left(TreeNode.builder().val(4).build()).
                        right(TreeNode.builder().val(5).build()).
                        build()).
                right(TreeNode.builder().val(3).
                        left(TreeNode.builder().val(6).build()).
                        right(TreeNode.builder().val(7).build()).
                        build()).
                build();

        assertThat(new LevelOrder().traverse(invertBinaryTree.invertTree(tree))).containsSequence(
                Arrays.asList(1), Arrays.asList(3, 2), Arrays.asList(7,6,5,4)
        );
    }
}
