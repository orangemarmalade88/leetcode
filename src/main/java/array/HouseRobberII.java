package array;

/*

 Note: This is an extension of House Robber.

 After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention.
 This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one.
 Meanwhile, the security system for these houses remain the same as for those in the previous street.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

 */

public class HouseRobberII {
	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		if (n == 1)
			return nums[0];
		int[] dp = new int[n + 1];
		dp[0] = 0;
		dp[1] = nums[0];
		for (int i = 2; i <= n; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
		}

		int[] dp2 = new int[n + 1];
		dp2[0] = 0;
		dp2[1] = 0;
		for (int i = 2; i <= n; i++) {
			dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i - 1]);
		}

		return Math.max(dp[n - 1], dp2[n]);
	}
}
