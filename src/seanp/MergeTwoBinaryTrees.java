package seanp;

import seanp.util.TreeNode;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        return mergeTreesUtil(root1, root2, null);
    }

    public TreeNode mergeTreesUtil(TreeNode root1, TreeNode root2, TreeNode root) {
        if (root1 == null && root2 == null)
            return null;
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;
        int newVal = root1.val + root2.val;
        if (root == null)
            root = new TreeNode(newVal);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
