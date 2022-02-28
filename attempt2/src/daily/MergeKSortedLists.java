package daily;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public class ListNode {
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

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode head : lists) {
            pq.add(head);
        }
        ListNode dummyHead = new ListNode();
        ListNode head = new ListNode();
        dummyHead.next = head;
        while (!pq.isEmpty()) {
            ListNode poll = pq.poll();
            if (poll.next != null)
                pq.add(poll.next);
            head.next = new ListNode(poll.val);
            head = head.next;
        }
        return dummyHead.next;
    }
}