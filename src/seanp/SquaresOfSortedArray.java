package seanp;

public class SquaresOfSortedArray {
    public int[] sortedSquares(int[] nums) {
        int j = 0;
        for (; j < nums.length; j++) {
            if (nums[j] >= 0)
                break;
        }
        int i = j - 1;
        int squares[] = new int[nums.length];
        int k = 0;
        while (i >= 0 && j < nums.length) {
            int sq1 = nums[i] * nums[i];
            int sq2 = nums[j] * nums[j];
            squares[k++] = Math.min(sq1, sq2);
            if (sq1 < sq2)
                i--;
            else
                j++;
        }
        while (i >= 0) {
            squares[k++] = nums[i] * nums[i];
            i--;
        }
        while (j < nums.length) {
            squares[k++] = nums[j] * nums[j];
            j++;
        }
        return squares;
    }
}
