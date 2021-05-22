package stream;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
	/*
	 * Design a class to find the kth largest element in a stream. Note that it
	 * is the kth largest element in the sorted order, not the kth distinct
	 * element.
	 *
	 * Implement KthLargest class:
	 *
	 * KthLargest(int k, int[] nums) Initializes the object with the integer k
	 * and the stream of integers nums. int add(int val) Returns the element
	 * representing the kth largest element in the stream.
	 *
	 */
	PriorityQueue<Integer> pq;
	int k;

	public KthLargestElementInAStream(int k, int[] nums) {
		this.k = k;
		pq = new PriorityQueue<>();
		for (int i : nums) {
			add(i);
		}
	}

	// O(logN)
	public int add(int val) {
		pq.offer(val);
		if (pq.size() > k) {
			pq.poll();
		}
		return pq.peek();
	}
}
