package array.slidingwindow;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianFromDataStream {
	class MedianFinder {

		Queue<Integer> min = new PriorityQueue<>();
		Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());

		// Adds a number into the data structure.
		public void addNum(int num) {
			int minRef = min.isEmpty() ? Integer.MAX_VALUE : min.peek();

			if (num >= minRef) {
				if (min.size() == max.size()) {
					min.add(num);
				} else {
					max.add(min.poll());
					min.add(num);
				}
			} else {
				if (min.size() != max.size()) {
					max.add(num);
				} else {
					max.add(min.poll());
					min.add(num);
				}
			}
		}

		// Returns the median of current data stream
		public double findMedian() {
			if (min.size() == 0)
				return 0;
			if (min.size() == max.size()) {
				// Mistake integer division result is integer!
				return ((double) min.peek() + max.peek()) / 2;
			}
			return min.peek();
		}
	};

	public static void main(String[] args) {
		FindMedianFromDataStream ff = new FindMedianFromDataStream();
		MedianFinder mf = ff.new MedianFinder();
		mf.addNum(-1);
		System.out.println(mf.findMedian());
		mf.addNum(-2);
		System.out.println(mf.findMedian());
		mf.addNum(-3);
	}
}
