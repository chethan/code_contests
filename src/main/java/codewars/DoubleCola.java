package codewars;

/**
 * Created by Chethan on 8/22/15.
 */
public class DoubleCola {
    public static String WhoIsNext(String[] names, int n) {
        int sum = 0, count = 1;
        for (int i = names.length;sum+i<n ; i = i * 2) {
            sum = sum + i;
            count = count * 2;
        }
        return names[(n-sum-1)/count];
    }
}
