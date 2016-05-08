package array;

/*

 Given an integer matrix, find the length of the longest increasing path.

 From each cell, you can either move to four directions: left, right, up or down.
 You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

 Example 1:
 nums = [
 [9,9,4],
 [6,6,8],
 [2,1,1]
 ]

 Return 4
 The longest increasing path is [1, 2, 6, 9].

 Example 2:
 nums = [
 [3,4,5],
 [3,2,6],
 [2,2,1]
 ]

 Return 4
 The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed.

 */

public class LongestIncreasingPathInAMatrix {

	int directions[][] = new int[][] { { -1, 0 }, { 1, 0 }, { 0, 1 }, { 0, -1 } };

	public int longestIncreasingPath(int[][] matrix) {

		if (matrix.length == 0)
			return 0;
		int cols = matrix.length;
		int rows = matrix[0].length;
		int[][] dp = new int[cols][rows];
		int max = 0;
		for (int x = 0; x < cols; x++) {
			for (int y = 0; y < rows; y++) {
				max = Math.max(max, dfs(matrix, dp, x, y, rows, cols));
			}
		}
		return max;
	}

	private int dfs(int[][] matrix, int[][] dp, int x, int y, int rows, int cols) {
		if (dp[x][y] != 0)
			return dp[x][y];
		int max = 1;
		for (int[] dir : directions) {
			int newX = x + dir[0];
			int newY = y + dir[1];
			if (newX >= 0 && newX < cols && newY >= 0 && newY < rows
					&& matrix[x][y] < matrix[newX][newY])
				max = Math
						.max(max, 1 + dfs(matrix, dp, newX, newY, rows, cols));
		}
		dp[x][y] = max;
		return max;
	}
}
