package learning.recursion.backtracking;

import java.util.HashMap;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by Chethan on 8/25/15.
 */
public class CryptarithmeticSolver {
    public HashMap<Character, Integer> solve(String first, String second, String result) {
        List<Character> remainingChars = (first + second + result).chars().mapToObj(i -> (char) i).filter(Character::isLetter).distinct().collect(Collectors.toList());
        List<Integer> remainingNumbers = IntStream.range(0, 10).mapToObj(i -> i).collect(Collectors.toList());
        Predicate<HashMap<Character, Integer>> isSolved = map -> {
            boolean firstCharNonZero = map.get(first.charAt(0)) != 0 && map.get(second.charAt(0)) != 0;
            return firstCharNonZero && (assignValues(first, map) + assignValues(second, map)) == assignValues(result, map);
        };
        return solve(new HashMap<>(), remainingChars, remainingNumbers, isSolved);
    }

    private HashMap<Character, Integer> solve(HashMap<Character, Integer> assignedChars,
                                              List<Character> remainingChars, List<Integer> remainingNumbers, Predicate<HashMap<Character, Integer>> isSolved) {
        if (remainingChars.isEmpty()) {
            return isSolved.test(assignedChars) ? assignedChars : null;
        }
        for (int i = 0; i < remainingNumbers.size(); i++) {
            Integer remainingNumber = remainingNumbers.get(i);
            assignedChars.put(remainingChars.get(0), remainingNumber);
            HashMap<Character, Integer> solved = solve(assignedChars, remainingChars.subList(1, remainingChars.size()), remainingNumbers.stream().
                    filter(integer -> !integer.equals(remainingNumber)).collect(Collectors.toList()), isSolved);
            if (solved != null) {
                return solved;
            }
        }
        return null;
    }

    private Long assignValues(String input, HashMap<Character, Integer> values) {
        return input.chars().mapToObj(value -> (char) value).reduce(
                0L, (aLong, ch) -> aLong*10+values.get(ch), (aLong1, aLong2) -> aLong1 + aLong2);
    }

}
