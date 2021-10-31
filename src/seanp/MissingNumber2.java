package seanp;

public class MissingNumber2 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] < n) {
                int index;
                if (nums[i] > 0)
                    index = nums[i];
                else index = -1 * nums[i];
                nums[index] = -1 * nums[index];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                return i;
        }
        return n;
    }
}