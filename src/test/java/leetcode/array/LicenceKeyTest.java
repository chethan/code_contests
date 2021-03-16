package leetcode.array;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class LicenceKeyTest {

    @Test
    public void testLicenseKeyFormatting() {
        LicenceKey licenceKey = new LicenceKey();
        assertThat(licenceKey.licenseKeyFormatting("--a-a-a-a-", 2)).isEqualTo("AA-AA");
        assertThat(licenceKey.licenseKeyFormatting("2-5g-3-J", 2)).isEqualTo("2-5G-3J");
    }
}