package seanp;

public class MergeTwoSortedLists {
    static class ListNode {
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

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null)
            return l2;
        else if (l2 == null)
            return l1;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummyHead = new ListNode(-1);
        ListNode temp = dummyHead;
        while (curr1 != null && curr2 != null) {
            if (curr1.val < curr2.val) {
                dummyHead.next = curr1;
                curr1 = curr1.next;
            } else {
                dummyHead.next = curr2;
                curr2 = curr2.next;
            }
            dummyHead = dummyHead.next;
        }
        while (curr1 != null) {
            dummyHead.next = curr1;
            curr1 = curr1.next;
            dummyHead = dummyHead.next;
        }
        while (curr2 != null) {
            dummyHead.next = curr2;
            curr2 = curr2.next;
            dummyHead = dummyHead.next;
        }
        return temp.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        ListNode l2 = new ListNode(5);

        l1.next = new ListNode(3);
        l2.next = new ListNode(7);

        MergeTwoSortedLists mergeTwoSortedLists = new MergeTwoSortedLists();
        ListNode l = mergeTwoSortedLists.mergeTwoLists(l1, l2);
        while (l != null) {
            System.out.print(l.val + "\t");
            l = l.next;
        }
    }
}
