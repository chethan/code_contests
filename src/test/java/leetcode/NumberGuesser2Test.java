package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/18/16.
 */
public class NumberGuesser2Test {

    @Test
    public void testGetMoneyAmount() throws Exception {
        NumberGuesser2 numberGuesser2 = new NumberGuesser2();
//        assertThat(numberGuesser2.getMoneyAmount(10)).isEqualTo(22);
        assertThat(numberGuesser2.getMoneyAmount(4)).isEqualTo(4);
        assertThat(numberGuesser2.getMoneyAmount(3)).isEqualTo(2);
        assertThat(numberGuesser2.getMoneyAmount(2)).isEqualTo(1);
        assertThat(numberGuesser2.getMoneyAmount(5)).isEqualTo(6);
    }
}
