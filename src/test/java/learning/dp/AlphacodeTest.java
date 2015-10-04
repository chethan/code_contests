package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/3/15.
 */
public class AlphacodeTest {

    @Test
    public void testTotalDecodings() throws Exception {
        Alphacode alphacode = new Alphacode();
        assertThat(alphacode.totalDecodings(new int[]{2,5,1,1,4})).isEqualTo(6);
        assertThat(alphacode.totalDecodings(new int[]{1,1,1,1,1,1,1,1,1,1})).isEqualTo(89);
        assertThat(alphacode.totalDecodings(new int[]{3,3,3,3,3,3,3,3,3,3})).isEqualTo(1);
        assertThat(alphacode.totalDecodings(new int[]{1,1,0})).isEqualTo(1);
        assertThat(alphacode.totalDecodings(new int[]{1,0,0})).isEqualTo(0);
        assertThat(alphacode.totalDecodings(new int[]{1,0,0,0})).isEqualTo(0);
        assertThat(alphacode.totalDecodings(new int[]{1,0,2,4})).isEqualTo(2);
        assertThat(alphacode.totalDecodings(new int[]{1,0,2,0})).isEqualTo(1);

    }
}
