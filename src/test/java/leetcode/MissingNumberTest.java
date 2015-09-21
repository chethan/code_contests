package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 9/20/15.
 */
public class MissingNumberTest {

    @Test
    public void testMissingNumber() throws Exception {
        MissingNumber missingNumber = new MissingNumber();
        assertThat(missingNumber.missingNumber(new int[]{0, 1, 3})).isEqualTo(2);
        assertThat(missingNumber.firstMissingPositive(new int[]{3, 4, -1, 1})).isEqualTo(2);
        assertThat(missingNumber.firstMissingPositive(new int[]{1, 2, 0})).isEqualTo(3);
        assertThat(missingNumber.firstMissingPositive(new int[]{1, 2, 1, 1, 1})).isEqualTo(3);
        assertThat(missingNumber.firstMissingPositive(new int[]{-1,4,2,1,9,10})).isEqualTo(3);
    }


}
