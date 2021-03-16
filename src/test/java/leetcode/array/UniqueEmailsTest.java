package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class UniqueEmailsTest {

    @Test
    public void testUniqueEmails() {
        UniqueEmails uniqueEmails = new UniqueEmails();
        assertThat(uniqueEmails.numUniqueEmails(
            new String[]{"test.email+alex@leetcode.com", "test.e.mail+bob.cathy@leetcode.com",
                "testemail+david@lee.tcode.com"})).isEqualTo(2);
    }
}