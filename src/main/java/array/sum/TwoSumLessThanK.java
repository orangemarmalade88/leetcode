package array.sum;

import java.util.Arrays;

public class TwoSumLessThanK {
	public int twoSumLessThanK(int[] nums, int k) {
		Arrays.sort(nums);
		int res = -1;
		int slow = 0;
		int fast = nums.length - 1;
		while (slow < fast) {
			int sum = nums[slow] + nums[fast];
			if (sum >= k)
				fast--;
			else {
				res = Math.max(res, sum);
				slow++;
			}
		}
		return res;
	}
}
