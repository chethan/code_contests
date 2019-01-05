package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class CountAndSayTest {

    @Test
    public void testGenerate() {
        CountAndSay countAndSay = new CountAndSay();
        assertThat(countAndSay.generate(4)).isEqualTo("1211");
        assertThat(countAndSay.generate(5)).isEqualTo("111221");
        assertThat(countAndSay.generate(6)).isEqualTo("312211");
        assertThat(countAndSay.generate(1)).isEqualTo("1");
    }
}