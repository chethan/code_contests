package learning.interview.numbers;

class DIString {

    //https://leetcode.com/problems/di-string-match
    int[] diStringMatchSmart(String S) {
        char[] chars = S.toCharArray();
        int[] di = new int[chars.length + 1];
        int i = 0, d = chars.length, counter = 0;
        for (char aChar : chars) {
            di[counter++] = (aChar == 'I') ? i++ : d--;
        }
        di[counter] = i;
        return di;
    }


    //Backtracking solution 
    int[] diStringMatch(String S) {
        char[] chars = S.toCharArray();
        int[] availableValues = new int[chars.length + 1];
        int[] di = new int[chars.length + 1];
        for (int i = 0; i < availableValues.length; i++) {
            availableValues[i] = i;
        }
        diRecur(chars, di, availableValues, 0);
        return di;
    }

    private boolean diRecur(char[] s, int[] di, int[] availableValues, int index) {
        if (index == (di.length)) return true;
        for (int i = 0; i < availableValues.length; i++) {
            if (index == 0) {
                di[index] = availableValues[i];
                if (diRecur(s, di, getAvailableValues(availableValues, i), index + 1)) return true;
                continue;
            }
            if (s[index - 1] == 'I' && availableValues[i] > di[index - 1]) {
                di[index] = availableValues[i];
                if (diRecur(s, di, getAvailableValues(availableValues, i), index + 1)) return true;
            }
            if (s[index - 1] == 'D' && availableValues[i] < di[index - 1]) {
                di[index] = availableValues[i];
                if (diRecur(s, di, getAvailableValues(availableValues, i), index + 1)) return true;
            }
        }
        return false;
    }

    private int[] getAvailableValues(int[] current, int removeIndex) {
        int[] availableValues = new int[current.length - 1];
        for (int i = 0, j = 0; i < current.length; i++) {
            if (i == removeIndex) {
                continue;
            }
            availableValues[j++] = current[i];
        }
        return availableValues;
    }

}