package array;

public class MaxConsecutiveOnesIII {
	public int longestOnes(int[] nums, int k) {
		int left = 0;
		int right = 0;
		int zeros = 0;
		int max = 0;
		while (left < nums.length) {
			if (nums[left++] == 1) {
				max = Math.max(max, left - right);
			} else {
				zeros++;
			}
			while (zeros > k) {
				if (nums[right++] == 1) {
				} else {
					zeros--;
				}
			}
		}
		return max;
	}
}
