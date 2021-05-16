package leetcode.graph;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class JumpingNumbersTest {

    @Test
    public void testNumsSameConsecDiff() {
        JumpingNumbers jumpingNumbers = new JumpingNumbers();
        assertThat(jumpingNumbers.numsSameConsecDiff(3, 7)).containsExactly(181, 292, 707, 818, 929);
    }
}