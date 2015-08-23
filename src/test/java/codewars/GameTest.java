package codewars;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created by Chethan on 8/20/15.
 */
public class GameTest {

    private Game game = new Game();

    @Test
    public void testWinner() throws Exception {
        assertEquals("Steve wins 2 to 1", game.winner(new String[]{"A", "7", "8"}, new String[]{"K", "5", "9"}));
        assertEquals("Tie", game.winner(new String[]{"T"}, new String[]{"T"}));
    }
}
