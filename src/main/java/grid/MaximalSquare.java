package grid;

public class MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		// DP is the side length
		int[][] dp = new int[m + 1][n + 1];
		int max = 0;
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				dp[i][j] = matrix[i - 1][j - 1] == '1'
						? Math.min(dp[i - 1][j],
								Math.min(dp[i - 1][j - 1], dp[i][j - 1])) + 1
						: 0;
				max = Math.max(dp[i][j], max);
			}
		}
		return max * max;
	}
}
