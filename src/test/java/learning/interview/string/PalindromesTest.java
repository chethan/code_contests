package learning.interview.string;

import org.testng.annotations.Test;

import java.util.Arrays;

import static java.util.Arrays.asList;
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

    @Test
    public void testCountSubstrings() {
        Palindromes palindromes = new Palindromes();
        assertThat(palindromes.countSubstrings("abc")).isEqualTo(3);
        assertThat(palindromes.countSubstrings("aaa")).isEqualTo(6);
    }

    @Test
    public void testCountSubstringsExtend() {
        Palindromes palindromes = new Palindromes();
        assertThat(palindromes.countSubstringsExtend("abc")).isEqualTo(3);
        assertThat(palindromes.countSubstringsExtend("aaa")).isEqualTo(6);
    }

    @Test
    public void testIsPalindromeOnlyAlphaNumeric() {
        Palindromes palindromes = new Palindromes();
        assertThat(palindromes.isPalindromeOnlyAlphaNumeric("A man, a plan, a canal: Panama")).isTrue();
    }

    @Test
    public void testIsPalindromeAfterDeleting() {
        Palindromes palindromes = new Palindromes();
        assertThat(palindromes.isPalindromeAfterDeleting("abca")).isTrue();
        assertThat(palindromes.isPalindromeAfterDeleting("aguokepatgbnvfqmgmlcupuufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuculmgmqfvnbgtapekouga")).isTrue();
    }

    @Test
    public void testPalindromePairs() {
        Palindromes palindromes = new Palindromes();
        assertThat(palindromes.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}))
                .hasSize(4);
        assertThat(palindromes.palindromePairs(new String[]{"bat","tab","cat"}))
                .hasSize(2);
        assertThat(palindromes.palindromePairs(new String[]{"a","b","c","ab","ac","aa"}))
                .hasSize(6);

    }
}