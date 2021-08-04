package linkedlist;

import model.ListNode;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null)
			return head;
		ListNode next = head.next;
		ListNode res = reverseList(next);
		next.next = head;
		head.next = null;
		return res;
	}

	public ListNode reverseList2(ListNode head) {
		ListNode prev = null;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		return prev;
	}
}
