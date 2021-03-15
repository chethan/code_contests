package leetcode.backtracking;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class MatrixLongestIncreasingPathTest {

    @Test
    public void testLongestIncreasingPathInMatrix() {
        MatrixLongestIncreasingPath matrixLongestIncreasingPath = new MatrixLongestIncreasingPath();
        assertThat(matrixLongestIncreasingPath
            .longestIncreasingPath(new int[][]{{9, 9, 4}, {6, 6, 8}, {2, 1, 1}})).isEqualTo(4);
    }
}