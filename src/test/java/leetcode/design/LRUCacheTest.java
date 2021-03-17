package leetcode.design;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

public class LRUCacheTest {

    @Test
    public void testLRUCacheOperations() {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1);
        lruCache.put(2, 2);
        assertThat(lruCache.get(1)).isEqualTo(1);
        lruCache.put(3, 3);
        assertThat(lruCache.get(2)).isEqualTo(-1);
        lruCache.put(4, 4);
        assertThat(lruCache.get(1)).isEqualTo(-1);
        assertThat(lruCache.get(3)).isEqualTo(3);
        assertThat(lruCache.get(4)).isEqualTo(4);
    }
}