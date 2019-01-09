package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class IpAddressTest {

    @Test
    public void testRestoreIpAddresses() {
        IpAddress ipAddress = new IpAddress();
        assertThat(ipAddress.restoreIpAddresses("010010")).containsExactly("0.10.0.10", "0.100.1.0");
        assertThat(ipAddress.restoreIpAddresses("1111")).containsExactly("1.1.1.1");
        assertThat(ipAddress.restoreIpAddresses("25525511135")).containsExactly("255.255.11.135", "255.255.111.35");
        assertThat(ipAddress.restoreIpAddresses("25525511139995")).containsExactly();
        assertThat(ipAddress.restoreIpAddresses("255")).containsExactly();
        assertThat(ipAddress.restoreIpAddresses("2222222222")).containsExactly("2.222.222.222",
                "22.22.222.222",
                "22.222.22.222",
                "22.222.222.22",
                "222.2.222.222",
                "222.22.22.222",
                "222.22.222.22",
                "222.222.2.222",
                "222.222.22.22",
                "222.222.222.2");
    }

    @Test
    public void testValidIPAddress() {
        IpAddress ipAddress = new IpAddress();
        assertThat(ipAddress.validIPAddress("2.222.222.222")).isEqualTo("IPv4");
        assertThat(ipAddress.validIPAddress("0.0.0.-1")).isEqualTo("Neither");
        assertThat(ipAddress.validIPAddress("0.0.0.-0")).isEqualTo("Neither");
        assertThat(ipAddress.validIPAddress("2.222.222.222.")).isEqualTo("Neither");
        assertThat(ipAddress.validIPAddress("256.256.256.256")).isEqualTo("Neither");
        assertThat(ipAddress.validIPAddress("2001:0db8:85a3:0000:0000:8a2e:0370:7334")).isEqualTo("IPv6");
        assertThat(ipAddress.validIPAddress("2001:db8:85a3:0:0:8A2E:0370:7334")).isEqualTo("IPv6");
        assertThat(ipAddress.validIPAddress("2001:0db8:85a3::8A2E:0370:7334")).isEqualTo("Neither");
        assertThat(ipAddress.validIPAddress("02001:0db8:85a3:0000:0000:8a2e:0370:7334")).isEqualTo("Neither");
        assertThat(ipAddress.validIPAddress("2001:0db8:85a3:0:0:8A2E:0370:7334:")).isEqualTo("Neither");
    }
}