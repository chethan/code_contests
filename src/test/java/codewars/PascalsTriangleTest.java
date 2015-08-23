package codewars;

import org.testng.annotations.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Chethan on 8/21/15.
 */
public class PascalsTriangleTest {

    @Test
    public void test1() {
        assertArrayEquals( "Depth 1 should return [ [1] ]",
                new int[][] { {1} },
                new PascalsTriangle().pascal(1));
    }

    @Test
    public void test5() {
        assertArrayEquals("Depth 5 should return [ [1], [1,1], [1,2,1], [1,3,3,1], [1,4,6,4,1] ]",
                new int[][]{{1}, {1, 1}, {1, 2, 1}, {1, 3, 3, 1}, {1, 4, 6, 4, 1}},
                new PascalsTriangle().pascal(5));
    }
}