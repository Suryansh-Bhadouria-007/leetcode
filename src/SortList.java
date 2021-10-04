import java.util.Comparator;
import java.util.PriorityQueue;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class SortList {
    public ListNode sortList(ListNode head) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        ListNode tmp = head;
        while (tmp != null) {
            pq.add(tmp.val);
            tmp = tmp.next;
        }
        ListNode node = new ListNode();
        ListNode dummyHead = node;
        while (!pq.isEmpty()) {
            node.next = new ListNode(pq.poll());
            node = node.next;
        }
        return dummyHead.next;
    }
}
