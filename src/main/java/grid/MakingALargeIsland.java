package grid;

import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {
	public int largestIsland(int[][] grid) {
		Map<Integer, Integer> map = new HashMap<>();
		int m = grid.length;
		int n = grid[0].length;

		int max = 0;
		int[][] id = new int[m][n];
		int cur_id = 1;

		int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1 && id[i][j] == 0) {
					Deque<int[]> stack = new LinkedList<>();
					stack.push(new int[] { i, j });
					id[i][j] = cur_id;
					int area = 0;
					while (!stack.isEmpty()) {
						int[] cur = stack.pop();
						area++;
						for (int[] d : dirs) {
							int x = cur[0] + d[0];
							int y = cur[1] + d[1];
							if (x >= 0 && x < m && y >= 0 && y < n
									&& grid[x][y] == 1 && id[x][y] == 0) {
								stack.push(new int[] { x, y });
								id[x][y] = cur_id;
							}
						}
					}
					map.put(cur_id, area);
					cur_id++;
					max = Math.max(area, max);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					int area = 0;
					Set<Integer> set = new HashSet<>();
					for (int[] d : dirs) {
						int x = i + d[0];
						int y = j + d[1];
						if (x >= 0 && x < m && y >= 0 && y < n
								&& grid[x][y] == 1) {
							if (!set.contains(id[x][y])) {
								set.add(id[x][y]);
								area += map.get(id[x][y]);
							}
						}
					}
					max = Math.max(area + 1, max);

				}

			}

		}
		return max;
	}
}
