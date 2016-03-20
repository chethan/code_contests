package learning.tech.interview.meetup;

import java.util.Arrays;

/**
 * Created by Chethan on 3/19/16.
 */
public class CakeDistribution {

    public double maximumSlice(int[] cakeVolumes, double slices) {
        double max = Arrays.stream(cakeVolumes).sum() / slices;
//        Making guess for min value and applying binary search
        double min = Arrays.stream(cakeVolumes).max().getAsInt() / slices, mid;
        while (true) {
            mid = (min + max) / 2;
            int totalSlices = getTotalSlices(cakeVolumes, mid);
            if (totalSlices == slices && (max - min) <= 0) return mid;
            if (totalSlices >= slices) min = mid;
            else max = mid;
        }
    }

    private int getTotalSlices(int[] cakeVolumes, double max) {
        int totalSlices = 0;
        for (int cakeVolume : cakeVolumes) {
            double temp = cakeVolume;
            while (temp >= max) {
                temp = temp - max;
                totalSlices++;
            }
        }
        return totalSlices;
    }


}
