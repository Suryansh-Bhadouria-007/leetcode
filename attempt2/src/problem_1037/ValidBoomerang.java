package problem_1037;

public class ValidBoomerang {
    public boolean isBoomerang(int[][] points) {
        if (points.length != 3)
            return false;
        if (duplicatePoints(points))
            return false;
        double slope1, slope2;
        slope1 = (points[1][0] - points[0][0]) != 0 ? ((double) (points[1][1] - points[0][1]) / (double) (points[1][0] - points[0][0])) : 0;
        slope2 = (points[2][0] - points[1][0]) != 0 ? ((double) (points[2][1] - points[1][1]) / (double) (points[2][0] - points[1][0])) : 0;
        return (slope1 != slope2);
    }

    private boolean duplicatePoints(int[][] points) {
        return (points[0][0] == points[1][0] && points[0][1] == points[1][1])
                || (points[0][0] == points[2][0] && points[0][1] == points[2][1])
                || (points[1][0] == points[2][0] && points[1][1] == points[2][1]);
    }

    public static void main(String[] args) {
        int[][] points = {{0, 1}, {0, 2}, {1, 2}};
        ValidBoomerang validBoomerang = new ValidBoomerang();
        System.out.println(validBoomerang.isBoomerang(points));
    }
}
