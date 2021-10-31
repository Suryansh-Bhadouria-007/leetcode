package seanp;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1)
            return nums.length;
        Arrays.sort(nums);
        int length = removeDuplicates(nums);
        if (length <= 1)
            return length;
        int currentDiff = 0;
        int previousDiff = 0;
        int start = 0;
        int end = 1;
        int longestConsecutiveLength = Integer.MIN_VALUE;
        while (end < length) {
            currentDiff = nums[end] - nums[end - 1];
            if (currentDiff == previousDiff) {
                int currentSubLength = end - start + 1;
                if (currentSubLength > longestConsecutiveLength)
                    longestConsecutiveLength = currentSubLength;
                end++;
            } else {
                previousDiff = currentDiff;
                start = end - 1;
            }
        }
        return longestConsecutiveLength;
    }

    private int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}
