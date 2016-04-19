package list;

import model.ListNode;

/*

 Given a singly linked list L: L0->L1->...->Ln-1->Ln,
 reorder it to: L0->Ln->L1->Ln-1->L2->Ln-2 ...­

 You must do this in-place without altering the nodes' values.

 For example,
 Given {1,2,3,4}, reorder it to {1,4,2,3}.

 */

public class ReorderList {
	public void reorderList(ListNode head) {

		if (head == null)
			return;

		// find middle node
		ListNode slow = head;
		ListNode fast = head;

		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		// reverse second half
		ListNode headRev = reverse(slow);

		// link together
		while (head != null && headRev != null) {
			ListNode next = head.next;
			ListNode nextRev = headRev.next;
			head.next = headRev;
			headRev.next = next;
			head = next;
			headRev = nextRev;
		}
	}

	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while (head != null) {
			ListNode next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}
		return prev;
	}
}
