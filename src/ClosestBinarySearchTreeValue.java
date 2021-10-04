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

public class ClosestBinarySearchTreeValue {
    class Answer {
        int value;

        public Answer(int value) {
            this.value = value;
        }
    }

    public int closestValue(TreeNode root, double target) {
        Answer closest = new Answer(root.val);
        closestValueUtil(root, target, closest);
        return closest.value;
    }

    private void closestValueUtil(TreeNode node, double target, Answer closest) {
        if (node == null)
            return;
        if (Math.abs(target - (double) node.val) < Math.abs(target - (double) closest.value)) {
            closest.value = node.val;
        }
        if (target < node.val)
            closestValueUtil(node.left, target, closest);
        else
            closestValueUtil(node.right, target, closest);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode();
        root.val = 1;
        root.right = new TreeNode(2);
        ClosestBinarySearchTreeValue closestBinarySearchTreeValue = new ClosestBinarySearchTreeValue();
        System.out.println(closestBinarySearchTreeValue.closestValue(root, 3.428571));
    }

}
