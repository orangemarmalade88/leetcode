package grid;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {
	int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	int m;
	int n;

	Map<Integer, Integer> map = new HashMap<>();

	public int largestIsland(int[][] grid) {
		m = grid.length;
		n = grid[0].length;

		int max = 1;

		int cur_id = 2;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 1) {
					int area = dfs(grid, i, j, cur_id);
					max = Math.max(max, area);
					map.put(cur_id++, area);
				}
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					int area = 1;
					Set<Integer> s = new HashSet<>();
					for (int[] d : dirs) {
						int p = i + d[0];
						int q = j + d[1];
						if (p >= 0 && p < m && q >= 0 && q < n
								&& grid[p][q] > 1) {
							if (!s.contains(grid[p][q])) {
								s.add(grid[p][q]);
								area += map.get(grid[p][q]);
							}
						}
					}
					max = Math.max(max, area);
				}
			}
		}
		return max;
	}

	public int dfs(int[][] grid, int x, int y, int id) {
		int ans = 1;
		grid[x][y] = id;
		for (int[] d : dirs) {
			int i = x + d[0];
			int j = y + d[1];
			if (i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1) {
				ans += dfs(grid, i, j, id);
			}
		}
		return ans;
	}
}
