package leetcode.array;

public class FriendRequests {

    //https://leetcode.com/problems/friends-of-appropriate-ages/
    public int numFriendRequests(int[] ages) {
        int[] counts = new int[121];
        for (int age : ages) {
            counts[age]++;
        }
        int count = 0;
        for (int i = 0; i <= 120; i++) {
            for (int j = 0; j <= 120; j++) {
                if (!cantSendRequest(i, j)) {
                    count += (counts[i]) * (i == j ? counts[j] - 1 : counts[j]);
                }

            }
        }
        return count;
    }

    boolean cantSendRequest(int age1, int age2) {
        return age2 <= age1 / 2 + 7 || age2 > age1;
    }
}
