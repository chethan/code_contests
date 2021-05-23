package leetcode.array;

public class Candy {

    //https://leetcode.com/problems/candy/
    public int candy(int[] ratings) {
        int[] leftSide = new int[ratings.length];
        int[] rightSide = new int[ratings.length];
        for (int i = 0; i < ratings.length; i++) {
            leftSide[i] = rightSide[i] = 1;
        }
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                leftSide[i] = leftSide[i - 1] + 1;
            }
        }

        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rightSide[i] = rightSide[i + 1] + 1;
            }
        }

        int totalCandy = 0;
        for (int i = 0; i < ratings.length; i++) {
            totalCandy += Math.max(leftSide[i], rightSide[i]);
        }
        return totalCandy;

    }
}
