package seanp;

public class PalindromeLinkedList {
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

    ListNode left;

    public boolean isPalindrome(ListNode head) {
        left = head;
        return isPalindromeUtil(head);
    }

    private boolean isPalindromeUtil(ListNode right) {
        if (right.next != null)
            return isPalindromeUtil(right.next);
        boolean isPalin = (left.val == right.val);
        if (isPalin) {
            left = left.next;
            return true;
        }
        return false;
    }
}
