package leetcode.array;

import static java.util.stream.Collector.of;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.IntStream;

public class KDigitsRemover {

    //https://leetcode.com/problems/remove-k-digits/
    public String removeKdigits(String num, int k) {
        if (num == null || num.length() <= k) {
            return "0";
        }
        Deque<Character> deque = new ArrayDeque<>();
        deque.push(num.charAt(0));
        for (int i = 1; i < num.length(); i++) {
            char c = num.charAt(i);
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                deque.removeLast();
                k--;
            }
            deque.addLast(c);
        }
        IntStream.range(0, k).forEach(i -> deque.removeLast());
        StringBuilder result = deque.stream()
            .dropWhile(c -> c == '0')
            .collect(of(StringBuilder::new, StringBuilder::append, StringBuilder::append));
        return result.length() == 0 ? "0" : result.toString();
    }
}
