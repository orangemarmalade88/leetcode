package array;

import java.util.ArrayDeque;
import java.util.Deque;

/*

 Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right.
 You can only see the k numbers in the window. Each time the sliding window moves right by one position.

 For example,
 Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
 Window position                Max
 ---------------               -----
 [1 3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


 Therefore, return the max sliding window as [3,3,5,5,6,7].

 Note:
 You may assume k is always valid, ie: 1 <= k <= input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?

 */

public class SlidingWindowMaximum {

	// Other thoughts:
	// build a heap, when k << N, this gives O(NlgK) == O(N) too

	public int[] maxSlidingWindow(int[] nums, int k) {

		if (nums == null || nums.length == 0)
			return new int[0];

		int[] result = new int[nums.length - k + 1];

		Deque<Integer> indicies = new ArrayDeque<>();
		for (int i = 0; i < nums.length; i++) {
			while (!indicies.isEmpty() && indicies.peekFirst() <= i - k)
				indicies.pollFirst();

			// Deque is always decreasing, containing only biggest, second
			// biggest, ...
			while (!indicies.isEmpty() && nums[indicies.peekLast()] <= nums[i])
				indicies.pollLast();

			indicies.addLast(i);

			if (i - k + 1 >= 0)
				result[i - k + 1] = nums[indicies.peekFirst()];
		}

		return result;
	}
}
