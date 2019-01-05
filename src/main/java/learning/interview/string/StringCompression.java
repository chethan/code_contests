package learning.interview.string;

class StringCompression {
    //https://leetcode.com/problems/string-compression/
    int compress(char[] chars) {
        int writeIndex = 1, currentCount = 0;
        if (chars.length == 1) return 1;
        for (int i = 0; i < chars.length; i++) {
            if (chars[writeIndex - 1] == chars[i]) {
                currentCount++;
            } else {

                writeIndex = updateCount(chars, writeIndex, currentCount);
                chars[writeIndex++] = chars[i];
                currentCount = 1;
            }
        }
        writeIndex = updateCount(chars, writeIndex, currentCount);
        return writeIndex;
    }

    private int updateCount(char[] chars, int writeIndex, int currentCount) {
        if (currentCount == 1) return writeIndex;
        char[] asChars = (currentCount + "").toCharArray();
        for (char asChar : asChars) {
            chars[writeIndex++] = asChar;
        }
        return writeIndex;
    }

}
