package grid;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
	public List<Integer> spiralOrder(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;

		boolean[][] visited = new boolean[m][n];

		List<Integer> l = new ArrayList<>();
		int d = 0;
		int i = 0;
		int j = 0;

		int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
		while (l.size() < m * n) {
			if (!visited[i][j]) {
				l.add(matrix[i][j]);
				visited[i][j] = true;
			}
			int next_i = i + dirs[d][0];
			int next_j = j + dirs[d][1];
			if (next_i < 0 || next_i >= m || next_j < 0 || next_j >= n
					|| visited[next_i][next_j]) {
				d = (d + 1) % 4;
				continue;
			}
			i = next_i;
			j = next_j;
		}
		return l;
	}
}
