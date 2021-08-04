package linkedlist;

import java.util.ArrayList;
import java.util.List;

import model.ListNode;

public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		List<Integer> l = new ArrayList<>();
		while (head != null) {
			l.add(head.val);
			head = head.next;
		}
		int slow = 0;
		int fast = l.size() - 1;
		while (slow < fast) {
			if (l.get(slow++) != l.get(fast--))
				return false;
		}
		return true;
	}
}
