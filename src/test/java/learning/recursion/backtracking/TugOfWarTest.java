package learning.recursion.backtracking;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Chethan on 9/19/15.
 */
public class TugOfWarTest {

    @Test
    public void testBestSplit() throws Exception {
        TugOfWar tugOfWar = new TugOfWar();

        Map.Entry<List<Integer>, List<Integer>> entry = tugOfWar.bestSplit(Arrays.asList(3, 4, 5, -3, 100, 1, 89, 54, 23, 20));
        assertThat(entry.getKey()).containsOnly(3, 5, -3, 89, 54);
        assertThat(entry.getValue()).containsOnly(4, 100, 1, 23, 20);

        entry = tugOfWar.bestSplit(Arrays.asList(23, 45, -34, 12, 0, 98, -99, 4, 189, -1, 4));
        assertThat(entry.getKey()).containsOnly(23, -99, 4, 189, 4);
        assertThat(entry.getValue()).containsOnly(45, -34, 12, 0, 98, -1);
    }
}
