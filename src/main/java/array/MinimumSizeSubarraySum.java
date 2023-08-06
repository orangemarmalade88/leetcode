package array;

public class MinimumSizeSubarraySum {

	public static int minSubArrayLen(int target, int[] nums) {
		int i = 0;
		int j = 0;
		int sum = 0;
		int min = Integer.MAX_VALUE;
		while (j < nums.length) {
			sum += nums[j++];

			// Read problem carefully, greater than or equal to target
			while (sum >= target) {
				min = Math.min(j - i, min);
				sum -= nums[i++];
			}

		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String[] args) {
		int[] input = { 1, 2, 3, 4, 5 };
		minSubArrayLen(11, input);
	}
}
