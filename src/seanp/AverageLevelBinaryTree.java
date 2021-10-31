package seanp;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class AverageLevelBinaryTree {
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

    class Solution {
        public List<Double> averageOfLevels(TreeNode root) {
            Queue<TreeNode> q = new ArrayDeque<>();
            q.add(root);
            List<Double> avgs = new ArrayList<>();
            while (!q.isEmpty()) {
                double sum = 0.0d;
                int size = q.size();
                for (int i = 0; i < size; i++) {
                    TreeNode poll = q.poll();
                    sum += poll.val;
                    if (poll.left != null)
                        q.add(poll.left);
                    if (poll.right != null)
                        q.add(poll.right);
                }
                avgs.add(sum / size);
            }
            return avgs;
        }

    }
}
