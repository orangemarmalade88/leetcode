package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MakingALargeIsland {

	int[][] dirs = { { 1, 0 }, { 0, 1 }, { 0, -1 }, { -1, 0 } };
	int r;
	int c;

	public int largestIsland(int[][] grid) {
		r = grid.length;
		c = grid[0].length;
		int max = 0;

		int id = 2;
		Map<Integer, Integer> map = new HashMap<>();

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 1) {
					int area = dfs(i, j, grid, id);
					max = Math.max(max, area);

					map.put(id, area);
					id++;
				}
			}
		}

		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (grid[i][j] == 0) {
					int area = 1;
					Set<Integer> visited = new HashSet<>();

					for (int[] dir : dirs) {
						int x = i + dir[0];
						int y = j + dir[1];
						if (x >= 0 && x < r && y >= 0 && y < c
								&& grid[x][y] > 0) {
							area += visited.contains(grid[x][y]) ? 0
									: map.get(grid[x][y]);
							visited.add(grid[x][y]);
						}

					}
					max = Math.max(max, area);
				}
			}
		}
		return max;
	}

	public int dfs(int i, int j, int[][] grid, int id) {
		if (grid[i][j] != 1)
			return 0;
		grid[i][j] = id;
		int area = 1;
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x >= 0 && x < r && y >= 0 && y < c && grid[x][y] == 1)
				area += dfs(x, y, grid, id);
		}
		return area;
	}
}
