package learning.interview.string;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class PalindromesTest {

    @Test
    public void testShortestPalindrome() {
        Palindromes palindromes = new Palindromes();
        assertThat(palindromes.shortestPalindrome("abcd")).isEqualTo("dcbabcd");
        assertThat(palindromes.shortestPalindrome("abcda")).isEqualTo("adcbabcda");
        assertThat(palindromes.shortestPalindrome("aacecaaa")).isEqualTo("aaacecaaa");
    }
    @Test
    public void testShortestPalindromeRabinKarp() {
        Palindromes palindromes = new Palindromes();
        assertThat(palindromes.shortestPalindromeRabinKarp("abcd")).isEqualTo("dcbabcd");
        assertThat(palindromes.shortestPalindromeRabinKarp("abcda")).isEqualTo("adcbabcda");
        assertThat(palindromes.shortestPalindromeRabinKarp("aacecaaa")).isEqualTo("aaacecaaa");
    }

    @Test
    public void testLongestPalindrome() {
        Palindromes palindromes = new Palindromes();
        assertThat(palindromes.longestPalindrome("babad")).isEqualTo("bab");
        assertThat(palindromes.longestPalindrome("cbbd")).isEqualTo("bb");
        assertThat(palindromes.longestPalindrome("a")).isEqualTo("a");
        assertThat(palindromes.longestPalindrome("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth")).isEqualTo("ranynar");
    }

    @Test
    public void testLongestPalindromeDp() {
        Palindromes palindromes = new Palindromes();
        assertThat(palindromes.longestPalindromeDp("babad")).isEqualTo("bab");
        assertThat(palindromes.longestPalindromeDp("cbbd")).isEqualTo("bb");
        assertThat(palindromes.longestPalindromeDp("a")).isEqualTo("a");
        assertThat(palindromes.longestPalindromeDp("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth")).isEqualTo("ranynar");
    }
}