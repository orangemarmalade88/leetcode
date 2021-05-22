package stream;

import java.util.Collections;
import java.util.PriorityQueue;

public class FindMedianFromDataStream {

	/*
	 * The median is the middle value in an ordered integer list. If the size of
	 * the list is even, there is no middle value and the median is the mean of
	 * the two middle values.
	 *
	 * For example, for arr = [2,3,4], the median is 3. For example, for arr =
	 * [2,3], the median is (2 + 3) / 2 = 2.5. Implement the MedianFinder class:
	 *
	 * MedianFinder() initializes the MedianFinder object. void addNum(int num)
	 * adds the integer num from the data stream to the data structure. double
	 * findMedian() returns the median of all elements so far. Answers within
	 * 10-5 of the actual answer will be accepted.
	 *
	 */
	private final PriorityQueue<Integer> max_heap;
	private final PriorityQueue<Integer> min_heap;

	/** initialize your data structure here. */
	public FindMedianFromDataStream() {
		max_heap = new PriorityQueue<>(Collections.reverseOrder());
		min_heap = new PriorityQueue<>();
	}

	public void addNum(int num) {
		if (max_heap.size() == min_heap.size()) {
			if (min_heap.isEmpty() || num <= min_heap.peek())
				max_heap.offer(num);
			else if (num > min_heap.peek()) {
				max_heap.offer(min_heap.poll());
				min_heap.offer(num);
			}
		} else if (max_heap.size() == min_heap.size() + 1) {
			if (num >= max_heap.peek())
				min_heap.offer(num);
			else if (num < max_heap.peek()) {
				min_heap.offer(max_heap.poll());
				max_heap.offer(num);
			}
		}
	}

	public double findMedian() {
		if (max_heap.size() == min_heap.size())
			return (max_heap.peek() + min_heap.peek()) / 2.0;
		else
			return max_heap.peek();
	}
}
