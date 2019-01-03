package learning.interview.arrays;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/19/16.
 */
public class PermutationsTest {

    @Test
    public void testPermute() {
        Permutations permutations = new Permutations();
        assertThat(permutations.permute(new int[]{1, 2, 3})).isEqualTo(Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3, 2),
                Arrays.asList(2, 1, 3),
                Arrays.asList(2, 3, 1),
                Arrays.asList(3, 1, 2),
                Arrays.asList(3, 2, 1)
        ));
        assertThat(permutations.permute(new int[]{1})).isEqualTo(Arrays.asList(
                Arrays.asList(1)
        ));
        assertThat(permutations.permute(new int[]{})).isEqualTo(new ArrayList<>());
    }

    @Test
    public void shouldGenerateNextPermutation() {
        Permutations permutations = new Permutations();
        assertThat(permutations.nextPermutation(new int[]{6, 2, 1, 5, 4, 3, 0}))
                .containsExactly(6, 2, 3, 0, 1, 4, 5);
        assertThat(permutations.nextPermutation(new int[]{6, 2, 1, 5, 4, 0, 3}))
                .containsExactly(6, 2, 1, 5, 4, 3, 0);
        assertThat(permutations.nextPermutation(new int[]{1, 2, 3}))
                .containsExactly(1, 3, 2);
        assertThat(permutations.nextPermutation(new int[]{1, 3, 2}))
                .containsExactly(2, 1, 3);
        assertThat(permutations.nextPermutation(new int[]{3, 2, 1}))
                .containsExactly(1, 2, 3);
        assertThat(permutations.nextPermutation(new int[]{1, 1, 5}))
                .containsExactly(1, 5, 1);
        assertThat(permutations.nextPermutation(new int[]{1, 5, 1}))
                .containsExactly(5, 1, 1);
        assertThat(permutations.nextPermutation(new int[]{5, 5}))
                .containsExactly(5, 5);
    }
    @Test
    public void shouldGeneratePreviousPermutation() {
        Permutations permutations = new Permutations();
        assertThat(permutations.previousPermutation(new int[]{6, 2, 3, 0, 1, 4, 5}))
                .containsExactly(6, 2, 1, 5, 4, 3, 0);
        assertThat(permutations.previousPermutation(new int[]{6, 2, 1, 5, 4, 3, 0}))
                .containsExactly(6, 2, 1, 5, 4, 0, 3);
        assertThat(permutations.previousPermutation(new int[]{5, 1,1}))
                .containsExactly(1, 5, 1);
        assertThat(permutations.previousPermutation(new int[]{5, 5}))
                .containsExactly(5, 5);
    }
}
