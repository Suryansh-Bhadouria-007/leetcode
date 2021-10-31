package seanp;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class PerfectSquares {
    static class Count {
        private int count;

        public Count(int count) {
            this.count = count;
        }
    }

    private Count minCount = new Count(Integer.MAX_VALUE);
    private int memo[][];

    public int numSquares(int n) {
        List<Integer> perfectSquares = getPerfectSquares(n);
        memo = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                memo[i][j] = -1;
            }
        }


        findNumSquaresUtil(n, perfectSquares, 0);
        return minCount.count;
    }

    private List<Integer> getPerfectSquares(int n) {
        LinkedList<Integer> perfectSquares = new LinkedList<>();
        for (int i = 1; i * i <= n; i++) {
            perfectSquares.addFirst(i * i);
        }
        return new ArrayList<>(perfectSquares);
    }

    private void findNumSquaresUtil(int n, List<Integer> perfectSquares, int count) {
        if (n < 0)
            return;
        if (n == 0) {
            if (count < minCount.count)
                minCount.count = count;
        }
        count++;
        for (int i = 0; i < perfectSquares.size(); i++) {
            findNumSquaresUtil(n - perfectSquares.get(i), perfectSquares, count);
        }
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        int count = perfectSquares.numSquares(47);
        System.out.println("Count: " + count);
    }
}
