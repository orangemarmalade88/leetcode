package design.iterator;

import java.util.Iterator;

/*

 Given an Iterator class interface with methods: next() and hasNext(),
 design and implement a PeekingIterator that support the peek() operation --
 it essentially peek() at the element that will be returned by the next call to next().

 Here is an example. Assume that the iterator is initialized to the beginning of the list: [1, 2, 3].

 Call next() gets you 1, the first element in the list.

 Now you call peek() and it returns 2, the next element. Calling next() after that still return 2.

 You call next() the final time and it returns 3, the last element.
 Calling hasNext() after that should return false.

 Hint:

 Think of "looking ahead". You want to cache the next element.
 Is one variable sufficient? Why or why not?
 Test your design with call order of peek() before next() vs next() before peek().
 For a clean implementation, check out Google's guava library source code.

 Follow up: How would you extend your design to be generic and work with all types, not just integer?

 */

public class PeekingIterator implements Iterator<Integer> {

	private final Iterator<Integer> i;
	// CARE: use primitive type here!
	private Integer next;
	boolean hasPeeked;

	public PeekingIterator(Iterator<Integer> iterator) {
		i = iterator;
	}

	// Returns the next element in the iteration without advancing the iterator.
	public Integer peek() {
		if (hasPeeked) {
			return next;
		}
		next = next();
		hasPeeked = true;
		return next;
	}

	// hasNext() and next() should behave the same as in the Iterator interface.
	// Override them if needed.
	@Override
	public Integer next() {
		if (hasPeeked) {
			hasPeeked = false;
			return next;
		}
		return i.next();
	}

	@Override
	public boolean hasNext() {
		return hasPeeked || i.hasNext();
	}
}
