package list;

import model.ListNode;

/*

 Given a sorted linked list, delete all duplicates such that each element appear only once.

 For example,
 Given 1->1->2, return 1->2.
 Given 1->1->2->3->3, return 1->2->3.

 */

public class RemoveDuplicatesfromSortedList {
	public ListNode deleteDuplicates(ListNode head) {

		if (head == null)
			return null;

		ListNode slow = head;
		ListNode fast = head.next;

		while (fast != null) {
			if (slow.val == fast.val) {
				fast = fast.next;
			} else {
				slow.next = fast;
				slow = fast;
				fast = fast.next;
			}

		}

		slow.next = null;

		return head;

	}
}
