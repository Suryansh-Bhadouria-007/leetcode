package daily;

public class HiddenSequence3 {
    public int numberOfArrays(int diff[], int lower, int upper) {
        long a = 0, ma = 0, mi = 0;
        for (int d : diff) {
            a += d;
            ma = Math.max(ma, a);
            mi = Math.min(mi, a);
        }
        int count = 0;
        for (int i = lower; i <= upper; i++) {
            if (i + mi >= lower && i + ma <= upper)
                count++;
        }
        return count;
    }
}
