package list;

import model.ListNode;

/*

 Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists.

 */

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = l1;
				l1 = l1.next;
				current = current.next;
			} else {
				current.next = l2;
				l2 = l2.next;
				current = current.next;
			}
		}

		while (l1 != null) {
			current.next = l1;
			l1 = l1.next;
			current = current.next;
		}

		while (l2 != null) {
			current.next = l2;
			l2 = l2.next;
			current = current.next;
		}

		return dummy.next;
	}

	// Improvement: when one list completed, just link current node to the other
	// one and we're done
	public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				current.next = l1;
				l1 = l1.next;
				current = current.next;
			} else {
				current.next = l2;
				l2 = l2.next;
				current = current.next;
			}
		}

		if (l1 != null)
			current.next = l1;
		if (l2 != null)
			current.next = l2;

		return dummy.next;
	}
}
