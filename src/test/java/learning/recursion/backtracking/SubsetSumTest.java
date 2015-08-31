package learning.recursion.backtracking;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * Created by Chethan on 8/24/15.
 */
public class SubsetSumTest {
    @Test
    public void shouldFindSubset(){
        System.out.println(new SubsetSum().findSubset(Arrays.asList(15, 22, 14, 26, 32, 9, 16, 8), 53));
    }

}