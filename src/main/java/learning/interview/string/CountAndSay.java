package learning.interview.string;

class CountAndSay {
    //https://leetcode.com/problems/count-and-say
    String generate(int n) {
        String currentNumber = "1";
        if (n <= 0) return "";
        if (n == 1) return currentNumber;
        for (; n > 1; n--) {
            currentNumber = getNext(currentNumber);
        }

        return currentNumber;
    }

    private String getNext(String currentNumber) {
        int count = 1;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < currentNumber.length(); i++) {
            if (currentNumber.charAt(i) == currentNumber.charAt(i - 1)) {
                count++;
            } else {
                stringBuilder.append(count).append(currentNumber.charAt(i - 1));
                count = 1;
            }
        }
        stringBuilder.append(count).append(currentNumber.charAt(currentNumber.length() - 1));
        currentNumber = stringBuilder.toString();
        return currentNumber;
    }
}
