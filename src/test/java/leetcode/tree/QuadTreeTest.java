package leetcode.tree;

import static org.assertj.core.api.Assertions.assertThat;

import leetcode.tree.QuadTree.Node;
import org.testng.annotations.Test;

public class QuadTreeTest {

    @Test
    public void testQuadTreeConstruction() {
        QuadTree quadTree = new QuadTree();
        Node tree = quadTree.construct(new int[][]{{0, 1}, {1, 0}});
        assertThat(tree.isLeaf).isFalse();
        assertThat(tree.val).isTrue();
        assertThat(tree.topLeft.val).isFalse();
        assertThat(tree.topRight.val).isTrue();
        assertThat(tree.bottomLeft.val).isTrue();
        assertThat(tree.bottomRight.val).isFalse();

    }
}