package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/19/15.
 */
public class SingleNumberTest {

    @Test
    public void testSingleNumber() throws Exception {
        SingleNumber singleNumber = new SingleNumber();
        assertThat(singleNumber.singleNumberOne(new int[]{1, 2, 1, 3, 2})).isEqualTo(3);
        assertThat(singleNumber.singleNumberTwo(new int[]{1, 2, 1, 3, 2,2,1})).isEqualTo(3);
        assertThat(singleNumber.singleNumberThree(new int[]{1, 2, 1, 3, 2,5})).contains(3,5);
    }
}
