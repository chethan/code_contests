package leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;
import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/18/16.
 */
public class CombinationsGeneratorTest {

    @Test
    public void testCombine() throws Exception {
        CombinationsGenerator combinationsGenerator = new CombinationsGenerator();
        assertThat(combinationsGenerator.combine(4, 2)).isEqualTo(new ArrayList<>(
                Arrays.asList(
                        asList(1, 2), asList(1, 3), asList(1, 4),
                        asList(2, 3), asList(2, 4),
                        asList(3, 4))
        ));
        assertThat(combinationsGenerator.combine(4, 4)).isEqualTo(new ArrayList<>(
                Arrays.asList(asList(1, 2, 3, 4))
        ));
        assertThat(combinationsGenerator.combine(4, 0)).isEqualTo(new ArrayList<>());
        assertThat(combinationsGenerator.combine(4, 1)).isEqualTo(new ArrayList<>(
                Arrays.asList( asList(1), asList(2), asList(3), asList(4))
        ));
    }
}
