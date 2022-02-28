package daily;

public class HiddenSequence {
    private int lower;
    private int upper;
    private int differences[];

    public int numberOfArrays(int[] differences, int lower, int upper) {
        int count = 0;
        this.lower = lower;
        this.upper = upper;
        this.differences = differences;
        for (int i = lower; i <= upper; i++) {
            if (dfs(i, 0)) {
//                System.out.println("index:" + i);
                count++;
            }
        }
        return count;
    }

    private boolean dfs(int currentVal, int currentIndex) {

        if (currentIndex == differences.length && currentVal >= this.lower && currentVal <= this.upper)
            return true;
        if (currentVal < this.lower || currentVal > this.upper)
            return false;
        return dfs(currentVal + differences[currentIndex], currentIndex + 1);
    }

    public static void main(String[] args) {
        HiddenSequence hs = new HiddenSequence();
        int diff[] = {1, -3, 4};
        System.out.println(hs.numberOfArrays(diff, 1, 6));
    }
}
