package array;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianfromDataStream {
	Queue<Integer> min_heap = new PriorityQueue<>();
	Queue<Integer> max_heap = new PriorityQueue<>(Collections.reverseOrder());

	public void addNum(int num) {
		if (min_heap.size() == max_heap.size()) {
			if (max_heap.isEmpty() || num >= max_heap.peek()) {
				min_heap.offer(num);
			} else {
				min_heap.offer(max_heap.poll());
				max_heap.offer(num);
			}
		} else if (min_heap.size() > max_heap.size()) {
			if (num < min_heap.peek()) {
				max_heap.offer(num);
			} else {
				max_heap.offer(min_heap.poll());
				min_heap.offer(num);
			}
		}
	}

	public double findMedian() {
		if (min_heap.size() == max_heap.size()) {
			return (min_heap.peek() + max_heap.peek()) / 2.0;
		}
		return min_heap.peek();
	}
}
