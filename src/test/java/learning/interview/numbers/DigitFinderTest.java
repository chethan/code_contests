package learning.interview.numbers;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class DigitFinderTest {

    @Test
    public void testFindNthDigit() {
        DigitFinder digitFinder = new DigitFinder();
        assertThat(digitFinder.findNthDigit(3)).isEqualTo(3);
        assertThat(digitFinder.findNthDigit(13)).isEqualTo(1);
        assertThat(digitFinder.findNthDigit(10)).isEqualTo(1);
        assertThat(digitFinder.findNthDigit(11)).isEqualTo(0);
        assertThat(digitFinder.findNthDigit(190)).isEqualTo(1);
    }
    @Test
    public void testcountDigitOne() {
        DigitFinder digitFinder = new DigitFinder();
        assertThat(digitFinder.countDigitOne(-1)).isEqualTo(0);
        assertThat(digitFinder.countDigitOne(120)).isEqualTo(53);
        assertThat(digitFinder.countDigitOne(1)).isEqualTo(1);
        assertThat(digitFinder.countDigitOne(0)).isEqualTo(0);
        assertThat(digitFinder.countDigitOne(119)).isEqualTo(52);
        assertThat(digitFinder.countDigitOne(399)).isEqualTo(180);
        assertThat(digitFinder.countDigitOne(3799)).isEqualTo(2160);
        assertThat(digitFinder.countDigitOne(824883294)).isEqualTo(767944060);
    }
}