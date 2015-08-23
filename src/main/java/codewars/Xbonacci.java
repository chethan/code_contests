package codewars;

import java.util.stream.Stream;

/**
 * Created by Chethan on 8/20/15.
 */
public class Xbonacci {
    public double[] tribonacci(double[] s, int n) {
        return Stream.iterate(s,s1->new double[]{s1[1],s1[2],s1[0]+s1[1]+s1[2]}).mapToDouble(f->f[0]).limit(n).toArray();
    }
}
