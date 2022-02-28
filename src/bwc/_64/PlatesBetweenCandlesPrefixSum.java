package bwc._64;

public class PlatesBetweenCandlesPrefixSum {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        /*
    Approach:
    Create 3 arrays with below values:-
    Array containing the index of the nearest candle to the left side of the element
    Array containing the index of the nearest candle to the right side of the element
    Array containing the count of plates from start to till the index
    Now for each query we need to check the nearest candle on the right side to query[0] and the nearest candle on the left side to query[1]
    If these two candles are in the range query[0] and query[1] then we can consider the plat count between the these two candles otherwise the count will be 0
    */
        int leftCandleIndexArr[] = new int[s.length()];
        int rightCandleIndexArr[] = new int[s.length()];
        int plateCountArr[] = new int[s.length()];
        int count = 0;
        int ans[] = new int[queries.length];
        int candleLocation = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|') {
                candleLocation = i;
            } else if (s.charAt(i) == '*') {
                count++;
            }
            leftCandleIndexArr[i] = candleLocation;

            plateCountArr[i] = count;
        }
        candleLocation = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '|') {
                candleLocation = i;
            }
            rightCandleIndexArr[i] = candleLocation;
        }
        for (int i = 0; i < queries.length; i++) {
            int leftCandleIndex = leftCandleIndexArr[queries[i][1]];
            int rightCandleIndex = rightCandleIndexArr[queries[i][0]];
            if (leftCandleIndex == -1 || rightCandleIndex == -1 || leftCandleIndex < queries[i][0] || rightCandleIndex > queries[i][1]) {
                ans[i] = 0;
            } else {
                ans[i] = (plateCountArr[leftCandleIndex] - plateCountArr[rightCandleIndex]);
            }
        }
        return ans;
    }
}
