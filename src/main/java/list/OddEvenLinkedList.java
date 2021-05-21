package list;

import model.ListNode;

public class OddEvenLinkedList {
	/*
	 * Given the head of a singly linked list, group all the nodes with odd
	 * indices together followed by the nodes with even indices, and return the
	 * reordered list.
	 *
	 * The first node is considered odd, and the second node is even, and so on.
	 *
	 * Note that the relative order inside both the even and odd groups should
	 * remain as it was in the input.
	 *
	 *
	 *
	 */

	// O(N)
	public ListNode oddEvenList(ListNode head) {
		if (head == null)
			return head;
		ListNode evenHead = head.next;
		ListNode oddCur = head;
		ListNode evenCur = evenHead;
		while (evenCur != null && evenCur.next != null) {
			oddCur.next = evenCur.next;
			oddCur = oddCur.next;
			evenCur.next = oddCur.next;
			evenCur = evenCur.next;
		}
		oddCur.next = evenHead;
		return head;
	}
}
