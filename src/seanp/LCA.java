package seanp;

import seanp.util.TreeNode;

public class LCA {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lcaUtil(root, p, q);
    }

    private TreeNode lcaUtil(TreeNode node, TreeNode p, TreeNode q) {
        if (node == null)
            return null;
        if (node == p || node == q)
            return node;
        TreeNode leftLCA = lcaUtil(node.getLeft(), p, q);
        TreeNode rightLCA = lcaUtil(node.getRight(), p, q);
        if (leftLCA != null && rightLCA != null)
            return node;
        return leftLCA != null ? leftLCA : rightLCA;
    }
}
