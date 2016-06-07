package interval;

public class RangeSumQuery2DImmutable {
	public class NumMatrix {

		int[][] partialSums;
		int rows;
		int cols;

		public NumMatrix(int[][] matrix) {
			rows = matrix.length;
			if (rows == 0)
				return;

			cols = matrix[0].length;
			if (cols == 0)
				return;

			partialSums = new int[rows][cols];
			for (int r = 0; r < rows; r++) {
				for (int c = 0; c < cols; c++) {

					if (r >= 1 && c >= 1)
						partialSums[r][c] = matrix[r][c]
								+ partialSums[r - 1][c] + partialSums[r][c - 1]
								- partialSums[r - 1][c - 1];
					else if (r >= 1)
						partialSums[r][c] = partialSums[r - 1][c]
								+ matrix[r][c];
					else if (c >= 1)
						partialSums[r][c] = partialSums[r][c - 1]
								+ matrix[r][c];
					else
						partialSums[r][c] = matrix[r][c];
				}
			}

		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			if (row1 >= 1 && col1 >= 1)
				return partialSums[row2][col2] - partialSums[row1 - 1][col2]
						- partialSums[row2][col1 - 1]
						+ partialSums[row1 - 1][col1 - 1];
			else if (row1 >= 1)
				return partialSums[row2][col2] - partialSums[row1 - 1][col2];
			else if (col1 >= 1)
				return partialSums[row2][col2] - partialSums[row2][col1 - 1];
			else
				return partialSums[row2][col2];
		}
	}
}
