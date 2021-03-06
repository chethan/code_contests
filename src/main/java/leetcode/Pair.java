package leetcode;

public class Pair<T, U> {
    T first;
    U last;

    public Pair(T first, U value) {
        this.first = first;
        this.last = value;
    }

    public T getFirst() {
        return first;
    }

    public U getLast() {
        return last;
    }
}
