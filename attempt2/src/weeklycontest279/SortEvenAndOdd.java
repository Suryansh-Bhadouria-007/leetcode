package weeklycontest279;

import java.util.Arrays;
import java.util.Collections;

public class SortEvenAndOdd {
    public int[] sortEvenOdd(int[] nums) {
        int even[] = getArray(nums, 0);
        int[] odd = getArray(nums, 1);
        Arrays.sort(even);
        int[] odds = Arrays.stream(odd).boxed()
                .sorted(Collections.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();
        int e = 0, o = 0;
        for (int i = 0; i < nums.length; i++) {
            if ((i & 1) == 1) {
                nums[i] = odds[o++];
            } else {
                nums[i] = even[e++];
            }
        }
        return nums;
    }

    private int[] getArray(int[] nums, int i) {
        int length = nums.length;
        int size = (length & 1) == 0 ? (length / 2) : ((i == 0) ? (length / 2 + 1) : length);
        int newArray[] = new int[size];
        for (int j = 0; i < length; i = i + 2, j++) {
            newArray[j] = nums[i];
        }
        return newArray;
    }

    public static void main(String[] args) {
        SortEvenAndOdd sortEvenAndOdd = new SortEvenAndOdd();
        int[] ints1 = {2, 1};
        int[] ints = sortEvenAndOdd.sortEvenOdd(ints1);
        for (int i : ints) {
            System.out.print(i + "\t");
        }

    }

}
