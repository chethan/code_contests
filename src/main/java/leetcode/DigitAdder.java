package leetcode;

/**
 * Created by Chethan on 9/23/16.
 */
//https://leetcode.com/problems/add-digits/
//https://en.wikipedia.org/wiki/Digital_root     
public class DigitAdder {
    public int addDigits(int num) {
        int sum;
        do {
            sum = 0;
            while (num != 0) {
                sum += num % 10;
                num = num / 10;
            }
            num = sum;
        } while (sum >= 10);

        return sum;
    }
}
