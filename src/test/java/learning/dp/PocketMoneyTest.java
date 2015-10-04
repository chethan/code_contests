package learning.dp;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 10/4/15.
 */
public class PocketMoneyTest {

    @Test
    public void testMaximumValue() throws Exception {
        PocketMoney pocketMoney = new PocketMoney();
        assertThat(pocketMoney.maximumValue("1+2*3+4*5")).isEqualTo("105 29");
        assertThat(pocketMoney.maximumValue("2+1*0*1+1")).isEqualTo("4 3");
    }
}
