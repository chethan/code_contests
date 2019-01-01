package learning.interview.bitwise;

class DecimalToHexConverter {

    //https://leetcode.com/problems/convert-a-number-to-hexadecima
    String toHex(int num) {
        char[] hexArray = new char[]{'a', 'b', 'c', 'd', 'e', 'f'};
        StringBuilder hexValue = new StringBuilder();
        if (num == 0) return "0";
        for (; num != 0; num >>>= 4) {
            int nibble = num & 0xf;
            if (nibble > 9) {
                hexValue.append(hexArray[nibble % 10]);
            } else {
                hexValue.append(nibble);
            }
        }
        return hexValue.reverse().toString();
    }
}
