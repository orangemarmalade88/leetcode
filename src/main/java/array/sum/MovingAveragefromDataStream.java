package array.sum;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAveragefromDataStream {

	Queue<Integer> q = new LinkedList<>();
	int capacity;
	int sum = 0;

	public MovingAveragefromDataStream(int size) {
		capacity = size;
	}

	public double next(int val) {
		if (q.size() == capacity) {
			sum -= q.poll();
		}
		q.offer(val);
		sum += val;
		return ((double) sum) / q.size();
	}
}
