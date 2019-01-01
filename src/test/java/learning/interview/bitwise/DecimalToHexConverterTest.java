package learning.interview.bitwise;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class DecimalToHexConverterTest {

    @Test
    public void testToHex() {
        DecimalToHexConverter decimalToHexConverter  = new DecimalToHexConverter();
        assertThat(decimalToHexConverter.toHex(-1)).isEqualTo("ffffffff");
        assertThat(decimalToHexConverter.toHex(0)).isEqualTo("0");
        assertThat(decimalToHexConverter.toHex(26)).isEqualTo("1a");
        assertThat(decimalToHexConverter.toHex(16)).isEqualTo("10");
    }
}