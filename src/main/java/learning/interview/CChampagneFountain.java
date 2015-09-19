package learning.interview;

/**
 * Created by Chethan on 9/19/15.
 */
//http://programmers.stackexchange.com/questions/184994/champaign-fountain-puzzle
public class CChampagneFountain {
    public double getChampagneIn(int quantity, int number) {
        int glassNumber = 1;
        double[] champagneIn = new double[number + 1];
        champagneIn[1] = quantity;
        for (int level = 1; glassNumber <= number; level++) {
            for (int i = 0; glassNumber <= number && i < level; i++, glassNumber++) {
                double overflow = champagneIn[glassNumber] - 1;
                if (overflow > 0) {
                    if (glassNumber + level <= number) champagneIn[glassNumber + level] += overflow / 2;
                    if (glassNumber + level + 1 <= number) champagneIn[glassNumber + level+1] += overflow / 2;
                    champagneIn[glassNumber] = 1;
                }
            }
        }
        return champagneIn[number];
    }

}
