package leetcode.array;

//https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
public class PairOfSongs {

    //for a pair to be divisible by 60
    //1> either both of them have to be divisible by 60
    //2> or the reminder when both of them are divided should sum up to 60
    //. for example 130,50  -> reminders 10,50
    public int numPairsDivisibleBy60(int[] time) {
        int[] reminders = new int[60];
        int count = 0;
        for (int t : time) {
            int reminder = t % 60;
            if (reminder == 0) {
                count += reminders[0];
            } else {
                count += reminders[60 - reminder];
            }
            reminders[reminder]++;
        }
        return count;
    }
}
