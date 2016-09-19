package leetcode;

/**
 * Created by Chethan on 9/18/16.
 */
public abstract class NumberGuesser {
    public int guessNumber(int n) {
        long low = 0, high = n, myGuess, isCorrect;
        do {
            myGuess = (low + high) / 2;
            isCorrect = guess((int) myGuess);
            if (isCorrect > 0) low = myGuess + 1;
            else if (isCorrect < 0) high = myGuess - 1;
        } while (isCorrect != 0);
        return (int) myGuess;
    }

    public abstract int guess(int number);
}
