package seanp;

public class UniquePaths {
    int memo[][];

    public int uniquePaths(int m, int n) {
        memo = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                memo[i][j] = -1;
            }
        }
        return uniquePathsUtil(0, 0, m, n);
    }

    private int uniquePathsUtil(int i, int j, int m, int n) {
        if (i == m - 1 || j == n - 1)
            return 1;
        if (i > m || j > n)
            return 0;
        if (memo[i][j] != -1)
            return memo[i][j];
        memo[i][j] = uniquePathsUtil(i + 1, j, m, n) + uniquePathsUtil(i, j + 1, m, n);
        return memo[i][j];
    }
}
