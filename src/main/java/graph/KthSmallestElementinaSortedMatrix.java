package graph;

public class KthSmallestElementinaSortedMatrix {
	public int kthSmallest(int[][] matrix, int k) {
		int n = matrix.length;
		int r = k / n;
		int c = k % n;
		return matrix[r][c];
	}
}
