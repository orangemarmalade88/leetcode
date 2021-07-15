package array;

import java.util.HashMap;
import java.util.Map;

public class LongestArithmeticSubsequence {
	/*
	 * Given an array nums of integers, return the length of the longest
	 * arithmetic subsequence in nums.
	 *
	 * Recall that a subsequence of an array nums is a list nums[i1], nums[i2],
	 * ..., nums[ik] with 0 <= i1 < i2 < ... < ik <= nums.length - 1, and that a
	 * sequence seq is arithmetic if seq[i+1] - seq[i] are all the same value
	 * (for 0 <= i < seq.length - 1).
	 *
	 *
	 */
	public int longestArithSeqLength(int[] nums) {
		int n = nums.length;
		int res = 2;
		@SuppressWarnings("unchecked")
		Map<Integer, Integer>[] dp = new HashMap[n];
		for (int i = 0; i < n; i++) {
			dp[i] = new HashMap<>();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
				int d = nums[j] - nums[i];
				dp[i].put(d, dp[j].getOrDefault(d, 1) + 1);
				res = Math.max(res, dp[i].get(d));
			}
		}
		return res;
	}
}
