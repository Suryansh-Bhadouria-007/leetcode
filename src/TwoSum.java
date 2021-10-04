import java.util.Arrays;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Arrays.sort(nums);
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == target)
                return new int[]{i, j};
            else if (sum > target)
                j--;
            else
                i++;
        }
        return new int[0];
    }
}
