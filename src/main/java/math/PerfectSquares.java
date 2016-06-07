package math;

/*

 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

 For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.

 */

public class PerfectSquares {

	public int numSquares(int n) {
		int[] dp = new int[n + 1];
		dp[1] = 1;
		return numSquares(n, dp, 0, Integer.MAX_VALUE);
	}

	private int numSquares(int n, int[] dp, int currentDepth, int localMin) {
		if (currentDepth >= localMin)
			return Integer.MAX_VALUE;
		if (n == 0)
			return 0;
		if (dp[n] != 0)
			return dp[n];

		int upper = (int) Math.sqrt(n);
		int min = Integer.MAX_VALUE;
		for (int i = upper; i >= 1; i--) {
			min = Math.min(
					1 + numSquares(n - i * i, dp, 1 + currentDepth, min), min);
		}

		dp[n] = min;
		return min;
	}
}
