package learning.recursion.backtracking;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 8/24/15.
 */
public class SubsetsTest {
    @Test
    public void shouldFindSubset(){
        System.out.println(new Subsets().findSubsetMatchingSum(Arrays.asList(15, 22, 14, 26, 32, 9, 16, 8), 53));
        System.out.println(new Subsets().findSubsetMatchingSum(Arrays.asList(3, 34, 4, 12, 5, 2), 9));
    }

    @Test
    public void shouldGenerateAllSubstes(){
        List<List<Integer>> subsets = new Subsets().generateSubsets(Arrays.asList(15, 22, 14, 26, 32, 9, 16, 8));
        assertThat(subsets).hasSize((int) Math.pow(2,8));
        System.out.println(subsets);
    }

}
