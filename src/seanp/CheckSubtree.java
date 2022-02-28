package seanp;

import seanp.util.TreeNode;

public class CheckSubtree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null)
            return true;
        if(root==null)
            return false;
        if(isIdentical(root,subRoot))
            return true;
        return isSubtree(root.left,subRoot) || isSubtree(root.right,subRoot);
    }

    private boolean isIdentical(TreeNode r1,TreeNode r2){
        if(r1==null && r2==null)
            return true;
        if(r1==null || r2==null)
            return false;
        return (r1.val==r2.val && isIdentical(r1.left,r2.left) && isIdentical(r1.right,r2.right));
    }
}
