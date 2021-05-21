package stream;

import java.util.PriorityQueue;

public class KthLargestElementInAStream {
	PriorityQueue<Integer> pq;
	int k;

	public KthLargestElementInAStream(int k, int[] nums) {
		this.k = k;
		pq = new PriorityQueue<>();
		for (int i : nums) {
			add(i);
		}
	}

	public int add(int val) {
		if (pq.size() < k) {
			pq.offer(val);
		} else {
			if (pq.peek() < val) {
				pq.poll();
				pq.offer(val);
			}
		}
		return pq.peek();
	}
}
