package learning.recursion.backtracking;

import java.util.Optional;

/**
 * Created by Chethan on 8/25/15.
 * http://www.geeksforgeeks.org/fill-two-instances-numbers-1-n-specific-way/
 */
public class NumberFiller {
    public Optional<int[]> fill(Integer num) {
        return fill(new int[num * 2], num);
    }

    private Optional<int[]> fill(int[] slots, Integer num) {
        if (num == 0) {
            return Optional.of(slots);
        }
        for (int i = 0; i < slots.length; i++) {
            if (slots[i] == 0 && slots.length > (i + num + 1) && slots[i + num + 1] == 0) {
                slots[i] = slots[i + num + 1] = num;
                Optional<int[]> finalSlots = fill(slots, num - 1);
                if (finalSlots.isPresent()) {
                    return finalSlots;
                }
                slots[i] = slots[i + num + 1] = 0;
            }
        }
        return Optional.empty();
    }
}
