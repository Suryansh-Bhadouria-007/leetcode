package seanp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public class TreeNode {
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

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rsv = new ArrayList<>();
        if (root == null)
            return rsv;
        Queue<TreeNode> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if (i == size - 1)
                    rsv.add(node.val);
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        return rsv;
    }

    private int maxLevel = Integer.MIN_VALUE;

    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> rsv = new ArrayList<>();
        if (root == null)
            return rsv;
        rsvUtil(root, 0, rsv);
        return rsv;
    }

    private void rsvUtil(TreeNode node, int level, List<Integer> rsv) {
        if (node == null)
            return;
        if (level > maxLevel) {
            maxLevel = level;
            rsv.add(node.val);
        }
        rsvUtil(node.right, level + 1, rsv);
        rsvUtil(node.left, level + 1, rsv);
    }
}
