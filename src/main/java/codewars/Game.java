package codewars;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

import static java.lang.String.format;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Created by Chethan on 8/20/15.
 */
public class Game {


    public String winner(String[] deckSteve, String[] deckJosh) {
        List<String> cards = Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "T", "J", "Q", "K", "A");
        String format = "%s wins %d to %d";
        Map<String, Long> winsMap = IntStream.range(0, deckSteve.length).mapToObj(
                i -> {
                    int s = cards.indexOf(deckSteve[i]);
                    int j = cards.indexOf(deckJosh[i]);
                    return s > j ? "Steve" : s < j ? "Josh" : "";
                }
        ).collect(groupingBy(t -> t, counting()));
        long stevesWins = winsMap.getOrDefault("Steve", 0L);
        long joshsWins = winsMap.getOrDefault("Josh", 0L);
        return stevesWins == joshsWins ? "Tie" :
                stevesWins > joshsWins ? format(format, "Steve", stevesWins, joshsWins) : format(format, "Josh", joshsWins, stevesWins);
    }
}
