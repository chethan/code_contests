package learning.interview.numbers;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class FactorialTest {

    @Test
    public void testTrailingZeroes() {
        Factorial factorial = new Factorial();
        assertThat(factorial.trailingZeroes(4617)).isEqualTo(1151);
        assertThat(factorial.trailingZeroes(30)).isEqualTo(7);
        assertThat(factorial.trailingZeroes(1808548329)).isEqualTo(452137076);

    }
}