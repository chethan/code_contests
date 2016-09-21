package leetcode;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/20/16.
 */
public class SubsetGenerator2Test {

    @Test
    public void testSubsetsWithDup() throws Exception {
        SubsetGenerator2 subsetGenerator = new SubsetGenerator2();
        assertThat(subsetGenerator.subsetsWithDup(new int[]{1, 2, 2})).contains(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(2),
                Arrays.asList(1, 2),
                Arrays.asList(2, 2),
                Arrays.asList(1, 2, 2)
        );
        assertThat(subsetGenerator.subsetsWithDup(new int[]{4, 4, 4, 1, 4})).contains(
                Arrays.asList(),
                Arrays.asList(1),
                Arrays.asList(4),
                Arrays.asList(1, 4),
                Arrays.asList(1, 4,4),
                Arrays.asList(1, 4, 4,4),
                Arrays.asList(1, 4, 4,4,4),
                Arrays.asList(4, 4,4,4),
                Arrays.asList(4,4,4),
                Arrays.asList(4,4),
                Arrays.asList(4)
        );

    }
}
