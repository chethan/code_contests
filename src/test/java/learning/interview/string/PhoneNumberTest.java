package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class PhoneNumberTest {

    @Test
    public void testLetterCombinations() {
        PhoneNumber phoneNumber = new PhoneNumber();
        assertThat(phoneNumber.letterCombinations("1")).containsExactly();
        assertThat(phoneNumber.letterCombinations("2")).containsExactly("a", "b", "c");
        assertThat(phoneNumber.letterCombinations("23")).containsExactly("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    }

    @Test
    public void testLetterCombinationsIterative() {
        PhoneNumber phoneNumber = new PhoneNumber();
        assertThat(phoneNumber.letterCombinationsIterative("2")).containsOnly("a", "b", "c");
        assertThat(phoneNumber.letterCombinationsIterative("23")).containsOnly("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf");
    }
}