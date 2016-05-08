package array.slidingwindow;

import java.util.LinkedList;
import java.util.Queue;

/*

 Given a stream of integers and a window size, calculate the moving average of all integers
 in the sliding window.

 For example,

 MovingAverage m = new MovingAverage(3);
 m.next(1) = 1
 m.next(10) = (1 + 10) / 2
 m.next(3) = (1 + 10 + 3) / 3
 m.next(5) = (10 + 3 + 5) / 3

 */

public class MovingAverageFromDataStream {
	public class MovingAverage {
		Queue<Integer> queue = new LinkedList<>();
		int capacity;
		int sum;

		/** Initialize your data structure here. */
		public MovingAverage(int size) {
			capacity = size;
		}

		public double next(int val) {
			if (queue.size() >= capacity) {
				sum = sum - queue.poll() + val;
			} else {
				sum += val;
			}
			queue.offer(val);
			return sum / (double) queue.size();
		}
	}
}
