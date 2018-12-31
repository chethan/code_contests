package learning.interview.bitwise;

class BinaryWeight{

	public int nearestNumberWithSameWeight(int n){
		int leftBit = 2 , rightBit = 1;
		while((n & leftBit) == 0 ^ (n & rightBit) !=0){
			leftBit <<=1;
			rightBit <<=1;
		}
		return n ^ (leftBit | rightBit );
	}
}