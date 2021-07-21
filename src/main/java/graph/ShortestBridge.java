package graph;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestBridge {
	/*
	 * In a given 2D binary array grid, there are two islands. (An island is a
	 * 4-directionally connected group of 1s not connected to any other 1s.)
	 * 
	 * Now, we may change 0s to 1s so as to connect the two islands together to
	 * form 1 island.
	 * 
	 * Return the smallest number of 0s that must be flipped. (It is guaranteed
	 * that the answer is at least 1.)
	 * 
	 * 
	 */
	int m;
	int n;
	int[][] dirs = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

	public int shortestBridge(int[][] grid) {
		m = grid.length;
		n = grid[0].length;
		int x = -1;
		int y = -1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					x = i;
					y = j;
					break;
				}

			}
		}

		Queue<int[]> queue = new LinkedList<>();
		boolean[][] visited = new boolean[m][n];

		dfs(x, y, grid, visited, queue);

		int steps = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				int[] cur = queue.poll();

				for (int[] d : dirs) {
					int next_x = cur[0] + d[0];
					int next_y = cur[1] + d[1];
					if (next_x < 0 || next_x >= m || next_y < 0 || next_y >= n
							|| visited[next_x][next_y])
						continue;
					if (grid[next_x][next_y] == 1)
						return steps;
					else {
						visited[next_x][next_y] = true;
						queue.offer(new int[] { next_x, next_y });
					}

				}
			}
			steps++;
		}
		return -1;
	}

	private void dfs(int i, int j, int[][] grid, boolean[][] visited,
			Queue<int[]> queue) {
		if (i < 0 || i >= m || j < 0 || j >= n || visited[i][j]
				|| grid[i][j] == 0)
			return;
		visited[i][j] = true;
		queue.offer(new int[] { i, j });

		for (int[] d : dirs) {
			dfs(i + d[0], j + d[1], grid, visited, queue);
		}
	}
}
