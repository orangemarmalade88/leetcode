package linkedlist;

import model.ListNode;

public class AddTwoNumbersII {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		l1 = reverse(l1);
		l2 = reverse(l2);
		return reverse(add(l1, l2));
	}

	public ListNode reverse(ListNode l) {
		if (l == null || l.next == null)
			return l;
		ListNode next = l.next;
		ListNode res = reverse(next);
		next.next = l;
		l.next = null;
		return res;
	}

	public ListNode add(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
		int carry = 0;
		while (l1 != null || l2 != null || carry != 0) {
			int val = carry;
			if (l1 != null) {
				val += l1.val;
				l1 = l1.next;
			}
			if (l2 != null) {
				val += l2.val;
				l2 = l2.next;
			}
			ListNode n = new ListNode(val % 10);
			carry = val / 10;
			cur.next = n;
			cur = n;
		}
		return dummy.next;
	}
}
