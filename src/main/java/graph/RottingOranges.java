package graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
	public int orangesRotting(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		Queue<int[]> q = new LinkedList<>();
		int total_fresh = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					total_fresh++;
				} else if (grid[i][j] == 2) {
					q.offer(new int[] { i, j });
				}
			}
		}

		if (total_fresh == 0)
			return 0;

		int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
		int time = -1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				for (int[] dir : dirs) {
					int x = cur[0] + dir[0];
					int y = cur[1] + dir[1];
					if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1) {
						grid[x][y] = 2;
						total_fresh--;
						q.offer(new int[] { x, y });
					}
				}
			}
			time++;
		}

		return total_fresh == 0 ? time : -1;
	}
}
