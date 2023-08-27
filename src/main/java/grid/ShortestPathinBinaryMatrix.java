package grid;

import java.util.LinkedList;
import java.util.Queue;

public class ShortestPathinBinaryMatrix {

	int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 }, { 1, 1 },
			{ 1, -1 }, { -1, 1 }, { -1, -1 } };

	public int shortestPathBinaryMatrix(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;

		if (grid[0][0] != 0)
			return -1;
		boolean[][] visited = new boolean[m][n];
		Queue<int[]> q = new LinkedList<>();
		visited[0][0] = true;
		q.offer(new int[] { 0, 0 });
		int length = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				if (cur[0] == m && cur[1] == n)
					return length;
				for (int[] dir : dirs) {
					int x = cur[0] + dir[0];
					int y = cur[1] + dir[1];
					if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0
							&& !visited[x][y]) {
						q.offer(new int[] { x, y });
					}
				}
			}
			length++;
		}
		return -1;
	}

}
