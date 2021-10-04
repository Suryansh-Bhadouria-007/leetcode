
public class SortedArrayToBST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return bstUtil(nums, 0, nums.length - 1);
    }

    private TreeNode bstUtil(int nums[], int left, int right) {
        if (left > right)
            return null;
        if (left == right)
            return new TreeNode(nums[left]);
        int mid = left + (right - left) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = bstUtil(nums, left, mid - 1);
        root.right = bstUtil(nums, mid + 1, right);
        return root;
    }
}