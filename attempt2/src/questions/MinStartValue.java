package questions;

public class MinStartValue {
    public int minStartValue(int[] nums) {
        int min = Integer.MAX_VALUE;
        int startVal = 0;
        for (int n : nums) {
            startVal += n;
            min = Math.min(min, startVal);
        }
        return min > 0 ? 1 : (-1 * min + 1);
    }
}
