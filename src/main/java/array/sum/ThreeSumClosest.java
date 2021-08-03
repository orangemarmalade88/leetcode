package array.sum;

import java.util.Arrays;

public class ThreeSumClosest {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int min = Integer.MAX_VALUE;
		int res = 0;
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (Math.abs(sum - target) < min) {
					min = Math.abs(sum - target);
					res = sum;
				}
				if (sum == target)
					return target;
				else if (sum < target) {
					j++;
				} else {
					k--;
				}
			}
		}
		return res;
	}
}
