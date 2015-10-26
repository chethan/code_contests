package leetcode;

import ds.TreeNode;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/25/15.
 */
public class BinaryTreeViewTest {

    @Test
    public void testRightSideView() throws Exception {
        BinaryTreeView binaryTreeView = new BinaryTreeView();
        TreeNode treeNode = TreeNode.builder().val(6).
                left(TreeNode.builder().val(2).
                        left(TreeNode.builder().val(0).build()).
                        right(TreeNode.builder().val(4).build()).build()).
                right(TreeNode.builder().val(8).
                        left(TreeNode.builder().val(7).build()).
                        build()).build();

       assertThat(binaryTreeView.rightSideView(treeNode)).containsSequence(6,8,7);
    }
}
