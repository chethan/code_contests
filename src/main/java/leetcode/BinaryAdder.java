package leetcode;

/**
 * Created by Chethan on 9/18/16.
 */
//https://leetcode.com/problems/add-binary/
public class BinaryAdder {
    public String addBinary(String a, String b) {
        if (a == null) a = "";
        if (b == null) b = "";
        StringBuilder sumBuilder = new StringBuilder();
        int carry = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int partA = i < 0 ? 0 : a.charAt(i) - '0';
            int partB = j < 0 ? 0 : b.charAt(j) - '0';
            int partSum = carry + partA + partB;
            carry = 0;
            if (partSum > 1) carry = 1;
            sumBuilder.append(partSum % 2 == 1 ? '1' : '0');
        }
        if (carry == 1) sumBuilder.append('1');
        return sumBuilder.reverse().toString();
    }
}
