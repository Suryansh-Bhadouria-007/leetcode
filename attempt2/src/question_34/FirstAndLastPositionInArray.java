package question_34;

public class FirstAndLastPositionInArray {
    public int[] searchRange(int[] nums, int target) {
        int result[] = {-1, -1};
        if (null == nums || nums.length == 0)
            return result;
        if (target < nums[0] || target > nums[nums.length - 1])
            return result;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                if (result[0] == -1)
                    result[0] = i;
                result[1] = i;
            }
        }
        return result;
    }

    public int[] searchRangeBinary(int[] nums, int target) {
        int result[] = {-1, -1};
        if (null == nums || nums.length == 0)
            return result;
        if (target < nums[0] || target > nums[nums.length - 1])
            return result;
        if (nums.length == 1) {
            return nums[0] != target ? result : new int[]{0, 0};
        }
        int found = binarySearch(nums, target, 0, nums.length - 1);
        if (found == -1)
            return result;
        int start = found, end = found;
        for (start = found; start >= 0; start--) {
            if (nums[start] != target)
                break;
        }
        for (end = found; end < nums.length; end++) {
            if (nums[end] != target)
                break;
        }
        return new int[]{++start, --end};
    }


    private int binarySearch(int nums[], int target, int low, int high) {
        boolean found = false;
        int mid = -1;
        while (low < high) {
            mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                found = true;
                break;
            } else if (nums[mid] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }
        if (!found)
            return -1;
        return mid;
    }

    public static void main(String[] args) {
        FirstAndLastPositionInArray firstAndLastPositionInArray = new FirstAndLastPositionInArray();
        int nums[] = new int[]{5, 7, 7, 8, 8, 10};
        int result[] = firstAndLastPositionInArray.searchRangeBinary(nums, 8);
        System.out.println(result[0] + "," + result[1]);
    }
}
