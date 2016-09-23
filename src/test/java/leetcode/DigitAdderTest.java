package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/23/16.
 */
public class DigitAdderTest {

    @Test
    public void testAddDigits() throws Exception {
        DigitAdder digitAdder = new DigitAdder();
        assertThat(digitAdder.addDigits(38)).isEqualTo(2);
        assertThat(digitAdder.addDigits(187638)).isEqualTo(6);
    }
}
