package learning.interview.primitives;

class SetBitsCounter {
    int countIterative(int number) {
        int count = 0;
        while (number != 0) {
            count += number & 1;
            number >>>= 1;
        }
        return count;
    }

    int countRecur(int number) {
        return count(number, 0);
    }

    int countBetter(int number){
		int count = 0;
		while(number != 0){
			number &= (number -1);
			count++;
		}    	
		return count;
    }

//	https://leetcode.com/problems/counting-bits    
    int[] countTill(int number){
    	int[] counts = new int[number+1];
    	while(number >=0){
    		counts[number] = countBetter(number);
    		number--;
    	}
    	return counts;
    }

    private int count(int number, int count) {
        if (number == 0) {
            return count;
        }
        return count(number >>> 1, count + (number & 1));
    }


}