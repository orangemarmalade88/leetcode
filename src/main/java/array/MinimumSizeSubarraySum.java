package array;

public class MinimumSizeSubarraySum {
	public int minSubArrayLen(int s, int[] nums) {
		int start = 0;
		int end = 0;
		int minLen = Integer.MAX_VALUE;
		int sum = 0;

		while (end < nums.length) {
			while (end < nums.length && (sum = sum + nums[end++]) < s)
				;

			if (sum < s)
				break;
			while (start < nums.length && (sum = sum - nums[start++]) >= s)
				;
			minLen = Math.min(end - start + 1, minLen);
		}

		return minLen == Integer.MAX_VALUE ? 0 : minLen;
	}
}
