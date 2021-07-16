package graph;

public class MaximalSquare {
	/*
	 * Given an m x n binary matrix filled with 0's and 1's, find the largest
	 * square containing only 1's and return its area.
	 * 
	 * 
	 */
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int max = 0;
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				dp[i + 1][j + 1] = matrix[i][j] == '0' ? 0
						: Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]),
								dp[i][j]) + 1;
				max = Math.max(max, dp[i + 1][j + 1]);
			}
		}
		return max * max;
	}
}
