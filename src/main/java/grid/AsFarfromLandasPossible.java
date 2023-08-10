package grid;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarfromLandasPossible {
	int m;
	int n;

	int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int maxDistance(int[][] grid) {
		m = grid.length;
		n = grid[0].length;

		boolean[][] visited = new boolean[m][n];
		Queue<int[]> queue = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					queue.offer(new int[] { i, j });
				}
			}
		}

		int max = -1;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] cur = queue.poll();
				for (int[] dir : dirs) {
					int next_x = dir[0] + cur[0];
					int next_y = dir[1] + cur[1];
					if (next_x >= 0 && next_x < m && next_y >= 0 && next_y < n
							&& !visited[next_x][next_y]
							&& grid[next_x][next_y] == 0) {
						queue.offer(new int[] { next_x, next_y });
						visited[next_x][next_y] = true;
					}
				}
			}
			max++;
		}
		return max < 1 ? -1 : max;
	}

}
