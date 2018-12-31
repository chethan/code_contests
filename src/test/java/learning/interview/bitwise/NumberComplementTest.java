package learning.interview.bitwise;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class NumberComplementTest {

    @Test
    public void testFindComplement() {
        NumberComplement numberComplement = new NumberComplement();
        assertThat(numberComplement.findComplement(6)).isEqualTo(1);
        assertThat(numberComplement.findComplement(5)).isEqualTo(2);
        assertThat(numberComplement.findComplement(1)).isEqualTo(0);
    }
}