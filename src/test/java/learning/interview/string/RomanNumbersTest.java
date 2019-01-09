package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class RomanNumbersTest {

    @Test
    public void testRomanToInt() {
        RomanNumbers romanNumbers = new RomanNumbers();
        assertThat(romanNumbers.romanToInt("LVIII")).isEqualTo(58);
        assertThat(romanNumbers.romanToInt("IIII")).isEqualTo(4);
        assertThat(romanNumbers.romanToInt("IV")).isEqualTo(4);
        assertThat(romanNumbers.romanToInt("XLVIII")).isEqualTo(48);
        assertThat(romanNumbers.romanToInt("CMLVIII")).isEqualTo(958);
        assertThat(romanNumbers.romanToInt("CDIX")).isEqualTo(409);
        assertThat(romanNumbers.romanToInt("MCMXCIV")).isEqualTo(1994);
        assertThat(romanNumbers.romanToInt("DCXXI")).isEqualTo(621);
    }

    @Test
    public void testIntToRoman() {
        RomanNumbers romanNumbers = new RomanNumbers();
        assertThat(romanNumbers.intToRoman(58)).isEqualTo("LVIII");
        assertThat(romanNumbers.intToRoman(4)).isEqualTo("IV");
        assertThat(romanNumbers.intToRoman(48)).isEqualTo("XLVIII");
        assertThat(romanNumbers.intToRoman(958)).isEqualTo("CMLVIII");
        assertThat(romanNumbers.intToRoman(409)).isEqualTo("CDIX");
        assertThat(romanNumbers.intToRoman(1994)).isEqualTo("MCMXCIV");
        assertThat(romanNumbers.intToRoman(621)).isEqualTo("DCXXI");
    }
}