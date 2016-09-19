package leetcode;

import org.testng.annotations.Test;

import static org.assertj.core.api.StrictAssertions.assertThat;

/**
 * Created by Chethan on 9/18/16.
 */
public class BadVersionFinderTest {

    @Test
    public void testFirstBadVersion() throws Exception {
        assertThat(getBadVersionFinderFor(5).firstBadVersion(10)).isEqualTo(5);
        assertThat(getBadVersionFinderFor(3).firstBadVersion(10)).isEqualTo(3);
        assertThat(getBadVersionFinderFor(1).firstBadVersion(10)).isEqualTo(1);
        assertThat(getBadVersionFinderFor(10).firstBadVersion(10)).isEqualTo(10);
        assertThat(getBadVersionFinderFor(12).firstBadVersion(10)).isEqualTo(11);
    }

    private BadVersionFinder getBadVersionFinderFor(int i) {
        return new BadVersionFinder() {
            @Override
            boolean isBadVersion(int version) {
                return version >= i;
            }
        };
    }
}
