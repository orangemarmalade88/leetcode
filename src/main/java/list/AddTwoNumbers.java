package list;

import model.ListNode;

/*

 You are given two linked lists representing two non-negative numbers.
 The digits are stored in reverse order and each of their nodes contain a single digit.
 Add the two numbers and return it as a linked list.

 Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 Output: 7 -> 0 -> 8

 */

public class AddTwoNumbers {
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		boolean carry_over = false;

		while (l1 != null && l2 != null) {
			int sum = l1.val + l2.val;
			if (carry_over)
				sum += 1;
			carry_over = sum >= 10;
			sum = sum % 10;

			current.next = new ListNode(sum);
			current = current.next;

			l1 = l1.next;
			l2 = l2.next;
		}

		while (l1 != null) {
			int sum = l1.val;
			if (carry_over)
				sum += 1;
			carry_over = sum >= 10;
			sum = sum % 10;

			current.next = new ListNode(sum);
			current = current.next;

			l1 = l1.next;
		}

		while (l2 != null) {
			int sum = l2.val;
			if (carry_over)
				sum += 1;
			carry_over = sum >= 10;
			sum = sum % 10;

			current.next = new ListNode(sum);
			current = current.next;

			l2 = l2.next;
		}

		if (carry_over) {
			current.next = new ListNode(1);
			current = current.next;
		}

		return dummy.next;
	}

	public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		int carry = 0;

		while (l1 != null || l2 != null) {
			// Even better: combine the logic into l1!=null, l2!=null
			if (l1 == null) {
				carry = l2.val + carry;
				l2 = l2.next;
			} else if (l2 == null) {
				carry = l1.val + carry;
				l1 = l1.next;
			} else {
				carry = l1.val + l2.val + carry;
				l1 = l1.next;
				l2 = l2.next;
			}
			current.next = new ListNode(carry % 10);
			current = current.next;
			carry = carry / 10;
		}

		if (carry == 1) {
			current.next = new ListNode(carry);
		}

		return dummy.next;
	}

	// Follow-up:

	// What if the digits are stored in regular order instead of reversed order?

	// Answer: We can simple reverse the list, calculate the result, and reverse
	// the result.
}
