package leetcode;

import ds.TreeNode;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/24/15.
 */
public class PathSumTest {

    @Test
    public void testHasPathSum() throws Exception {
        PathSum pathSum = new PathSum();
        TreeNode tree = TreeNode.builder().val(3).
                left(TreeNode.builder().val(9).build()).
                right(TreeNode.builder().val(20).
                        left(TreeNode.builder().val(15).build()).
                        right(TreeNode.builder().val(7).build()).build()).build();

       assertThat(pathSum.hasPathSum(tree,30)).isTrue();
        assertThat(pathSum.binaryTreePathSums(tree,30)).containsOnly(Arrays.asList(3, 20, 7));
    }

    @Test
    public void testBinaryTreePaths() throws Exception {
        PathSum pathSum = new PathSum();
        TreeNode tree = TreeNode.builder().val(3).
                left(TreeNode.builder().val(9).build()).
                right(TreeNode.builder().val(20).
                        left(TreeNode.builder().val(15).build()).
                        right(TreeNode.builder().val(7).build()).build()).build();
        assertThat(pathSum.binaryTreePaths(tree)).containsSequence("3->9","3->20->15","3->20->7");

    }
}
