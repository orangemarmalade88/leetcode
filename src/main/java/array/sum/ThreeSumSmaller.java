package array.sum;

import java.util.Arrays;

public class ThreeSumSmaller {
	// O(N^2)
	public int threeSumSmaller(int[] nums, int target) {
		Arrays.sort(nums);
		int count = 0;
		for (int i = 0; i < nums.length - 2; i++) {
			int fast = nums.length - 1;

			for (int slow = i + 1; slow < nums.length - 1; slow++) {
				while (nums[i] + nums[slow] + nums[fast] >= target
						&& fast > slow) {
					fast--;
				}
				if (fast > slow)
					count += fast - slow;
			}
		}
		return count;
	}
}
