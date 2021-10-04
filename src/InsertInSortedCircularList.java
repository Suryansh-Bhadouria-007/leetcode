class InsertInSortedCircularList {

    // Definition for a Node.
    static class Node {
        public int val;
        public Node next;

        public Node() {
        }

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _next) {
            val = _val;
            next = _next;
        }
    }

    public Node insert(Node head, int insertVal) {
        Node newNode = new Node(insertVal);
        if (head == null) {
            newNode.next = newNode;
            head = newNode;
            return head;
        }
        Node prev = null;
        Node current = head;
        do {
            if (prev != null && (prev.val > current.val)) {
                //inflection point
                if (insertVal >= prev.val || insertVal <= current.val) {
                    //insert between prev and current
                    break;
                }
            } else if (prev != null) {
                if (insertVal >= prev.val && insertVal <= current.val)
                    break;
            }
            Node tmp = current.next;
            prev = current;
            current = tmp;
        } while (current != head);
        newNode.next = current;
        if (prev != null)
            prev.next = newNode;
        else
            current.next = newNode;
        return head;
    }

    public static void main(String[] args) {
        InsertInSortedCircularList insertInSortedCircularList = new InsertInSortedCircularList();
        Node head = new Node(3);
        head.next = new Node(4);
        head.next.next = new Node(1);
        head.next.next.next = head;
        Node pre = head;
        do {
            System.out.print(pre.val + "\t");
            pre = pre.next;
        } while (pre != head);
        System.out.println();
        Node insert = insertInSortedCircularList.insert(head, 2);
        Node tmp = insert;
        do {
            System.out.print(tmp.val + "\t");
            tmp = tmp.next;
        } while (tmp != insert);
    }
}