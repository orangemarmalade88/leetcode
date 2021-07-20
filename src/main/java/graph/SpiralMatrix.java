package graph;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	/*
	 * Given an m x n matrix, return all elements of the matrix in spiral order.
	 * 
	 * 
	 */
	int m;
	int n;

	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> res = new ArrayList<>();
		int i = 0;
		int j = 0;
		m = matrix.length;
		n = matrix[0].length;
		int[][] dir = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		boolean[][] visited = new boolean[m][n];
		int d = 0;
		while (res.size() < m * n) {
			res.add(matrix[i][j]);
			visited[i][j] = true;
			int next_x = i + dir[d][0];
			int next_y = j + dir[d][1];
			if (next_x >= 0 && next_y >= 0 && next_x < m && next_y < n
					&& !visited[next_x][next_y]) {
				i = next_x;
				j = next_y;
			} else {
				d = (d + 1) % 4;
				i = i + dir[d][0];
				j = j + dir[d][1];
			}
		}
		return res;

	}
}
