package seanp;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i <= n; i++)
            set.add(i);
        for (int i : nums) {
            set.remove(i);
        }
        return set.iterator().next();
    }
}
