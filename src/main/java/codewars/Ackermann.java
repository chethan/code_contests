package codewars;

/**
 * Created by Chethan on 8/20/15.
 */
public class Ackermann {
        public int ackermann(int m, int n){
            return (m<0||n<0)?0:m==0?n+1:(m>0 && n==0)?ackermann(m-1,1):ackermann(m-1,ackermann(m,n-1));
        }
}
