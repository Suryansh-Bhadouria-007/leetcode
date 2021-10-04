import java.util.*;
import java.util.stream.Collectors;

public class VerticalTreeTraversal {
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

    class RowValWrapper implements Comparable {
        int val;
        int row;

        public RowValWrapper(int val, int row) {
            this.val = val;
            this.row = row;
        }

        @Override
        public int compareTo(Object o) {
            RowValWrapper that = (RowValWrapper) o;
            if (this.row != that.row) {
                return this.row < that.row ? -1 : 1;
            } else {
                return this.val < that.val ? -1 : 1;
            }
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, PriorityQueue<RowValWrapper>> treeMap = new TreeMap<>();
        verticalTraversalUtil(root, treeMap, 0, 0);
        List<PriorityQueue<RowValWrapper>> es = new ArrayList<>(treeMap.values());
        List<List<Integer>> result = new ArrayList<>();
        for (PriorityQueue<RowValWrapper> queue : es) {
            List<Integer> internalList = new ArrayList<>();
            while (!queue.isEmpty()) {
                internalList.add(queue.remove().val);
            }
            result.add(internalList);
        }
        return result;
    }

    private void verticalTraversalUtil(TreeNode node, Map<Integer, PriorityQueue<RowValWrapper>> treeMap, int col, int row) {
        if (node == null)
            return;
        treeMap.computeIfAbsent(col, k -> new PriorityQueue<>()).add(new RowValWrapper(node.val, row));
        verticalTraversalUtil(node.left, treeMap, col - 1, row + 1);
        verticalTraversalUtil(node.right, treeMap, col + 1, row + 1);
    }
}
