package leetcode.design;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class AutocompleteSystemTest {

    @Test
    public void testAutoCompleteSystem() {
        AutocompleteSystem autocompleteSystem = new AutocompleteSystem(
            new String[]{"i love you", "island", "ironman", "i love leetcode"},
            new int[]{5, 3, 2, 2});

        assertThat(autocompleteSystem.input('i'))
            .containsExactly("i love you", "island", "i love leetcode");
        assertThat(autocompleteSystem.input(' '))
            .containsExactly("i love you", "i love leetcode");
        assertThat(autocompleteSystem.input('a'))
            .containsExactly();
        assertThat(autocompleteSystem.input('#'))
            .containsExactly();
        assertThat(autocompleteSystem.input('i'))
            .containsExactly("i love you", "island", "i love leetcode");
        assertThat(autocompleteSystem.input(' '))
            .containsExactly("i love you", "i love leetcode","i a");

    }
}