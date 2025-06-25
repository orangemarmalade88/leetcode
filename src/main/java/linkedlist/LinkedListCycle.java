package linkedlist;

import model.ListNode;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next; // move slow by 1 step
            fast = fast.next.next; // move fast by 2 steps

            if (slow == fast) { // if they meet, there is a cycle
                return true;
            }
        }
        return false; // if fast reaches the end, there is no cycle
    }

}