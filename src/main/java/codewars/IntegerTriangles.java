package codewars;

import java.util.stream.IntStream;

/**
 * Created by Chethan on 9/10/16.
 */
//TODO: Not complete
public class IntegerTriangles {

    //http://www.had2know.com/academics/integer-triangles-120-degree-angle.html
    public static int getTriangles(int perimeter) {
        return (int) IntStream.range(2, perimeter / 5)
                .mapToLong(m -> IntStream.range(1, m)
                        .filter(n -> checkPerimeter(m, n, perimeter)).count()).sum();
    }

    private static boolean checkPerimeter(int m, int n, int perimeter) {
        return perimeter >= ((3 * m * n) + (2 * m * m) + (n * n));
    }


}
