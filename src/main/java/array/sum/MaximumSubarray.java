package array.sum;

public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
		int max_so_far = nums[0];
		int max_until_now = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int num = nums[i];
			max_until_now = Math.max(max_until_now + num, num);
			max_so_far = Math.max(max_so_far, max_until_now);
		}
		return max_so_far;
	}
}
