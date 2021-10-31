package seanp;

import seanp.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ZigZagTraversalOfBinaryTree {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.add(root);

        while (!s1.isEmpty() || !s2.isEmpty()) {
            List<Integer> currentLevel = new ArrayList<>();
            while (!s1.isEmpty()) {
                TreeNode pop = s1.pop();
                currentLevel.add(pop.getVal());
                if (pop.getRight() != null)
                    s2.add(pop.getRight());
                if (pop.getLeft() != null)
                    s2.add(pop.getLeft());
            }
            if (currentLevel.size() > 0)
                result.add(currentLevel);
            currentLevel = new ArrayList<>();
            while (!s2.isEmpty()) {
                TreeNode pop = s2.pop();
                currentLevel.add(pop.getVal());
                if (pop.getLeft() != null)
                    s1.add(pop.getLeft());
                if (pop.getRight() != null)
                    s1.add(pop.getRight());
            }
            if (currentLevel.size() > 0)
                result.add(currentLevel);
        }
        return result;
    }
}
