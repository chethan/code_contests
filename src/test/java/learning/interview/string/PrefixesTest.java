package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class PrefixesTest {

    @Test
    public void testLongestCommonPrefix() {
        Prefixes prefixes = new Prefixes();
        assertThat(prefixes.longestCommonPrefix(new String[]{"flower", "flow", "flight"})).isEqualTo("fl");
        assertThat(prefixes.longestCommonPrefix(new String[]{"dog", "racecar", "car"})).isEqualTo("");


    }
}