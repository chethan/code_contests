package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/19/15.
 */
public class MaximalSquareTest {

    @Test
    public void testFindMaximalSquare() throws Exception {
        MaximalSquare maximalSquare = new MaximalSquare();
        char[][] chars = {{'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};
        assertThat(maximalSquare.findMaximalSquare(chars)).isEqualTo(4);
        chars = new char[][]{{'0', '0', '0'},
                             {'0', '0', '0'},
                             {'0', '0', '0'},
                             {'0', '0', '0'},
                             {'0', '0', '0'}};
        assertThat(maximalSquare.findMaximalSquare(chars)).isEqualTo(0);
        chars = new char[][]{{'1'}};
        assertThat(maximalSquare.findMaximalSquare(chars)).isEqualTo(1);
    }
}
