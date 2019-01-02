package learning.interview.numbers;

class TitleConverter {
    //https://leetcode.com/problems/excel-sheet-column-title
    String convertToTitle(int n) {
        StringBuilder columnName = new StringBuilder();
        for (; n != 0; n /= 26) {
            n = n - 1;
            columnName.append((char) ('A' + n % 26));
        }
        return columnName.reverse().toString();
    }

    //https://leetcode.com/problems/excel-sheet-column-number/
    public int titleToNumber(String s) {
        char[] chars = s.toCharArray();
        int columnNumber = 0;
        for (char aChar : chars) {
            columnNumber = columnNumber * 26 + (aChar - 'A' + 1);
        }
        return columnNumber;
    }
}
