package design.iterator;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*

 Implement an iterator to flatten a 2d vector.

 For example,
 Given 2d vector =

 [
 [1,2],
 [3],
 [4,5,6]
 ]
 By calling next repeatedly until hasNext returns false, the order of elements returned by next should be:
 [1,2,3,4,5,6].

 Hint:

 How many variables do you need to keep track?
 Two variables is all you need. Try with x and y.
 Beware of empty rows. It could be the first few rows.
 To write correct code, think about the invariant to maintain. What is it?
 The invariant is x and y must always point to a valid point in the 2d vector.
 Should you maintain your invariant ahead of time or right when you need it?
 Not sure? Think about how you would implement hasNext(). Which is more complex?
 Common logic in two different places should be refactored into a common method.

 Follow up:
 As an added challenge, try to code it using only iterators in C++ or iterators in Java.

 */

public class Flatten2DVector {
	public class Vector2D implements Iterator<Integer> {

		Queue<Iterator<Integer>> queue = new LinkedList<>();

		public Vector2D(List<List<Integer>> vec2d) {
			for (List<Integer> list : vec2d) {
				Iterator<Integer> i = list.iterator();
				if (i.hasNext())
					queue.offer(i);
			}
		}

		@Override
		public Integer next() {
			Iterator<Integer> i = queue.peek();
			Integer next = i.next();
			if (!i.hasNext()) {
				queue.poll();
			}
			return next;
		}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}
	}
}
