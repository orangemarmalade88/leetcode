package list;

import model.ListNode;

public class ReverseLinkedList {
	public ListNode reverseList(ListNode head) {

		ListNode prev = null;
		ListNode current = head;

		while (current != null) {
			ListNode next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}

		return prev;

	}

	public ListNode reverseList2(ListNode head) {

		if (head == null || head.next == null)
			return head;

		ListNode second = head.next;
		ListNode newHead = reverseList2(second);

		second.next = head;
		head.next = null;
		return newHead;
	}
}
