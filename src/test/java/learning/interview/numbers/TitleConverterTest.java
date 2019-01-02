package learning.interview.numbers;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class TitleConverterTest {

    @Test
    public void testConvertToTitle() {
        TitleConverter titleConverter = new TitleConverter();
        assertThat(titleConverter.convertToTitle(27)).isEqualTo("AA");
        assertThat(titleConverter.convertToTitle(28)).isEqualTo("AB");
        assertThat(titleConverter.convertToTitle(2)).isEqualTo("B");
        assertThat(titleConverter.convertToTitle(26)).isEqualTo("Z");
        assertThat(titleConverter.convertToTitle(52)).isEqualTo("AZ");
        assertThat(titleConverter.convertToTitle(53)).isEqualTo("BA");
    }

    @Test
    public void testConvertToColumnNumber() {
        TitleConverter titleConverter = new TitleConverter();
        assertThat(titleConverter.titleToNumber("AA")).isEqualTo(27);
        assertThat(titleConverter.titleToNumber("AB")).isEqualTo(28);
        assertThat(titleConverter.titleToNumber("B")).isEqualTo(2);
        assertThat(titleConverter.titleToNumber("Z")).isEqualTo(26);
        assertThat(titleConverter.titleToNumber("AZ")).isEqualTo(52);
        assertThat(titleConverter.titleToNumber("BA")).isEqualTo(53);
    }
}