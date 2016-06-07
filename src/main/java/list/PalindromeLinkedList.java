package list;

import model.ListNode;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {

		if (head == null)
			return false;

		// find middle
		ListNode slow = head;
		ListNode fast = head;
		while (fast.next != null && fast.next.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}

		return false;
	}
}
