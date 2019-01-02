package learning.interview.numbers;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class SelfDividingNumbersTest {

    @Test
    public void testSelfDividingNumbers() {
        SelfDividingNumbers selfDividingNumbers = new SelfDividingNumbers();
        assertThat(selfDividingNumbers.selfDividingNumbers(1,2)).containsExactly(1,2);
        assertThat(selfDividingNumbers.selfDividingNumbers(1,22)).containsExactly(1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22);
    }
}