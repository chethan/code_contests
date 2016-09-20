package leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Chethan on 9/19/16.
 */
public class SubsetGeneratorTest {

    @Test
    public void testSubsets() throws Exception {
        SubsetGenerator subsetGenerator = new SubsetGenerator();
        assertThat(subsetGenerator.subsets(new int[]{1, 2, 3})).contains(
                Arrays.asList(),
                Arrays.asList(3),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2, 3)
        );
    }
}
