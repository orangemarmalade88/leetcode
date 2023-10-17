package math;

public class NextPermutation {
	public void nextPermutation(int[] nums) {
		int i;
		// find first non-increasing element from back
		for (i = nums.length - 2; i >= 0; i--) {
			if (nums[i] < nums[i + 1])
				break;
		}

		if (i >= 0) {
			int j;
			// find smallest element that is greater than nums[i]
			for (j = nums.length - 1; j > i; j--) {
				if (nums[j] > nums[i])
					break;
			}

			// swap i and min_index
			swap(nums, i, j);
		}

		// reverse i + i to end
		reverse(nums, i + 1, nums.length - 1);
	}

	public void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

	public void reverse(int[] nums, int i, int j) {
		while (i < j) {
			swap(nums, i++, j--);
		}
	}
}
