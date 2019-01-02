package learning.interview.numbers;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class DIStringTest {

    @Test
    public void testDiStringMatch() {
        DIString diString = new DIString();
        assertThat(diString.diStringMatch("IDID")).containsExactly(0, 2, 1, 4, 3);
        assertThat(diString.diStringMatch("III")).containsExactly(0, 1, 2, 3);
        assertThat(diString.diStringMatch("DDI")).containsExactly(2, 1, 0, 3);
    }
    @Test
    public void testDiStringMatchSmart() {
        DIString diString = new DIString();
        assertThat(diString.diStringMatchSmart("IDID")).containsExactly(0, 4, 1, 3, 2);
        assertThat(diString.diStringMatchSmart("III")).containsExactly(0, 1, 2, 3);
        assertThat(diString.diStringMatchSmart("DDI")).containsExactly(3, 2, 0, 1);
    }
}