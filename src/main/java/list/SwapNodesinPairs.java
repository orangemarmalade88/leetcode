package list;

import model.ListNode;

/*

 Given a linked list, swap every two adjacent nodes and return its head.

 For example,
 Given 1->2->3->4, you should return the list as 2->1->4->3.

 Your algorithm should use only constant space.
 You may not modify the values in the list, only nodes itself can be changed.

 */

public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;
		dummy.next = head;

		while (current.next != null && current.next.next != null) {
			ListNode n1 = current.next;
			ListNode n2 = current.next.next;
			ListNode n3 = current.next.next.next;

			n1.next = n3;
			current.next = n2;
			n2.next = n1;
			current = n1;
		}

		return dummy.next;
	}
}
