package learning.dp;

import java.util.List;
import java.util.Optional;

import static java.util.Arrays.stream;

/**
 * Created by Chethan on 9/15/15.
 */
//M[j]=max(M[j-1]+A[j],A[j])
public class MaxContiguousSubseq {

    public int findMax(List<Integer> numbers,Optional<Integer> endingLocation) {
        int[] maxArray = new int[numbers.size()];
        for (int i = 0; i < numbers.size(); i++) {
            Integer number = numbers.get(i);
            maxArray[i] = (i - 1) < 0 ? number : Math.max(maxArray[i - 1] + number, number);
        }
        return endingLocation.isPresent()?maxArray[endingLocation.get()]:
                stream(maxArray).max().getAsInt();
    }
}
