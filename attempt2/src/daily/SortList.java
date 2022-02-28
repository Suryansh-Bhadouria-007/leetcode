package daily;

import java.util.List;

public class SortList {
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

    public ListNode sortList(ListNode head) {
        if (head == null)
            return null;
        ListNode curr = head;
        while (true) {
            boolean swaps = false;
            while (curr.next != null) {
                int currVal = curr.val;
                int nextVal = curr.next.val;
                if (nextVal < currVal) {
                    swaps = true;
                    curr.val = nextVal;
                    curr.next.val = currVal;
                }
                curr = curr.next;
            }
            curr = head;
            if (!swaps)
                break;
        }
        return head;
    }
}
