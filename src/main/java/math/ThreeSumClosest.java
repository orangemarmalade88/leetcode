package math;

import java.util.Arrays;

/*

 Given an array S of n integers, find three integers in S such that the sum is closest to a given number,
 target. Return the sum of the three integers.
 You may assume that each input would have exactly one solution.
 For example, given array S = {-1 2 1 -4}, and target = 1.

 The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

 */

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {

		int min_diff = Integer.MAX_VALUE;
		int temp_sum = 0;

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 2; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				int diff = sum - target;

				if (diff == 0) {
					return sum;
				} else {
					if (Math.abs(diff) < min_diff) {
						min_diff = Math.abs(diff);
						temp_sum = sum;
					}
					if (diff < 0) {
						j++;
					} else {
						k--;
					}
				}
			}
		}

		return temp_sum;
	}
}
