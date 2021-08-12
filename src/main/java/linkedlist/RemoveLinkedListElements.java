package linkedlist;

import model.ListNode;

public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;
		ListNode cur = head;
		ListNode prev = dummy;
		while (cur != null) {
			if (cur.val != val) {
				prev = cur;
			} else {
				prev.next = cur.next;
			}
			cur = cur.next;
		}
		return dummy.next;
	}
}
