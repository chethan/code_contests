package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class PrisonCells {


    public int[] prisonAfterNDays(int[] cells, int n) {
        if (cells == null || n < 1) {
            return cells;
        }
        Map<Integer, Integer> seen = new HashMap<>();
        boolean foundPattern = false;
        while (n > 0) {
            if (!foundPattern) {
                int signature = mapCells(cells);
                if (seen.containsKey(signature)) {
                    int lastSeen = seen.get(signature);
                    int repetitionGap = lastSeen - n;
                    n = n % repetitionGap;
                    foundPattern = true;
                } else {
                    seen.put(signature, n);
                }
            }
            if (n > 0) {
                n--;
                cells = nextDay(cells);
            }

        }
        return cells;

    }

    private int mapCells(int[] cells) {
        int bitMap = 0;
        for (int cell : cells) {
            bitMap <<= 1;
            bitMap = (bitMap | cell);
        }
        return bitMap;
    }

    private int[] nextDay(int[] cells) {
        int[] nextState = new int[cells.length];
        for (int i = 1; i < cells.length - 1; i++) {
            if (cells[i - 1] == cells[i + 1]) {
                nextState[i] = 1;
            }
        }
        return nextState;
    }
}
