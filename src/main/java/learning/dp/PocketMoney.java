package learning.dp;

/**
 * Created by Chethan on 10/4/15.
 */
//http://www.spoj.com/problems/LISA/
public class PocketMoney {
    public String maximumValue(String expression) {
        char[] chars = expression.toCharArray();
        int n = (chars.length / 2) + 1;
        int[] numbers = new int[n];
        char[] symbols = new char[chars.length / 2];
        splitExpression(chars, numbers, symbols);

        int[][] maxValue = new int[n][n];
        int[][] minValue = new int[n][n];

        for (int i = 0; i < n; i++) {
            maxValue[i][i] = numbers[i];
            minValue[i][i] = numbers[i];
        }

        for (int l = 2; l <=n; l++) {
            for (int i = 0; i < n - (l - 1); i++) {
                int j = i + (l - 1);
                maxValue[i][j] = Integer.MIN_VALUE;
                minValue[i][j] = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    int value = calculate(maxValue[i][k], maxValue[k + 1][j], symbols[k]);
                    if (value > maxValue[i][j]) {
                        maxValue[i][j] = value;
                    }
                    if (value < minValue[i][j]) {
                        minValue[i][j] = value;
                    }
                }
            }
        }
        return maxValue[0][n - 1]+" "+minValue[0][n-1];
    }

    private int calculate(int num1, int num2, char symbol) {
        return symbol == '+' ? num1 + num2 : num1 * num2;
    }

    private void splitExpression(char[] chars, int[] numbers, char[] symbols) {
        for (int i = 0; i < chars.length; i++) {
            if (i % 2 == 0) {
                numbers[i / 2] = Character.getNumericValue(chars[i]);
            } else {
                symbols[i / 2] = chars[i];
            }
        }
    }
}
