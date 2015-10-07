package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/6/15.
 */
public class LongestCommonSubsequenceTest {

    @Test
    public void testFindLCS() throws Exception {
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        assertThat(lcs.findLCS("ABCDGH","AEDFHR")).isEqualTo(3);
        assertThat(lcs.findLCS("AGGTAB","GXTXAYB")).isEqualTo(4);
        assertThat(lcs.findLCS("lovxxelyxxxxx","xxxxxxxlovely")).isEqualTo(7);
    }
}
