package list;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

import model.ListNode;

/*

 Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

 */

public class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {
		int k = lists.length;
		if (k == 0)
			return null;

		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		Queue<ListNode> pq = new PriorityQueue<ListNode>(k,
				new Comparator<ListNode>() {

					@Override
					public int compare(ListNode o1, ListNode o2) {
						return o1.val - o2.val;
					}

				});

		for (ListNode node : lists) {
			if (node != null)
				pq.add(node);
		}

		while (!pq.isEmpty()) {
			ListNode next = pq.poll();
			current.next = next;
			current = next;

			if (next.next != null)
				pq.add(next.next);
		}

		return dummy.next;
	}

	public ListNode mergeKLists2(ListNode[] lists) {

		if (lists.length == 0)
			return null;

		int start = 0;
		int end = lists.length - 1;
		while (end > 0) {
			start = 0;
			while (start < end) {
				lists[start] = mergeTwoLists(lists[start], lists[end]);
				start++;
				end--;
			}
		}
		return lists[0];
	}

	private ListNode mergeTwoLists(ListNode n1, ListNode n2) {
		ListNode dummy = new ListNode(0);
		ListNode current = dummy;

		while (n1 != null && n2 != null) {
			if (n1.val < n2.val) {
				current.next = n1;
				current = n1;
				n1 = n1.next;
			} else {
				current.next = n2;
				current = n2;
				n2 = n2.next;
			}
		}

		if (n1 != null) {
			current.next = n1;
		}

		if (n2 != null) {
			current.next = n2;
		}

		return dummy.next;
	}
}
