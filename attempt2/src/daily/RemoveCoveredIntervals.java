package daily;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveCoveredIntervals {
    public int removeCoveredIntervals(int[][] intervals) {
        Comparator<int[]> comparator = (o1, o2) -> {
            if (o1[0] != o2[0])
                return Integer.compare(o1[0], o2[0]);
            return Integer.compare(o2[1], o1[1]);
        };
        Arrays.sort(intervals, comparator);
        int coveredCount = 0;
        for (int i = 0, j = 1; i < intervals.length - 1 && j < intervals.length; ) {
            if (doesCover(intervals[i], intervals[j])) {
                coveredCount++;
            } else {
                i = j;
            }
            j++;
        }
        return intervals.length - coveredCount;
    }

    private boolean doesCover(int a[], int b[]) {
        return a[0] <= b[0] && a[1] >= b[1];
    }

    public static void main(String[] args) {
        RemoveCoveredIntervals removeCoveredIntervals = new RemoveCoveredIntervals();
        int intervals[][] = {{34335, 39239}, {15875, 91969}, {29673, 66453}, {53548, 69161}, {40618, 93111}};
        System.out.println(removeCoveredIntervals.removeCoveredIntervals(intervals));
    }
}
