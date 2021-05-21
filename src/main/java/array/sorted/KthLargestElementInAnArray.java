package array.sorted;

public class KthLargestElementInAnArray {
	/*
	 * Given an integer array nums and an integer k, return the kth largest
	 * element in the array.
	 *
	 * Note that it is the kth largest element in the sorted order, not the kth
	 * distinct element.
	 *
	 */

	// O(N) average case, worst case O(N^2)
	public int findKthLargest(int[] nums, int k) {
		return quickSelect(nums, 0, nums.length - 1, nums.length + 1 - k);
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	private int partition(int[] nums, int low, int high) {
		int pivot = nums[high];
		int store_index = low;
		for (int i = low; i < high; i++) {
			if (nums[i] < pivot) {
				swap(nums, i, store_index);
				store_index++;
			}
		}
		swap(nums, store_index, high);
		return store_index;
	}

	private int quickSelect(int[] nums, int low, int high, int k) {
		int pivot_index = partition(nums, low, high);
		if (k == pivot_index + 1)
			return nums[pivot_index];
		else if (k < pivot_index + 1)
			return quickSelect(nums, low, pivot_index - 1, k);
		else
			return quickSelect(nums, pivot_index + 1, high, k);
	}
}
