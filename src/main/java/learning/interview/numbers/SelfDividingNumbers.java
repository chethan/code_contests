package learning.interview.numbers;

import java.util.List;
import java.util.LinkedList;

class SelfDividingNumbers {

	//https://leetcode.com/problems/self-dividing-numbers   
    List<Integer> selfDividingNumbers(int left, int right) {

        List<Integer> result = new LinkedList<Integer>();
        for (int i = left; i <= right; i++) {
            List<Integer> digits = getDigits(i);
            boolean isSelfDividing = true;
            for (int digit : digits) {
                if (digit==0 || i % digit != 0) {
                    isSelfDividing = false;
                    break;
                }
            }
            if (isSelfDividing) {
                result.add(i);
            }
        }
        return result;

    }

    private List<Integer> getDigits(int num) {
        List<Integer> result = new LinkedList<Integer>();
        while (num != 0) {
            result.add(num % 10);
            num /= 10;
        }
        return result;
    }

}