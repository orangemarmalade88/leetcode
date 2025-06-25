package linkedlist;

import model.ListNode;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return null;
        }

        ListNode beforeHead = new ListNode(0);
        ListNode before = beforeHead;
        ListNode afterHead = new ListNode(0);
        ListNode after = afterHead;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            } else {
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null; // terminate the 'after' list
        before.next = afterHead.next; // connect the two lists

        return beforeHead.next; // return the merged list starting from the
                                // first node
    }
}
