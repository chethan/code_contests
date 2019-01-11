package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class RansomNoteTest {

    @Test
    public void testCanConstruct() {
        RansomNote ransomNote = new RansomNote();
        assertThat(ransomNote.canConstruct("a","b")).isFalse();
        assertThat(ransomNote.canConstruct("aa","a")).isFalse();
        assertThat(ransomNote.canConstruct("aa","aba")).isTrue();
    }
}