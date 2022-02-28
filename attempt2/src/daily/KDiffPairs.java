package daily;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class KDiffPairs {
    class Pair {
        private int x;
        private int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pairs = (Pair) o;
            return (x == pairs.x && y == pairs.y) || (x == pairs.y && y == pairs.x);
        }

        @Override
        public int hashCode() {
            return Objects.hash(x + y);
        }
    }

    public int findPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Set<Pair> result = new HashSet<>();

        if (k == 0) {
            for (int n : nums) {
                if (set.contains(n))
                    result.add(new Pair(n, n));
                set.add(n);
            }
            return result.size();
        }
        for (int n : nums)
            set.add(n);
        for (int n : nums) {
            if (set.contains(n + k)) {
                result.add(new Pair(n, n + k));
            } else if (set.contains(n - k)) {
                result.add(new Pair(n, n - k));
            }
        }
        return result.size();
    }

    public static void main(String[] args) {
        KDiffPairs kDiffPairs = new KDiffPairs();
        int nums[] = {1, 3, 1, 5, 4}, k = 0;
        System.out.println(kDiffPairs.findPairs(nums, k));
    }
}
