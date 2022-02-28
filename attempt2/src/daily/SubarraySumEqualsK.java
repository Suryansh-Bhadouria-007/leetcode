package daily;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum == k)
                count++;
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k)
                    count++;
            }
        }
        return count;
    }


    public int subarraySumHM(int[] nums, int k) {
        Map<Integer, Integer> sumVsCountMap = new HashMap<>();
        int count = 0;
        int currentSum = 0;
        sumVsCountMap.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            Integer currentSumMinusKCount = sumVsCountMap.getOrDefault(currentSum - k, 0);
            if (currentSumMinusKCount > 0)
                count += currentSumMinusKCount;
            Integer currentSumCount = sumVsCountMap.getOrDefault(currentSum, 0);
            sumVsCountMap.put(currentSum, currentSumCount + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySumEqualsK ssek = new SubarraySumEqualsK();
        int nums[] = {1, 2, 3};
        System.out.println(ssek.subarraySum(nums, 3));
    }
}
