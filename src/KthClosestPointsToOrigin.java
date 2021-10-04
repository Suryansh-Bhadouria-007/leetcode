import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthClosestPointsToOrigin {
    public static void main(String[] args) {
        int points[][] = new int[2][2];
        int k = 2;
        points[0] = new int[]{0, 1};

        points[1] = new int[]{1, 0};
        KthClosestPointsToOrigin kthClosestPointsToOrigin = new KthClosestPointsToOrigin();
        int[][] closest = kthClosestPointsToOrigin.kClosest(points, k);
        for (int close[] : closest) {
            Arrays.stream(close).forEach(x -> System.out.print(x + "\t"));
            System.out.println();
        }
    }

    class Point implements Comparable {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Object o) {
            Point that = (Point) o;
            return (this.x * this.x + this.y * this.y) - (that.x * that.x + that.y * that.y);
        }
    }

    public int[][] kClosest(int[][] points, int k) {
//        if (k == points.length)
//            return points;
        PriorityQueue<Point> pq = new PriorityQueue<>(Comparator.reverseOrder());
        for (int point[] : points) {
            if (pq.size() > k) {
                pq.poll();
            }
            pq.add(new Point(point[0], point[1]));
        }
        if (pq.size() > k)
            pq.poll();

        int[][] result = new int[k][2];
        int i = 0;
        while (!pq.isEmpty()) {
            Point p = pq.poll();
            int point[] = new int[2];
            point[0] = p.x;
            point[1] = p.y;
            result[i++] = point;
        }
        return result;
    }
}
