package seanp;

public class DuplicateNumber {
    public int findDuplicate(int[] nums) {
        int actualSum = 0;
        int expectedSum = 0;
        for (int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
            expectedSum += i;
        }
        return actualSum - expectedSum;
    }
}
