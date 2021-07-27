package list;

import java.util.Deque;
import java.util.LinkedList;

public class PrintImmutableLinkedListInReverse {
	/*
	 * You are given an immutable linked list, print out all values of each node
	 * in reverse with the help of the following interface:
	 *
	 * ImmutableListNode: An interface of immutable linked list, you are given
	 * the head of the list. You need to use the following functions to access
	 * the linked list (you can't access the ImmutableListNode directly):
	 *
	 * ImmutableListNode.printValue(): Print value of the current node.
	 * ImmutableListNode.getNext(): Return the next node. The input is only
	 * given to initialize the linked list internally. You must solve this
	 * problem without modifying the linked list. In other words, you must
	 * operate the linked list using only the mentioned APIs.
	 *
	 *
	 */
	interface ImmutableListNode {
		public void printValue(); // print the value of this node.

		public ImmutableListNode getNext(); // return the next node.
	};

	// O(N) S(N) Iterative
	public void printLinkedListInReverse(ImmutableListNode head) {
		Deque<ImmutableListNode> stack = new LinkedList<>();
		while (head != null) {
			stack.push(head);
			head = head.getNext();
		}
		while (!stack.isEmpty()) {
			ImmutableListNode n = stack.pop();
			n.printValue();
		}
	}

	// O(N) S(N) Recursive
	public void printLinkedListInReverse2(ImmutableListNode head) {
		if (head == null)
			return;
		printLinkedListInReverse(head.getNext());
		head.printValue();
	}

	// O(N^2) S(1)
	public void printLinkedListInReverse3(ImmutableListNode head) {
		int n = getNodeCount(head);
		for (int i = n - 1; i >= 0; i--) {
			ImmutableListNode node = getNthNode(head, i);
			node.printValue();
		}
	}

	private int getNodeCount(ImmutableListNode head) {
		int res = 0;
		while (head != null) {
			head = head.getNext();
			res++;
		}
		return res;
	}

	private ImmutableListNode getNthNode(ImmutableListNode head, int n) {
		while (n-- > 0) {
			head = head.getNext();
		}
		return head;
	}

	// O(NlogN), S(LogN)
	public void printLinkedListInReverse4(ImmutableListNode head) {
		helper(head, null);
	}

	private void helper(ImmutableListNode head, ImmutableListNode tail) {
		if (head == null)
			return;

		if (head.getNext() == tail) {
			head.printValue();
			return;
		}

		ImmutableListNode slow = head;
		ImmutableListNode fast = head;

		while (fast != tail && fast.getNext() != tail) {
			slow = slow.getNext();
			fast = fast.getNext();
			fast = fast.getNext();
		}

		helper(slow, tail);
		helper(head, slow);
	}

}
