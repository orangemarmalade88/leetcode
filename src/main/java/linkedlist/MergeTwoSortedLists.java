package linkedlist;

import model.ListNode;

public class MergeTwoSortedLists {
	public ListNode mergeTwoLists(ListNode a, ListNode b) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		while (a != null || b != null) {
			if (a == null) {
				cur.next = b;
				cur = b;
				b = b.next;
			} else if (b == null) {
				cur.next = a;
				cur = a;
				a = a.next;
			} else if (a.val <= b.val) {
				cur.next = a;
				cur = a;
				a = a.next;
			} else {
				cur.next = b;
				cur = b;
				b = b.next;
			}

		}
		return dummy.next;
	}
}
