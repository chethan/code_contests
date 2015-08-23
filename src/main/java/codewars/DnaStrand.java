package codewars;

import java.util.HashMap;
import java.util.stream.Collectors;

public class DnaStrand {
    private static HashMap<Character,Character> dnaComplimentaryMap=new HashMap<>();
    static {
        dnaComplimentaryMap.put('A','T');
        dnaComplimentaryMap.put('T','A');
        dnaComplimentaryMap.put('C','G');
        dnaComplimentaryMap.put('G','C');
    }
    public String makeComplement(String dna) {
        return dna.chars().mapToObj(i->(char)i).map(ch->Character.toString(dnaComplimentaryMap.get(ch))).collect(Collectors.joining());
    }
}
