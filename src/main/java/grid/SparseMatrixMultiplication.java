package grid;

public class SparseMatrixMultiplication {
	public int[][] multiply(int[][] mat1, int[][] mat2) {
		int m = mat1.length;
		int n = mat2[0].length;

		int[][] res = new int[m][n];

		// res[i][j] = sum (m1[i][k] * m2[k][j])

		// for the sparse matrix, we only need to calculate if element is
		// non-zero

		// so if m1 is sparse, we can check if m1[i][k] is 0 first

		for (int i = 0; i < m; i++) {
			for (int k = 0; k < mat2.length; k++) {
				if (mat1[i][k] != 0)
					for (int j = 0; j < n; j++) {
						res[i][j] += mat1[i][k] * mat2[k][j];
					}
			}
		}
		return res;
	}

}
