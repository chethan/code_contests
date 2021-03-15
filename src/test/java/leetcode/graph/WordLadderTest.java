package leetcode.graph;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.testng.annotations.Test;

public class WordLadderTest {

    @Test
    public void testLadderLength() {
        WordLadder wordLadder = new WordLadder();
        assertThat(wordLadder
            .ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")))
            .isEqualTo(5);
        assertThat(wordLadder
            .ladderLength("hit", "hit", List.of("hot", "dot", "dog", "lot", "log", "cog")))
            .isEqualTo(0);
        assertThat(wordLadder
            .ladderLength("hit", "not", List.of("hot", "dot", "dog", "lot", "log", "cog")))
            .isEqualTo(0);
    }
}