package learning.recursion.backtracking;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by Chethan on 8/23/15.
 */
public class Anagrams {

    private final Set<String> words;

    public Anagrams() throws Exception {
        //TODO: Read from classpath
        words = Files.readAllLines(Paths.get("src/main/resources/words")).
                stream().map(String::toLowerCase).
                collect(Collectors.toSet());
    }

    public String firstAnagram(String s) {
        return firstAnagram("", s).orElse("");
    }

    private Optional<String> firstAnagram(String soFar, String rest) {
        if (rest.isEmpty()) {
            return words.contains(soFar) ? Optional.of(soFar) : Optional.<String>empty();
        }
        char[] chars = rest.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            String nextSoFar = soFar + chars[i];
            Optional<String> permutation = firstAnagram(nextSoFar, rest.substring(0, i) + rest.substring(i + 1));
            if (permutation.isPresent()) return permutation;
        }
        return Optional.empty();

    }

}
