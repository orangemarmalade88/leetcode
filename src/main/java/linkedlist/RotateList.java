package linkedlist;

import model.ListNode;

public class RotateList {
	public ListNode rotateRight(ListNode head, int k) {
		if (head == null)
			return null;
		int size = getSize(head);
		if (k > size)
			k = k % size;
		if (k == 0)
			return head;
		ListNode cur = head;
		ListNode newHead;
		ListNode tail;

		for (int i = 0; i < size - k - 1; i++) {
			cur = cur.next;
		}
		tail = cur;
		newHead = cur.next;
		while (cur.next != null)
			cur = cur.next;
		cur.next = head;
		tail.next = null;
		return newHead;
	}

	int getSize(ListNode head) {
		int size = 0;
		while (head != null) {
			head = head.next;
			size++;
		}
		return size;
	}
}
