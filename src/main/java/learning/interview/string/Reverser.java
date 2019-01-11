package learning.interview.string;

class Reverser {

    //https://leetcode.com/problems/reverse-string-iii/
    String reverseWords(String s) {
        char[] input = s.toCharArray();
        int fromIndex = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == ' ') {
                reverseString(input, fromIndex, i);
                fromIndex = i + 1;
            }
        }
        if (fromIndex < input.length) {
            reverseString(input, fromIndex, input.length);
        }
        return new String(input);
    }

    //https://leetcode.com/problems/reverse-string
    String reverseString(String s) {
        char[] input = s.toCharArray();
        reverseString(input, 0, input.length);
        return new String(input);
    }

    //https://leetcode.com/problems/reverse-words-in-a-string
    String reverseWordOrder(String s) {
        char[] input = s.toCharArray();
        reverseString(input, 0, input.length);
        reverseWords(input);


        StringBuilder reversedString = new StringBuilder();
        boolean firstSpace = false;
        for (char c : input) {
            if (c == ' ' && (reversedString.length() != 0 && !firstSpace)) {
                firstSpace = true;
            }
            if (c != ' ') {
                reversedString.append(firstSpace ? " " : "").append(c);
                firstSpace = false;
            }
        }
        return reversedString.toString();

    }

    //https://leetcode.com/problems/reverse-vowels-of-a-string/
    String reverseVowels(String s) {
        if (s == null || s.length() == 0) return s;
        char[] chars = s.toCharArray();
        for (int i = 0, j = chars.length - 1; i < j; ) {
            if ("aeiou".indexOf(Character.toLowerCase(chars[i])) == -1) {
                i++;
                continue;
            }
            if ("aeiou".indexOf(Character.toLowerCase(chars[j])) == -1) {
                j--;
                continue;
            }
            char temp = chars[i];
            chars[i++] = chars[j];
            chars[j--] = temp;
        }
        return new String(chars);
    }


    private void reverseString(char[] s, int from, int to) {
        for (int i = from, j = to - 1; i < j; i++, j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }
    }

    private void reverseWords(char[] s) {
        int fromIndex = 0;
        for (int i = 0; i < s.length; i++) {
            if (s[i] == ' ') {
                reverseString(s, fromIndex, i);
                fromIndex = i + 1;
            }
        }
        if (fromIndex < s.length) {
            reverseString(s, fromIndex, s.length);
        }
    }
}
