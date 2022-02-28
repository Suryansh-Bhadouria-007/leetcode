package problem26;

public class SortedArray1 {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length < 2)
            return length;
        int i = 0, j = 1;
        while (j < length) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }

    public static void main(String[] args) {
        SortedArray1 sortedArray1 = new SortedArray1();
        int[] ints = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int i = sortedArray1.removeDuplicates(ints);
        System.out.println(i);
    }
}
