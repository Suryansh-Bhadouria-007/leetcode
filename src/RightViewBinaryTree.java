import java.util.ArrayList;
import java.util.List;

public class RightViewBinaryTree {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        rightSideViewUtil(root, 0, -1, rightSide);
        return rightSide;
    }

    private void rightSideViewUtil(TreeNode node, int level, int maxLevel, List<Integer> rightSide) {
        if (node == null)
            return;
        if (level > maxLevel) {
            rightSide.add(node.val);
            maxLevel = level;
        }
        rightSideViewUtil(node.right, level + 1, maxLevel, rightSide);
        rightSideViewUtil(node.left, level + 1, maxLevel, rightSide);
    }
}
