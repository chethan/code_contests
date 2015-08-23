package codewars;

/**
 * Created by Chethan on 8/20/15.
 */
public class Lucas {
    public int lucasnum(int n) {
        return n==0?2:n==1?1:n>1?lucasnum(n-1)+lucasnum(n-2):lucasnum(n+2)-lucasnum(n+1);
    }
}
