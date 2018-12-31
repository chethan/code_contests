package learning.interview.primitives;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BitSwapperTest {
    @Test
    public void shouldSwapBits() {
        BitSwapper bitSwapper = new BitSwapper();
        assertThat(bitSwapper.swapBits(2,0,1)).isEqualTo(1);
        assertThat(bitSwapper.swapBits(2,0,1)).isEqualTo(1);
        assertThat(bitSwapper.swapBits(2,2,3)).isEqualTo(2);
        assertThat(bitSwapper.swapBits(3,1,0)).isEqualTo(3);
    }

    @Test
    public void shouldReverseBits(){
        BitSwapper bitSwapper = new BitSwapper();
//        assertThat(bitSwapper.reverseBits(2)).isEqualTo(1073741824);
//        assertThat(bitSwapper.reverseBits(1073741824)).isEqualTo(2);
        assertThat(bitSwapper.reverseBits(43261596)).isEqualTo(964176192);

    }


}