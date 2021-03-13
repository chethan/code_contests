package leetcode.heap;

import java.util.Comparator;
import java.util.PriorityQueue;

public class ClosestPointToOrigin {

    //https://leetcode.com/problems/k-closest-points-to-origin/
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Point> maxHeap = new PriorityQueue<Point>(K + 1, Comparator.reverseOrder());
        for (int i = 0; i < points.length; i++) {
            maxHeap.add(new Point(points[i][0], points[i][1]));
            if (maxHeap.size() > K) {
                maxHeap.poll();
            }
        }

        int[][] closePoints = new int[maxHeap.size()][2];
        for (int i = 0; i < closePoints.length; i++) {
            Point point = maxHeap.poll();
            closePoints[i][0] = point.x;
            closePoints[i][1] = point.y;
        }
        return closePoints;
    }

    private static class Point implements Comparable<Point> {

        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public double distance() {
            return Math.sqrt(x * x + y * y);
        }

        @Override
        public int compareTo(Point o) {
            return Double.compare(distance(), o.distance());
        }
    }
}
