package linkedlist;

import model.ListNode;

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int carry = 0;
		ListNode dummy = new ListNode(0);
		ListNode cur = dummy;
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
			cur.next = new ListNode(val % 10);
			carry = val / 10;
			cur = cur.next;
		}
		return dummy.next;
	}
}
