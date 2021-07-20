package array;

public class PartitionArrayIntoDisjointIntervals {
	/*
	 * Given an array nums, partition it into two (contiguous) subarrays left
	 * and right so that:
	 * 
	 * Every element in left is less than or equal to every element in right.
	 * left and right are non-empty. left has the smallest possible size. Return
	 * the length of left after such a partitioning. It is guaranteed that such
	 * a partitioning exists.
	 * 
	 * 
	 */
	public int partitionDisjoint(int[] nums) {
		int n = nums.length;
		int[] max_left = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			max = Math.max(max, nums[i]);
			max_left[i] = max;
		}
		int[] min_right = new int[n];
		int min = Integer.MAX_VALUE;
		for (int j = n - 1; j >= 0; j--) {
			min = Math.min(min, nums[j]);
			min_right[j] = min;
		}
		for (int i = 0; i < n - 1; i++) {
			if (max_left[i] <= min_right[i + 1])
				return i + 1;
		}
		return -1;
	}
}
