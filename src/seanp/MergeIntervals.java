package seanp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        List<int[]> intervalsList = new ArrayList<>();
        Collections.addAll(intervalsList, intervals);
        Collections.sort(intervalsList, Comparator.comparingInt(a -> a[0]));
        List<int[]> mergedIntervals = new ArrayList<>();
        mergedIntervals.add(intervalsList.get(0));
        int index = 0;
        for (int i = 1; i < intervalsList.size(); i++) {
            int[] current = intervalsList.get(i);
            if (mergedIntervals.get(index)[1] >= current[0]) {
                //merge intervals
                mergedIntervals.get(index)[1] = Math.max(mergedIntervals.get(index)[1], current[1]);
            } else {
                mergedIntervals.add(current);
                index++;
            }
        }
        int mi[][] = new int[mergedIntervals.size()][2];
        return mergedIntervals.toArray(mi);
    }
}
