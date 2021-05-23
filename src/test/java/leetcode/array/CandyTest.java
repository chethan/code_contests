package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class CandyTest {

    @Test
    public void testTotalCandy() {
        Candy candy = new Candy();
        assertThat(candy.candy(new int[]{1,2,2})).isEqualTo(4);
        assertThat(candy.candy(new int[]{1,0,2})).isEqualTo(5);
    }
}