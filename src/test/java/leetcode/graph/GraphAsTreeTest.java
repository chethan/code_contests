package leetcode.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class GraphAsTreeTest {

    @Test
    public void testIsValidTreeUsingDFS() {
        GraphAsTree graphAsTree = new GraphAsTree();
        assertThat(graphAsTree.validTree(5, new int[][]{
            {0, 1}, {0, 2}, {0, 3}, {1, 4}})).isTrue();
        assertThat(graphAsTree.validTree(5, new int[][]{
            {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}})).isFalse();
    }

    @Test
    public void testIsValidTreeUsingUnionFind() {
        GraphAsTree graphAsTree = new GraphAsTree();
        assertThat(graphAsTree.validTreeUsingUnionFind(5, new int[][]{
            {0, 1}, {0, 2}, {0, 3}, {1, 4}})).isTrue();
        assertThat(graphAsTree.validTreeUsingUnionFind(5, new int[][]{
            {0, 1}, {1, 2}, {2, 3}, {1, 3}, {1, 4}})).isFalse();
    }
}