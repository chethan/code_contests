package codewars;

import java.util.stream.IntStream;

/**
 * Created by Chethan on 8/21/15.
 */
public class MultipleOf3And5 {
    public int solution(int number) {
        return IntStream.range(1,number).filter(value -> value%3==0 || value%5==0).sum();
    }
}
