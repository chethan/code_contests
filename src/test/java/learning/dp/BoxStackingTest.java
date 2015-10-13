package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/13/15.
 */
public class BoxStackingTest {

    @Test
    public void testMaxHeight() throws Exception {
        BoxStacking boxStacking = new BoxStacking();
        assertThat(boxStacking.maxHeight(new int[][]{ {4, 6, 7}, {1, 2, 3}, {4, 5, 6}, {10, 12, 32} })).isEqualTo(60);
    }
}
