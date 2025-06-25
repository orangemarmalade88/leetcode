package array;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {
	public int[] maxSlidingWindow(int[] nums, int k) {
		Deque<Integer> index = new ArrayDeque<>();
		int[] result = new int[nums.length - k + 1];
		for (int i = 0; i < k; i++) {
			while (!index.isEmpty() && nums[index.peekFirst()] < nums[i]) {
				index.pollFirst();
			}
			index.addFirst(i);
		}
		for (int i = k; i < nums.length; i++) {
			result[i - k] = nums[index.peekLast()];
			while (!index.isEmpty() && nums[index.peekFirst()] < nums[i]) {
				index.pollFirst();
			}
			index.addFirst(i);
			if (i - k >= index.peekLast()) {
				index.pollLast();
			}
		}
		result[result.length - 1] = nums[index.peekLast()];

		return result;

	}
}
