package leetcode.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Chethan on 9/19/15.
 */
//http://programmers.stackexchange.com/questions/184994/champaign-fountain-puzzle
public class ChampagneFountain {

    public double getChampagneIn(int quantity, int number) {
        int glassNumber = 1;
        double[] champagneIn = new double[number + 1];
        champagneIn[1] = quantity;
        for (int level = 1; glassNumber <= number; level++) {
            for (int i = 0; glassNumber <= number && i < level; i++, glassNumber++) {
                double overflow = champagneIn[glassNumber] - 1;
                if (overflow > 0) {
                    if (glassNumber + level <= number) {
                        champagneIn[glassNumber + level] += overflow / 2;
                    }
                    if (glassNumber + level + 1 <= number) {
                        champagneIn[glassNumber + level + 1] += overflow / 2;
                    }
                    champagneIn[glassNumber] = 1;
                }
            }
        }
        return champagneIn[number];
    }

    //https://leetcode.com/problems/champagne-tower/
    //Solved using simulation
    //Time: O(R^2) where R is number of rows
    //Space: O(R) for storing the previous state
    public double champagneTower(int poured, int query_row, int query_glass) {
        Map<Integer, Double> previous = new HashMap<>();
        double result = 0;
        previous.put(0, (double) poured);
        for (int r = 0; r <= query_row; r++) {
            Map<Integer, Double> current = new HashMap<>();
            for (int c = 0; c <= r; c++) {
                double remaining = (get(previous, c) - 1.0) / 2.0;
                if (remaining > 0) {
                    current.put(c, remaining + get(current, c));
                    current.put(c + 1, remaining + get(current, c + 1));
                }
            }
            if (r == query_row) {
                result = Math.min(1, get(previous, query_glass));
            }
            previous = current;
        }
        return result;
    }

    double get(Map<Integer, Double> data, int c) {
        return data.getOrDefault(c, 0.0);
    }

}
