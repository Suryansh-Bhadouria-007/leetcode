/*
package dynamic.programming;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeMap;

public class DeleteAndEarn {
    private int nums[];
    private int maxPoints = Integer.MIN_VALUE;

    public int deleteAndEarn(int[] nums) {
        this.nums = nums;
        dp(0, new HashSet<Integer>(), 0);
        return maxPoints;
    }

    //max points which can be accumulated till current index
    private void dp(int i, Set<Integer> deleted, int currentPoints) {
        maxPoints = Math.max(maxPoints, currentPoints);
        if (i >= nums.length)
            return;

        if (deleted.contains(nums[i])) {
            dp(i + 1, new HashSet<>(deleted), currentPoints);
            return;
        }
        dp(i + 1, new HashSet<>(deleted), currentPoints);
        deleted.add(nums[i] + 1);
        deleted.add(nums[i] - 1);
        dp(i + 1, new HashSet<>(deleted), currentPoints + nums[i]);
    }

    public int deleteAndEarn2(int[] nums) {
        TreeMap<Integer, Integer> numberToValueMap = new TreeMap<>();
        for (int i : nums) {
            numberToValueMap.put(i, numberToValueMap.getOrDefault(i, 0) + i);
        }

    }
}
*/
