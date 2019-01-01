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
}