package array;

/*

 You are a professional robber planning to rob houses along a street.
 Each house has a certain amount of money stashed,
 the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and
 it will automatically contact the police if two adjacent houses were broken into on the same night.

 Given a list of non-negative integers representing the amount of money of each house,
 determine the maximum amount of money you can rob tonight without alerting the police.

 */

public class HouseRobber {

	// Optimize to use O(1) space
	// Because the DP function only uses n-1 and n-2
	public int rob0(int[] nums) {
		int x = 0;
		int y = 0;
		for (int i = 1; i <= nums.length; i++) {
			int temp = y;
			y = Math.max(y, x + nums[i - 1]);
			x = temp;
		}
		return y;
	}

	public int rob(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		int[] values = new int[n + 1];
		values[0] = 0;
		values[1] = nums[0];
		for (int i = 2; i <= n; i++) {
			values[i] = Math.max(values[i - 1], values[i - 2] + nums[i]);
		}
		return values[n];
	}

	// Some old 2D DP solution
	public int rob2(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		int[][] values = new int[n][n];
		for (int i = 0; i < n; i++) {
			values[i][i] = nums[i];
		}

		for (int i = 1; i < n; i++) {
			values[i - 1][i] = Math.max(nums[i - 1], nums[i]);
		}

		for (int i = 0; i < n; i++) {
			for (int step = 2; i + step < n; step++) {
				for (int j = i; j <= i + step; j++) {
					int stealj = 0;
					stealj += nums[j];
					if (j - 2 >= i)
						stealj += values[i][j - 2];
					if (j + 2 <= i + step)
						stealj += values[j + 2][i + step];
					values[i][i + step] = Math.max(stealj, values[i][i + step]);

					int nostealj = 0;
					if (j - 1 >= i)
						nostealj += values[i][j - 1];
					if (j + 1 <= i + step)
						nostealj += values[j + 1][i + step];
					values[i][i + step] = Math.max(nostealj,
							values[i][i + step]);
				}
			}
		}

		return values[0][n - 1];
	}
}
