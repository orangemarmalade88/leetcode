package linkedlist;

import model.ListNode;

public class MergekSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		if (lists.length == 0)
			return null;
		ListNode cur = lists[0];
		for (int i = 1; i < lists.length; i++) {
			cur = mergeLists(cur, lists[i]);
		}
		return cur;
	}

	public ListNode mergeLists(ListNode a, ListNode b) {
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
