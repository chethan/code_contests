package ds;

/**
 * Created by Chethan on 10/4/15.
 */
public class Tuple<T> {
    public T left;
    public T right;

    public Tuple(T left, T right) {
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tuple)) return false;

        Tuple<?> tuple = (Tuple<?>) o;

        if (left != null ? !left.equals(tuple.left) : tuple.left != null) return false;
        return !(right != null ? !right.equals(tuple.right) : tuple.right != null);

    }

    @Override
    public int hashCode() {

        int result = left != null ? left.hashCode() : 0;
        result = 31 * result + (right != null ? right.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "left=" + left +
                ", right=" + right +
                '}';
    }
}
