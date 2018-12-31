package codewars;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/10/16.
 */
public class DoubleLinearTest {

    @Test
    public void testDblLinear() throws Exception {
        assertThat(DoubleLinear.dblLinear(10)).isEqualTo(22);
        assertThat(DoubleLinear.dblLinear(20)).isEqualTo(57);
        assertThat(DoubleLinear.dblLinear(30)).isEqualTo(91);
        assertThat(DoubleLinear.dblLinear(50)).isEqualTo(175);
    }
}
