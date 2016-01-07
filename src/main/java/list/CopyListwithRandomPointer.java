package list;

import model.RandomListNode;

/*

 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

 Return a deep copy of the list.

 */

public class CopyListwithRandomPointer {

	// Mistake: Random node can be null

	public RandomListNode copyRandomList(RandomListNode head) {

		if (head == null)
			return null;

		// Phase 1: add new node after each node
		RandomListNode curr = head;
		while (curr != null) {
			RandomListNode next = curr.next;
			RandomListNode newNext = new RandomListNode(curr.label);
			curr.next = newNext;
			newNext.next = next;

			curr = curr.next.next;
		}
		RandomListNode newHead = head.next;

		// Phase 2: link new random pointer
		curr = head;
		while (curr != null) {
			curr.next.random = (curr.random == null) ? null : curr.random.next;
			curr = curr.next.next;
		}

		// Phase 3: unlink
		curr = head;
		while (curr != null) {
			RandomListNode next = curr.next;
			curr.next = next == null ? null : next.next;
			curr = next;
		}

		return newHead;
	}

	// Other solution: Construct a map of original node -> copied node
	// Then newN.random = oldN.random -> copiedNode
	// O(N) time, O(N) space
}
