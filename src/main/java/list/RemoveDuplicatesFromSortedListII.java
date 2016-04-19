package list;

import model.ListNode;

/*

 Given a sorted linked list, delete all nodes that have duplicate numbers,
 leaving only distinct numbers from the original list.

 For example,
 Given 1->2->3->3->4->4->5, return 1->2->5.
 Given 1->1->1->2->3, return 2->3.

 */

public class RemoveDuplicatesFromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode dummy = new ListNode(0);
		dummy.next = head;

		ListNode prev = dummy;
		ListNode cur = head;
		ListNode iter = head;

		while (iter != null) {
			boolean dup = false;
			while (iter.next != null && iter.val == iter.next.val) {
				dup = true;
				iter = iter.next;
			}
			iter = iter.next;
			if (dup) {
				prev.next = iter;
				cur = iter;
			} else {
				prev.next = cur;
				prev = cur;
				cur = iter;
			}
		}

		return dummy.next;
	}
}
