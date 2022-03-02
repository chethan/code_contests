package leetcode.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-shifted-strings/
public class ShiftedStrings {

    //Time : O(M*N) -> M is average length of String, N is number fo strings
    //Space: O(M*N)
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> differenceMap = new HashMap<>();
        for (String s : strings) {
            String difference = encodeDifference(s);
            differenceMap.putIfAbsent(difference, new ArrayList<>());
            differenceMap.get(difference).add(s);
        }
        return List.copyOf(differenceMap.values());
    }
    // method to convert char differences as a String
    // for example abcd -> 111 , a->0, ba -> 25

    String encodeDifference(String value) {
        if (value.length() == 1) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        for (int i = 1; i < value.length(); i++) {
            int diff = value.charAt(i) - value.charAt(i - 1);
            builder.append(diff < 0 ? 26 + diff : diff).append("_");
        }
        return builder.toString();
    }
}
