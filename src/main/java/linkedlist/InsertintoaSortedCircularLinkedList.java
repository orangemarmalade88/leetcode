package linkedlist;

import model.Node;

public class InsertintoaSortedCircularLinkedList {
	public Node insert(Node head, int insertVal) {
		Node ins = new Node(insertVal);
		if (head == null) {
			ins.next = ins;

			return ins;
		}

		Node cur = head.next;
		Node prev = head;

		do {
			if (prev.val <= insertVal && cur.val >= insertVal) {
				prev.next = ins;
				ins.next = cur;
				return head;
			}
			if (prev.val > cur.val
					&& (insertVal >= prev.val || insertVal <= cur.val)) {
				prev.next = ins;
				ins.next = cur;
				return head;
			}

			prev = prev.next;
			cur = cur.next;
		} while (prev != head);

		ins.next = head.next;
		head.next = ins;
		return head;
	}
}
