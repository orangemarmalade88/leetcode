package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {
	public int minKnightMoves(int x, int y) {
		int[][] dirs = { { 1, 2 }, { 2, 1 }, { 1, -2 }, { 2, -1 }, { -1, -2 },
				{ -2, -1 }, { -2, 1 }, { -1, 2 } };
		Queue<int[]> q = new LinkedList<>();
		Set<String> visited = new HashSet<>();

		q.offer(new int[] { 0, 0 });
		visited.add("0,0");

		int steps = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				if (cur[0] == x && cur[1] == y)
					return steps;
				for (int[] d : dirs) {
					int n_x = cur[0] + d[0];
					int n_y = cur[1] + d[1];
					String index = n_x + "," + n_y;
					if (!visited.contains(index)) {
						q.offer(new int[] { n_x, n_y });
						visited.add(index);
					}
				}
			}
			steps++;
		}
		return -1;
	}
}
