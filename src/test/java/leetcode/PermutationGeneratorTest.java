package leetcode;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/19/16.
 */
public class PermutationGeneratorTest {

    @Test
    public void testPermute() throws Exception {
        PermutationGenerator permutationGenerator = new PermutationGenerator();
        assertThat(permutationGenerator.permute(new int[]{1, 2, 3})).isEqualTo(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        ));
        assertThat(permutationGenerator.permute(new int[]{1})).isEqualTo(Arrays.asList(
                Arrays.asList(1)
        ));
        assertThat(permutationGenerator.permute(new int[]{})).isEqualTo(new ArrayList<>());
    }
}
