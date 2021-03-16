package leetcode.array;

//https://leetcode.com/problems/license-key-formatting/
public class LicenceKey {

    public String licenseKeyFormatting(String S, int K) {
        StringBuilder result = new StringBuilder();
        int counter = 0;
        for (int i = S.length() - 1; i >= 0; i--) {
            char current = S.charAt(i);
            if (current == '-') {
                continue;
            }
            if (counter == K) {
                result.insert(0, "-");
                counter = 0;
            }
            counter++;
            result.insert(0, Character.toUpperCase(current));
        }
        return result.toString();
    }
}
