package learning.interview.bitwise;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ParityCalculatorTest {
    @Test
    public void shouldCheckParity() {
        ParityCalculator parityCalculator = new ParityCalculator();
        assertThat(parityCalculator.parity(0)).isEqualTo(0);
        assertThat(parityCalculator.parity(1)).isEqualTo(1);
        assertThat(parityCalculator.parity(Integer.MIN_VALUE)).isEqualTo(1);
        assertThat(parityCalculator.parity(Integer.MAX_VALUE)).isEqualTo(1);
    }
}