package seanp;

public class MinDepthBinaryTree {
    class TreeNode {
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

    private int minDepth = Integer.MAX_VALUE;

    public int minDepth(TreeNode root) {
        if (root == null)
            return 0;
        traverse(root, 0);
        return minDepth;
    }

    private void traverse(TreeNode node, int currentDepth) {
        if (node == null)
            return;
        if (node.left == null && node.right == null) {
            if (currentDepth < minDepth) {
                minDepth = currentDepth;
            }
            return;
        }
        traverse(node.left, currentDepth + 1);
        traverse(node.right, currentDepth + 1);
    }
}
