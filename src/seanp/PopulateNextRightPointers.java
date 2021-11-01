package seanp;

import java.util.ArrayDeque;
import java.util.Queue;

public class PopulateNextRightPointers {
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> q = new ArrayDeque<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int size = q.size();
            Node prev = null;
            for (int i = 0; i < size; i++) {
                Node node = q.poll();
                if (prev != null)
                    prev.next = node;
                prev = node;
                if (node.left != null)
                    q.offer(node.left);
                if (node.right != null)
                    q.offer(node.right);
            }
        }
        return root;
    }
}
