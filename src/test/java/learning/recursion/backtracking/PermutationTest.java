package learning.recursion.backtracking;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Created by Chethan on 8/23/15.
 */
public class PermutationTest {

    @Test
    public void shouldGeneratePermutations(){
        assertThat(new Permutation().permute("abc")).containsExactly("abc","acb","bac","bca","cab","cba");
        assertThat(new Permutation().permute("")).containsExactly("");
    }

}