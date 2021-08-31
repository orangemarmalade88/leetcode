package grid;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {
	public int minKnightMoves(int x, int y) {
		if (x == 0 && y == 0)
			return 0;
		int[][] dirs = { { 2, 1 }, { 1, 2 }, { 2, -1 }, { 1, -2 }, { -1, 2 },
				{ -1, -2 }, { -2, -1 }, { -2, 1 } };
		Queue<int[]> q = new LinkedList<>();
		q.offer(new int[] { 0, 0 });

		boolean[][] visited = new boolean[601][601];
		visited[300][300] = true;
		int steps = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				for (int[] d : dirs) {
					int n_x = cur[0] + d[0];
					int n_y = cur[1] + d[1];
					if (n_x == x && n_y == y)
						return steps;
					if (!visited[n_x + 300][n_y + 300]) {
						q.offer(new int[] { n_x, n_y });
						visited[n_x + 300][n_y + 300] = true;
					}
				}
			}
			steps++;
		}
		return -1;
	}
}
