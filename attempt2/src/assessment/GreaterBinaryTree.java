//package assessment;
//
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode() {
//    }
//
//    TreeNode(int val) {
//        this.val = val;
//    }
//
//    TreeNode(int val, TreeNode left, TreeNode right) {
//        this.val = val;
//        this.left = left;
//        this.right = right;
//    }
//}
//
//public class GreaterBinaryTree {
//    public TreeNode bstToGst(TreeNode root) {
//
//
//    }
//
//    int postOrder(TreeNode node, int parent) {
//        if (node == null)
//            return 0;
//        int rightTreeVal = postOrder(node.right, parent);
//        node.val += rightTreeVal + parent;
//        parent = node.val;
//        int leftTreeVal = postOrder(node.left, parent);
//        return node.val;
//    }
//}
