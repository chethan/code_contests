package leetcode.array;

import java.util.Arrays;

public class CakeCut {

    //https://leetcode.com/problems/maximum-area-of-a-piece-of-cake-after-horizontal-and-vertical-cuts/
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long maxWidth = 0, maxHeight = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int i = 0, firstCut = 0, lastCut = 0; i <= horizontalCuts.length; i++) {
            lastCut = (i == horizontalCuts.length) ? h : horizontalCuts[i];
            maxWidth = Math.max(maxWidth, lastCut - firstCut);
            firstCut = lastCut;
        }
        for (int i = 0, firstCut = 0, lastCut = 0; i <= verticalCuts.length; i++) {
            lastCut = (i == verticalCuts.length) ? w : verticalCuts[i];
            maxHeight = Math.max(maxHeight, lastCut - firstCut);
            firstCut = lastCut;
        }
        return (int) ((maxWidth * maxHeight) % (1000000007));
    }
}
