package learning.interview.arrays;

import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.*;

public class JumpGameTest {

    @Test
    public void testCanJump() {
        JumpGame jumpGame = new JumpGame();
        assertThat(jumpGame.canJump(new int[]{1})).isTrue();
        assertThat(jumpGame.canJump(new int[]{0})).isTrue();
        assertThat(jumpGame.canJump(new int[]{2, 4, 5, 6})).isTrue();
        assertThat(jumpGame.canJump(new int[]{3, 2, 1, 0, 4})).isFalse();
        assertThat(jumpGame.canJump(new int[]{3, 2, 1, 0, 4})).isFalse();
        assertThat(jumpGame.canJump(new int[]{3, 2, 2, 0, 4, 1, 0, 5})).isTrue();
        assertThat(jumpGame.canJump(new int[]{3, 2, 2, 0, 2, 1, 0, 5})).isFalse();
    }

    @Test
    public void testCanJumpSmart() {
        JumpGame jumpGame = new JumpGame();
        assertThat(jumpGame.canJumpSmart(new int[]{1})).isTrue();
        assertThat(jumpGame.canJumpSmart(new int[]{0})).isTrue();
        assertThat(jumpGame.canJumpSmart(new int[]{2, 4, 5, 6})).isTrue();
        assertThat(jumpGame.canJumpSmart(new int[]{3, 2, 1, 0, 4})).isFalse();
        assertThat(jumpGame.canJumpSmart(new int[]{3, 2, 1, 0, 4})).isFalse();
        assertThat(jumpGame.canJumpSmart(new int[]{3, 2, 2, 0, 4, 1, 0, 5})).isTrue();
        assertThat(jumpGame.canJumpSmart(new int[]{3, 2, 2, 0, 2, 1, 0, 5})).isFalse();
    }

    @Test
    public void testJumpSteps() {
        JumpGame jumpGame = new JumpGame();
        assertThat(jumpGame.jump(new int[]{3, 4, 1,1,1,3})).isEqualTo(2);
//        assertThat(jumpGame.jump(new int[]{1})).isEqualTo(0);
//        assertThat(jumpGame.jump(new int[]{0})).isEqualTo(0);
//        assertThat(jumpGame.jump(new int[]{2, 4, 5, 6})).isEqualTo(2);
//        assertThat(jumpGame.jump(new int[]{3, 2, 1, 0, 4})).isEqualTo(0);
//        assertThat(jumpGame.jump(new int[]{3, 2, 2, 0, 4, 1, 0, 5})).isEqualTo(3);
//        assertThat(jumpGame.jump(new int[]{3, 2, 2, 0, 2, 1, 0, 5})).isEqualTo(0);
//        assertThat(jumpGame.jump(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
//        assertThat(jumpGame.jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3})).isEqualTo(2);
    }
}