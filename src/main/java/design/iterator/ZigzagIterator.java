package design.iterator;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.ListIterator;

/*

 Given two 1d vectors, implement an iterator to return their elements alternately.

 For example, given two 1d vectors:

 v1 = [1, 2]
 v2 = [3, 4, 5, 6]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be:
 [1, 3, 2, 4, 5, 6].

 Follow up: What if you are given k 1d vectors? How well can your code be extended to such cases?

 Clarification for the follow up question - Update (2015-09-18):
 The "Zigzag" order is not clearly defined and is ambiguous for k > 2 cases.
 If "Zigzag" does not look right to you, replace "Zigzag" with "Cyclic".
 For example, given the following input:

 [1,2,3]
 [4,5,6,7]
 [8,9]
 It should return [1,4,8,2,5,9,3,6,7].

 */

public class ZigzagIterator {

	private final Deque<ListIterator<Integer>> callStack = new ArrayDeque<>();
	private final Deque<ListIterator<Integer>> iterDeque = new ArrayDeque<>();

	public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
		ListIterator<Integer> i1 = v1.listIterator();
		ListIterator<Integer> i2 = v2.listIterator();
		if (i1.hasNext()) {
			iterDeque.offer(i1);
		}
		if (i2.hasNext()) {
			iterDeque.offer(i2);
		}
	}

	public int next() {
		ListIterator<Integer> i = iterDeque.pop();
		callStack.push(i);
		int result = i.next();
		if (i.hasNext()) {
			iterDeque.offer(i);
		}
		return result;
	}

	public boolean hasNext() {
		return !iterDeque.isEmpty();
	}

	public ZigzagIterator(List<List<Integer>> lists) {
		for (List<Integer> list : lists) {
			ListIterator<Integer> i = list.listIterator();
			if (i.hasNext()) {
				iterDeque.offer(i);
			}
		}
	}

	public int previous() {
		ListIterator<Integer> i = callStack.pop();
		if (i.hasNext())
			iterDeque.pollLast();
		iterDeque.offerFirst(i);
		return i.previous();
	}

	public boolean hasPrevious() {
		return !callStack.isEmpty();
	}
}
