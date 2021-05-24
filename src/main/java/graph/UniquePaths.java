package graph;

public class UniquePaths {
	/*
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start'
	 * in the diagram below).
	 *
	 * The robot can only move either down or right at any point in time. The
	 * robot is trying to reach the bottom-right corner of the grid (marked
	 * 'Finish' in the diagram below).
	 *
	 * How many possible unique paths are there?
	 *
	 *
	 */

	// O(MN)
	public int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++)
			dp[i][n - 1] = 1;
		for (int j = 0; j < n; j++)
			dp[m - 1][j] = 1;
		for (int i = m - 2; i >= 0; i--) {
			for (int j = n - 2; j >= 0; j--) {
				dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
			}
		}
		return dp[0][0];
	}
}
