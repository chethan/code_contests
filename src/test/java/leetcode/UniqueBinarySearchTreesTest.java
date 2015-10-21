package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/19/15.
 */
public class UniqueBinarySearchTreesTest {

    @Test
    public void testNumTrees() throws Exception {
        UniqueBinarySearchTrees uniqueBinarySearchTrees = new UniqueBinarySearchTrees();
        assertThat(uniqueBinarySearchTrees.numTrees(3)).isEqualTo(5);
    }
}
