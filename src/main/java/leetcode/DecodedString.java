package leetcode;

//https://leetcode.com/problems/decode-string/
public class DecodedString {

    public String decodeString(String s) {
        return decodeStringHelper(s, 0).getKey();
    }

    Pair<String, Integer> decodeStringHelper(String s, int index) {
        StringBuilder result = new StringBuilder();
        while (index < s.length() && s.charAt(index) != ']') {
            if (!Character.isDigit(s.charAt(index))) {
                result.append(s.charAt(index));
                index++;
            } else {
                int k = 0;
                while (index < s.length() && Character.isDigit(s.charAt(index))) {
                    k = k * 10 + s.charAt(index++) - '0';
                }
                index++;
                Pair<String, Integer> decoded = decodeStringHelper(s, index);
                index = decoded.getValue();
                index++;
                while (k > 0) {
                    result.append(decoded.getKey());
                    k--;
                }
            }
        }
        return new Pair<>(result.toString(), index);
    }
}
