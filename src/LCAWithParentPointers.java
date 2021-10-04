// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
}


class LCAWithParentPointers {
    public Node lowestCommonAncestor(Node p, Node q) {
        int depthP = getDepth(p);
        int depthQ = getDepth(q);
        if (depthP > depthQ) {
            int diff = depthP - depthQ;
            while (diff-- > 0) {
                p = p.parent;
            }
        } else {
            int diff = depthQ - depthP;
            while (diff-- > 0) {
                q = q.parent;
            }
        }
        while (p != q) {
            p = p.parent;
            q = q.parent;
        }
        return p;
    }

    private int getDepth(Node node) {
        if (node == null)
            return 0;
        Node tmp = node;
        int height = 0;
        while (tmp != null) {
            tmp = tmp.parent;
            height++;
        }
        return height;
    }
}