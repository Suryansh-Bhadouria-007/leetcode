package questions;

public class AddTwoNumbersinLL {
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

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int carry = 0;
            ListNode dummyHead = new ListNode();
            ListNode head = new ListNode();
            dummyHead.next = head;
            while (l1 != null || l2 != null) {
                int val1 = l1 != null ? l1.val : 0;
                int val2 = l2 != null ? l2.val : 0;
                int sum = (val1 + val2 + carry) % 10;
                carry = (val1 + val2 + carry) / 10;
                head.next = new ListNode(sum);
                head = head.next;
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;
            }
            if (carry != 0)
                head.next = new ListNode(carry);
            return dummyHead.next.next;
        }
    }
}
