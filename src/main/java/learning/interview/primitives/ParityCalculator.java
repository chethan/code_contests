package learning.interview.primitives;
class ParityCalculator{
	int parity(long number){
		int result = 0;
		while(number != 0){
			result ^= 1;
			number &= (number - 1);
		}
		return result;
	}
}