package codewars;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BallotsCounter {

    public String getWinner(final List<String> listOfBallots) {
        return listOfBallots.stream().
                collect(Collectors.groupingBy(s -> s, Collectors.counting())).
                entrySet().stream().filter(s -> s.getValue() > listOfBallots.size() / 2).
                map(Map.Entry::getKey).findFirst().orElse(null);
    }
}