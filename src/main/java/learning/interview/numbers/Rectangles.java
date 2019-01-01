package learning.interview.numbers;

class Rectangles {


    //https://leetcode.com/problems/rectangle-overlap/
    boolean isRectangleOverlap(int[] rec1, int[] rec2) {
        if (rec1.length != 4 && rec2.length != 4) return false;
        return Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2])
                && Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]);
    }

    /*  Math.max(rec1[0], rec2[0]) < Math.min(rec1[2], rec2[2])
     && Math.max(rec1[1], rec2[1]) < Math.min(rec1[3], rec2[3]); */

    //https://leetcode.com/problems/rectangle-area/
    int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int intersectionWidth = Math.min(C, G) >= Math.max(A, E) ? Math.min(C, G) - Math.max(A, E) : -1;
        int intersectionHeight = Math.min(D, H) >= Math.max(B, F) ? Math.min(D, H) - Math.max(B, F) : -1;
        return (C - A) * (D - B) + (G - E) * (H - F) -
                ((intersectionWidth > 0 && intersectionHeight > 0) ? intersectionWidth * intersectionHeight : 0);
    }

}
