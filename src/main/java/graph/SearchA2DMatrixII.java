package graph;

public class SearchA2DMatrixII {
	/*
	 * Write an efficient algorithm that searches for a target value in an m x n
	 * integer matrix. The matrix has the following properties:
	 *
	 * Integers in each row are sorted in ascending from left to right. Integers
	 * in each column are sorted in ascending from top to bottom.
	 *
	 */

	// O(M+N)
	public boolean searchMatrix(int[][] matrix, int target) {
		int x = matrix.length - 1;
		int y = 0;
		while (x >= 0 && y < matrix[0].length) {
			if (matrix[x][y] == target)
				return true;
			else if (matrix[x][y] < target)
				y++;
			else
				x--;
		}
		return false;
	}
}
