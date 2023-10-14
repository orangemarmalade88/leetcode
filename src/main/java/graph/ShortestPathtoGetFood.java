package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathtoGetFood {
	int[][] dirs = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

	public int getFood(char[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '*') {
					q.offer(new int[] { i, j });
				}
			}
		}

		int length = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				for (int[] dir : dirs) {
					int x = cur[0] + dir[0];
					int y = cur[1] + dir[1];
					if (x < 0 || x >= m || y < 0 || y >= n)
						continue;
					if (grid[x][y] == '#')
						return length;
					if (grid[x][y] == 'O') {
						q.offer(new int[] { x, y });
						grid[x][y] = 'X';
					}
				}
			}
			length++;
		}
		return -1;
	}
}
