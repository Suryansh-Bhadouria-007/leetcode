import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ShuffleArray {
    private int[] copy;
    private int length;
    private Random random;

    public ShuffleArray(int[] nums) {
        this.length = nums.length;
        this.copy = Arrays.copyOf(nums, nums.length);
        this.random = new Random();
    }

    /**
     * Resets the array to its original configuration and return it.
     */
    public int[] reset() {
        return this.copy;
    }

    /**
     * Returns a random shuffling of the array.
     */
    public int[] shuffle() {
        int shuffled[] = new int[this.length];
        Set<Integer> processedIndices = new HashSet<>();
        int i = 0;
        while (true) {
            int index = this.random.nextInt(this.length);
            if (processedIndices.contains(index))
                continue;
            processedIndices.add(index);
            shuffled[i++] = this.copy[index];
            if (i == this.length)
                break;
        }
        return shuffled;
    }
}
