package array;

import java.util.Random;

public class KthLargestElementinanArray {

	Random r = new Random();

	public int findKthLargest(int[] nums, int k) {
		return findK(nums, k, 0, nums.length - 1);
	}

	public int findK(int[] nums, int k, int start, int end) {
		int index = r.nextInt(end - start + 1) + start;
		int pivot = nums[index];

		nums[index] = nums[end];
		nums[end] = pivot;

		int swap_index = start;
		for (int i = start; i < end; i++) {
			if (nums[i] < pivot) {
				int temp = nums[i];
				nums[i] = nums[swap_index];
				nums[swap_index] = temp;
				swap_index++;
			}
		}
		nums[end] = nums[swap_index];
		nums[swap_index] = pivot;

		if (k == end + 1 - swap_index) { // length - k == swap - start
			return nums[swap_index];
		}
		if (k > end + 1 - swap_index) {
			return findK(nums, k - (end - swap_index + 1), start,
					swap_index - 1);
		}
		return findK(nums, k, swap_index + 1, end);
	}
}
