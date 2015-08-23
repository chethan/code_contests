package codewars;

/**
 * Created by Chethan on 8/19/15.
 */
public class Chocolate {
    public int breakChocolate(int n, int m) {
        return n == 0 || m == 0 ? 0 : (m - 1) * n + (n - 1);
    }
}
