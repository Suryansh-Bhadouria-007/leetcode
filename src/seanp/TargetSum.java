package seanp;

public class TargetSum {
    class Count {
        int count = 0;
    }

    public int findTargetSumWays(int[] nums, int target) {
        Count count = new Count();
        backtrack(nums, 0, 0, target, count);
        return count.count;
    }

    private void backtrack(int nums[], int index, int curr, int target, Count count) {
        if (curr == target && index >= nums.length)
            count.count++;
        if (index == nums.length)
            return;
        backtrack(nums, index + 1, curr + nums[index], target, count);
        backtrack(nums, index + 1, curr - nums[index], target, count);
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        int ways = targetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3);
        System.out.println(ways);
    }
}
