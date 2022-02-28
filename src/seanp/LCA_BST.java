package seanp;

import seanp.util.TreeNode;

public class LCA_BST {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaUtil(root, p, q);
    }

    private TreeNode lcaUtil(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        if (node.val > p.val && node.val > q.val)
            return lcaUtil(node.left, p, q);
        if (node.val < p.val && node.val < q.val)
            return lcaUtil(node.right, p, q);
        return node;
    }
}
