package codewars;

/**
 * Created by Chethan on 8/12/15.
 */
public class JadenCase {
    public String toJadenCase(String phrase) {
        if (phrase == null || phrase.isEmpty()) return phrase;
        char[] charArray = phrase.toCharArray();
        boolean firstCharacterOfWord = true;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            charArray[i] = firstCharacterOfWord ? Character.toUpperCase(c) : c;
            firstCharacterOfWord = Character.isSpaceChar(c);
        }
        return new String(charArray);
    }

}
