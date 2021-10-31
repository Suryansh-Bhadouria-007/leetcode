package seanp;

public class PathSum {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfsUtil(root, targetSum, 0);
    }

    private boolean dfsUtil(TreeNode node, int targetSum, int currentSum) {
        if (node == null)
            return false;
        currentSum += node.val;
        if ((node.left == null && node.right == null)) {
            if (currentSum == targetSum)
                return true;
        }
        return dfsUtil(node.left, targetSum, currentSum)
                || dfsUtil(node.right, targetSum, currentSum);
    }

    public boolean hasPathSum1(TreeNode root, int sum) {
        if (root == null)
            return false;

        sum -= root.val;
        if ((root.left == null) && (root.right == null))
            return (sum == 0);
        return hasPathSum1(root.left, sum) || hasPathSum1(root.right, sum);
    }

    public static void main(String[] args) {
        PathSum ps = new PathSum();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);

        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right = new TreeNode(7);

        boolean pathSumExists = ps.hasPathSum(root, 22);
        System.out.println(pathSumExists);
    }
}
