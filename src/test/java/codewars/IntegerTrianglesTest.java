package codewars;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/10/16.
 */
public class IntegerTrianglesTest {

    @Test
    public void testGetTriangles() throws Exception {
        int[] perimeters = new int[]{5, 15, 30, 50, 80, 90, 100, 150, 180, 190};
        int[] results = new int[]{0, 1, 3, 5, 11, 13, 14, 25, 32, 35};
        for (int i = 0; i < perimeters.length; i++) {
            assertThat(IntegerTriangles.getTriangles(perimeters[i])).isEqualTo(results[i]);
        }
    }
}
