package leetcode.tree;

import static org.assertj.core.api.Assertions.assertThat;

import ds.TreeNode;
import org.testng.annotations.Test;

/**
 * Created by Chethan on 10/24/15.
 */
public class BinarySearchTreeTest {

    @Test
    public void testIsValidBST() throws Exception {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode tree = getBST();
        assertThat(binarySearchTree.isValidBST(tree)).isTrue();

        tree = TreeNode.builder().val(Integer.MIN_VALUE).
            right(TreeNode.builder().val(Integer.MAX_VALUE).
                left(TreeNode.builder().val(Integer.MIN_VALUE).build()).
                build()).build();
        assertThat(binarySearchTree.isValidBST(tree)).isFalse();
        tree = TreeNode.builder().val(Integer.MAX_VALUE).build();
        assertThat(binarySearchTree.isValidBST(tree)).isTrue();
    }

    @Test
    public void testKthSmallestElement() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        assertThat(binarySearchTree.kthSmallest(getBST(), 3)).isEqualTo(4);
    }

    @Test
    public void testSortedArrayToBST() throws Exception {
        InOrder inOrder = new InOrder();
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode treeNode = binarySearchTree.sortedArrayToBST(new int[]{1, 2, 3, 4});
        assertThat(inOrder.traverse(treeNode)).containsSequence(1, 2, 3, 4);
    }


    @Test
    public void testClosestValue() throws Exception {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        assertThat(binarySearchTree.closestValue(getBST(), 8.8)).isEqualTo(9);
    }


    @Test
    public void testVerifyPreorder() throws Exception {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        assertThat(binarySearchTree.verifyPreorder(
            new int[]{6, 2, 0, 4, 8, 7, 9}
        )).isTrue();
    }

    @Test
    public void testBSTToDoublyLinkedList() {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        TreeNode treeNode = binarySearchTree.treeToDoublyList(getBST());
        TreeNode clockwiseNode = treeNode;
        TreeNode counterClockwiseNode = treeNode;
        for (int i = 0; i < 9; i++) {
            clockwiseNode = clockwiseNode.right;
            counterClockwiseNode = counterClockwiseNode.left;
        }
        assertThat(clockwiseNode).isSameAs(counterClockwiseNode).isSameAs(treeNode);

    }

    private TreeNode getBST() {
        return TreeNode.builder().val(6).
            left(TreeNode.builder().val(2).
                left(TreeNode.builder().val(0).build()).
                right(TreeNode.builder().val(4).build()).build()).
            right(TreeNode.builder().val(8).
                left(TreeNode.builder().val(7).build()).
                right(TreeNode.builder().val(9).build()).
                build()).build();
    }
}
