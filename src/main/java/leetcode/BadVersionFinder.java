package leetcode;

/**
 * Created by Chethan on 9/18/16.
 */
//https://leetcode.com/problems/first-bad-version/
public abstract class BadVersionFinder {
    abstract boolean isBadVersion(int version);

    public int firstBadVersion(int n) {
        long low = 1, high = n, myGuess;
        boolean isBadVersion;
        do {
            myGuess = (low + high) / 2;
            System.out.println(low + "," + high + "," + myGuess);
            isBadVersion = isBadVersion((int) myGuess);
            if (isBadVersion) high = myGuess - 1;
            else low = myGuess + 1;
        } while (low <= high);
        return (int) low;
    }
}
