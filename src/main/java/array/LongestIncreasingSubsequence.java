package array;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
	/*
	 * Given an integer array nums, return the length of the longest strictly
	 * increasing subsequence.
	 * 
	 * A subsequence is a sequence that can be derived from an array by deleting
	 * some or no elements without changing the order of the remaining elements.
	 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
	 * 
	 * 
	 */
	// O(NlogN), dp[i] = last element of current longest subsequence of size i+1
	public int lengthOfLIS2(int[] nums) {
		int[] dp = new int[nums.length];
		int size = 0;
		for (int num : nums) {
			int index = Arrays.binarySearch(dp, 0, size, num);
			if (index < 0) {
				index = -(index + 1);
			}
			dp[index] = num;
			if (index == size) {
				size++;
			}
		}
		return size;
	}

	// O(N^2), dp[i] = longest subsequence containing ith element
	public int lengthOfLIS(int[] nums) {
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int global_max = 1;
		for (int i = 1; i < nums.length; i++) {
			int max = 1;
			for (int j = 0; j < i; j++) {
				if (nums[j] < nums[i]) {
					max = Math.max(max, dp[j] + 1);
				}
			}
			dp[i] = max;
			global_max = Math.max(global_max, max);
		}
		return global_max;
	}
}
