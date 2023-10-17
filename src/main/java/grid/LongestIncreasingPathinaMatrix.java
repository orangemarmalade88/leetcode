package grid;

public class LongestIncreasingPathinaMatrix {

	int[][] dp;
	int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, -1 }, { 0, 1 } };
	int m;
	int n;

	public int longestIncreasingPath(int[][] matrix) {
		m = matrix.length;
		n = matrix[0].length;

		dp = new int[m][n];
		int max = 1;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				max = Math.max(max, calculatePath(matrix, i, j));
			}
		}
		return max;

	}

	public int calculatePath(int[][] matrix, int i, int j) {
		if (dp[i][j] != 0)
			return dp[i][j];
		int res = 1;
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x >= 0 && x < m && y >= 0 && y < n
					&& matrix[x][y] > matrix[i][j]) {
				res = Math.max(res, 1 + calculatePath(matrix, x, y));
			}
		}
		dp[i][j] = res;
		return res;
	}

}
