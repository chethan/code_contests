package codewars;

/**
 * Created by Chethan on 8/26/16.
 */
public class Scramblies {
    public static boolean isScramblie(String str1, String str2) {
        char[] str1Chars = str1.toCharArray();
        return str2.chars().mapToObj(i -> (char) i).allMatch(value -> {
            for (int i = 0; i < str1Chars.length; i++) {
                Character str1Char = str1Chars[i];
                if (str1Char == value) {
                    str1Chars[i] = ',';
                    return true;
                }
            }
            return false;
        });
    }
}
