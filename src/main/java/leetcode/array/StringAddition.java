package leetcode.array;

//https://leetcode.com/problems/add-strings/
public class StringAddition {

    public String addStrings(String num1, String num2) {
        int maxLen = Math.max(num1.length(), num2.length()), carry = 0;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < maxLen; i++) {
            int index1 = num1.length() - 1 - i;
            int index2 = num2.length() - 1 - i;
            int first = index1 < 0 ? 0 : num1.charAt(index1) - '0';
            int second = index2 < 0 ? 0 : num2.charAt(index2) - '0';
            int sum = first + second + carry;
            carry = sum / 10;
            result.append(sum % 10);
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse().toString();
    }
}
