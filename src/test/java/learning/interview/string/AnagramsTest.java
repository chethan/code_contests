package learning.interview.string;

import org.assertj.core.api.StrictAssertions;
import org.testng.annotations.Test;

import java.util.Arrays;

import static java.util.Arrays.*;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by Chethan on 8/23/15.
 */
public class AnagramsTest {

    @Test
    public void testFirstAnagram() throws Exception {
        Anagrams anagrams = new Anagrams();
        assertThat(anagrams.firstAnagram("oabt")).isEqualTo("boat");
        assertThat(anagrams.firstAnagram("qryeu")).isEqualTo("query");
    }

    @Test
    public void testIsAnagram() throws Exception {
        Anagrams validAnagram = new Anagrams();
        StrictAssertions.assertThat(validAnagram.isAnagram("anagram", "nagaram")).isEqualTo(true);
        StrictAssertions.assertThat(validAnagram.isAnagram("car", "rat")).isEqualTo(false);
    }

    @Test
    public void testGroupAnagrams() throws Exception {
        Anagrams anagrams = new Anagrams();
        assertThat(anagrams.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})).hasSize(3);
        assertThat(anagrams.groupAnagrams(new String[]{"eat", "tea", "tan"})).hasSize(2);
        assertThat(anagrams.groupAnagrams(new String[]{})).hasSize(0);
        assertThat(anagrams.groupAnagrams(new String[]{"eat", "tea"})).hasSize(1);
        assertThat(anagrams.groupAnagramsWithoutSorting(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})).hasSize(3);
        assertThat(anagrams.groupAnagramsWithoutSorting(new String[]{"eat", "tea", "tan"})).hasSize(2);
        assertThat(anagrams.groupAnagramsWithoutSorting(new String[]{})).hasSize(0);
        assertThat(anagrams.groupAnagramsWithoutSorting(new String[]{"eat", "tea"})).hasSize(1);

    }

    @Test
    public void testGroupShiftedString() throws Exception {
        Anagrams anagrams = new Anagrams();
        assertThat(anagrams.groupStrings(new String[]{"abc","bcd","acef","xyz","az","ba","a","z"})).hasSize(4);
    }
    @Test
    public void testFindAnagrams() throws Exception {
        Anagrams anagrams = new Anagrams();
        assertThat(anagrams.findAnagrams("cbaebabacd","abc")).containsExactly(0,6);
        assertThat(anagrams.findAnagrams("","abc")).containsExactly();
        assertThat(anagrams.findAnagrams("abab","ab")).containsExactly(0,1,2);

    }

}