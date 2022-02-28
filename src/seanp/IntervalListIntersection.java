package seanp;

import java.util.ArrayList;
import java.util.List;

public class IntervalListIntersection {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        int f = 0;
        int s = 0;
        List<int[]> l = new ArrayList<>();

        while (f < firstList.length && s < secondList.length) {
            int[] overlapSection = getOverlapSection(firstList[f], secondList[s]);
            if (overlapSection[0] != -1) {
                l.add(overlapSection);
            }
            if (firstList[f][1] < secondList[s][1]) {
                f++;
            } else if (firstList[f][1] > secondList[s][1]) {
                s++;
            } else {
                f++;
                s++;
            }
        }
        int[][] objects = l.toArray(new int[l.size()][2]);
        return objects;
    }

    private int[] getOverlapSection(int a[], int b[]) {
        //no overlap
        if (a[0] > b[1] || b[0] > a[1])
            return new int[]{-1, -1};
        int low = Math.max(a[0], b[0]);
        int high = Math.min(a[1], b[1]);
        return new int[]{low, high};
    }

    public static void main(String[] args) {
        int firstList[][] = {{0, 2}, {5, 10}, {13, 23}, {24, 25}};
        int secondList[][] = {{1, 5}, {8, 12}, {15, 24}, {25, 26}};
        IntervalListIntersection intervalListIntersection = new IntervalListIntersection();
        int[][] ints = intervalListIntersection.intervalIntersection(firstList, secondList);
        for (int i[] : ints) {
            System.out.println(i[0] + "," + i[1]);
        }
    }
}
