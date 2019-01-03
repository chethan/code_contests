package learning.interview.arrays;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class RandomizedSetTest {

    @Test
    public void checkSetOperations() {
        RandomizedSet randomizedSet = new RandomizedSet();
        assertThat(randomizedSet.insert(10)).isTrue();
        assertThat(randomizedSet.insert(10)).isFalse();
        assertThat(randomizedSet.getRandom()).isEqualTo(10);
        assertThat(randomizedSet.remove(10)).isTrue();
        assertThat(randomizedSet.remove(10)).isFalse();
    }
}