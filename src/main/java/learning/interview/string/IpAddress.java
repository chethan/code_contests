package learning.interview.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

class IpAddress {

    //https://leetcode.com/problems/validate-ip-address/
    String validIPAddress(String IP) {
        if (IP == null || IP.length() == 0) return "Neither";
        if (IP.contains(".")) {
            String[] parts = IP.split("\\.");
            return (parts.length == 4 && !IP.endsWith(".")) && Arrays.stream(parts).allMatch(this::isValidPart) ? "IPv4" : "Neither";
        }
        return isValidIpV6(IP) ? "IPv6" : "Neither";

    }

    //https://leetcode.com/problems/restore-ip-addresses/
    List<String> restoreIpAddresses(String s) {
        if (s == null || (s.length() < 4 || s.length() > 12)) return new ArrayList<>();
        return restoreIpAddresses(s, 0);
    }

    private List<String> restoreIpAddresses(String s, int depth) {
        List<String> result = new ArrayList<>();
        if (depth == 3) {
            if (isValidPart(s)) result.add(s);
            return result;
        }

        for (int i = 0; i < 3 && i < s.length(); i++) {
            String currentPart = s.substring(0, i + 1);

            if (isValidPart(currentPart)) {
                List<String> parts = restoreIpAddresses(s.substring(i + 1), depth + 1);
                for (String part : parts) {
                    result.add(currentPart + '.' + part);
                }
            }
        }
        return result;
    }


    private boolean isValidIpV6(String IP) {
        String[] parts = IP.split(":");
        if (parts.length != 8 || IP.endsWith(":")) {
            return false;
        }
        for (String part : parts) {
            if (part.length() < 1 || part.length() > 4) return false;
            for (char c : part.toCharArray()) {
                if ((c - 'a' < 0 || c - 'a' > 5) && (c - 'A' < 0 || c - 'A' > 5) && (c - '0' < 0 || c - '0' > 9)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean isValidPart(String part) {
        try {
            int isInteger = Integer.parseInt(part);
            boolean isWithInRange = part.length() < 4 && part.length() > 0 && !part.startsWith("-") && isInteger < 256;
            return isWithInRange && (part.charAt(0) != '0' || part.length() == 1);
        } catch (NumberFormatException e) {
            return false;
        }

    }

}
