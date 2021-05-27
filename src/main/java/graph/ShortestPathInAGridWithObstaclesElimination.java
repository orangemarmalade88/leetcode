package graph;

import java.util.ArrayDeque;
import java.util.Queue;

public class ShortestPathInAGridWithObstaclesElimination {
	/*
	 * Given a m * n grid, where each cell is either 0 (empty) or 1 (obstacle).
	 * In one step, you can move up, down, left or right from and to an empty
	 * cell.
	 *
	 * Return the minimum number of steps to walk from the upper left corner (0,
	 * 0) to the lower right corner (m-1, n-1) given that you can eliminate at
	 * most k obstacles. If it is not possible to find such walk return -1.
	 *
	 *
	 */
	// O(MNK)
	public int shortestPath(int[][] grid, int k) {
		int[][] dir = { { 0, 1 }, { 1, 0 }, { -1, 0 }, { 0, -1 } };
		int m = grid.length;
		int n = grid[0].length;
		if (m == 1 && n == 1)
			return 0;
		boolean[][][] visited = new boolean[m][n][k + 1];
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] { 0, 0, 0 });
		int steps = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size > 0) {
				int[] cur = q.poll();
				if (cur[0] == m - 1 && cur[1] == n - 1)
					return steps;
				for (int[] d : dir) {
					int x = cur[0] + d[0];
					int y = cur[1] + d[1];
					if (x < 0 || x >= m || y < 0 || y >= n)
						continue;
					int ob = cur[2] + grid[x][y];
					if (ob <= k && !visited[x][y][ob]) {
						q.offer(new int[] { x, y, ob });
						visited[x][y][ob] = true;
					}
				}
				size--;
			}
			steps++;
		}
		return -1;
	}

}
