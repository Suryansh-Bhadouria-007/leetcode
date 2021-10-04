import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class KthMissingPositiveInteger {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        Arrays.stream(arr).forEach(s -> set.add(s));
        int count = 0;
        for (int i = 1; i <= 1000; i++) {
            if (!set.contains(i)) {
                count++;
                if (count == k)
                    return i;
            }
        }
        return -1;
    }
}
