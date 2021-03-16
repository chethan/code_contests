package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class BackspaceCompareTest {

    @Test
    public void testBackspaceCompare() {
        BackspaceCompare backspaceCompare = new BackspaceCompare();
        assertThat(backspaceCompare.backspaceCompare("ab#c", "ad#c")).isTrue();
        assertThat(backspaceCompare.backspaceCompare("xywrrmp", "xywrrmu#p")).isTrue();
        assertThat(backspaceCompare.backspaceCompare("####", "")).isTrue();
    }
}

