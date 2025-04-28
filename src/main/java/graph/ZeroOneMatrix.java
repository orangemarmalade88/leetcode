package graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class ZeroOneMatrix {
	public int[][] updateMatrix(int[][] mat) {
		int r = mat.length;
		int c = mat[0].length;

		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		Set<String> visited = new HashSet<>(); // can use boolean[][]
		Queue<int[]> q = new LinkedList<>();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (mat[i][j] == 0) {
					String index = i + "," + j;
					q.offer(new int[] { i, j });
					visited.add(index);
				}
			}
		}

		int[][] result = new int[r][c];
		int steps = 0;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				int[] cur = q.poll();
				result[cur[0]][cur[1]] = steps;
				for (int[] dir : dirs) {
					int x = cur[0] + dir[0];
					int y = cur[1] + dir[1];
					if (x >= 0 && x < r && y >= 0 && y < c) {
						String index = x + "," + y;
						if (!visited.contains(index)) {
							q.offer(new int[] { x, y });
							visited.add(index);
						}
					}
				}
			}
			steps++;
		}
		return result;
	}
}
