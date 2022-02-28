package questions;

public class MaxProduct {
    public int maxProductDifference(int[] nums) {
        int maxA, maxB, minA, minB;
        maxA = Integer.MIN_VALUE;
        maxB = Integer.MIN_VALUE;

        minA = Integer.MAX_VALUE;
        minB = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > maxA) {
                maxB = maxA;
                maxA = nums[i];
            } else if (nums[i] > maxB) {
                maxB = nums[i];
            }
            if (nums[i] < minA) {
                minB = minA;
                minA = nums[i];
            } else if (nums[i] < minB) {
                minB = nums[i];
            }
        }
        return maxA * maxB - minA * minB;
    }

    public static void main(String[] args) {
        MaxProduct maxProduct = new MaxProduct();
        int nums[] = {4, 2, 5, 9, 7, 4, 8};
        System.out.println(maxProduct.maxProductDifference(nums));
    }
}
