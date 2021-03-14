package leetcode.trie;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class MapSumTest {

    @Test
    public void testMapSum() {
        MapSum mapSum = new MapSum();
        mapSum.insert("apple", 3);
        assertThat(mapSum.sum("ap")).isEqualTo(3);
        mapSum.insert("app", 2);
        assertThat(mapSum.sum("ap")).isEqualTo(5);
    }
}