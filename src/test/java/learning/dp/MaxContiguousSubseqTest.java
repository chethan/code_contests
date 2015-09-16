package learning.dp;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/15/15.
 */
public class MaxContiguousSubseqTest {

    @Test
    public void testFindMax() throws Exception {
        MaxContiguousSubseq mvcs = new MaxContiguousSubseq();
        assertThat(mvcs.findMax(Arrays.asList(10, 22, 9, 33, 21, 50, 41, 60, 80), Optional.<Integer>empty())).isEqualTo(20);
    }
}