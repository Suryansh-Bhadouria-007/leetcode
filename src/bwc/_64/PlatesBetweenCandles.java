package bwc._64;

public class PlatesBetweenCandles {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int ans[] = new int[queries.length];
        int left[] = new int[s.length()];
        int right[] = new int[s.length()];
        int candleIndex = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '|')
                candleIndex = i;
            else if (s.charAt(i) == '*') {
                left[i] = candleIndex;
            }
        }
        candleIndex = -1;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '|')
                candleIndex = i;
            else if (s.charAt(i) == '*') {
                right[i] = candleIndex;
            }
        }
        int idx = 0;
        for (int query[] : queries) {
            int count = 0;
            for (int i = query[0]; i <= query[1]; i++) {
                if (s.charAt(i) == '*') {
                    if (left[i] != -1 && left[i] >= query[0] && right[i] != -1 && right[i] <= query[1])
                        count++;
                }
            }
            ans[idx++] = count;
        }
        return ans;
    }
}
