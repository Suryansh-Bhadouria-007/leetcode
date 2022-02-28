package daily;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class EarliestAcquaintance {
    private class DSU {
        private final int[] representative;
        private final int[] size;

        public DSU(int n) {
            this.representative = new int[n];
            this.size = new int[n];
            for (int i = 0; i < n; i++) {
                this.representative[i] = i;
                this.size[i] = 1;
            }
        }

        int find(int u) {
            if (u == representative[u])
                return u;

            else
                return representative[u] = find(representative[u]);
        }

        int combine(int u, int v) {
            u = find(u);
            v = find(v);

            if (u == v) {
                return size[u];
            } else {
                if (size[u] > size[v]) {
                    representative[v] = u;
                    size[u] += size[v];
                    return size[u];
                } else {
                    representative[u] = v;
                    size[v] += size[u];
                    return size[v];
                }
            }
        }
    }


    public int earliestAcq(int[][] logs, int n) {
        if (logs.length == 0 && n != 0)
            return -1;
        Arrays.sort(logs, Comparator.comparingInt(a -> a[0]));
        DSU dsu = new DSU(n);
        for (int[] log : logs) {
            int ts = log[0];
            int p1 = log[1];
            int p2 = log[2];

            int combinedSize = dsu.combine(p1, p2);
            if (combinedSize == n)
                return ts;
        }
        return -1;
    }

    public static void main(String[] args) {
        EarliestAcquaintance ea = new EarliestAcquaintance();
        int logs[][] = {{9, 3, 0}, {0, 2, 1}, {8, 0, 1}, {1, 3, 2}, {2, 2, 0}, {3, 3, 1}};
        System.out.println(ea.earliestAcq(logs, 4));
    }
}
