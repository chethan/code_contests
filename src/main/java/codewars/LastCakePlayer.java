package codewars;

/**
 * Created by Chethan on 8/22/15.
 */
public class LastCakePlayer {
    public LastCakePlayer(int cakes) {
    }
    // Decide who move first - player or opponent (true if player)
    public boolean firstMove(int cakes) {
        // I wish to move first
        return true;
    }

    // Decide your next move
    public int move(int cakes, int last) {
        // I'm not greedy
        return last == 1 ? 2 : 1;
    }
}
