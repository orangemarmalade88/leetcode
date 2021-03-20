package graph;

public class MaxAreaOfIslands {
	/*
	 * 695. Max Area of Island
	 *
	 * Given a non-empty 2D array grid of 0's and 1's, an island is a group of
	 * 1's (representing land) connected 4-directionally (horizontal or
	 * vertical.) You may assume all four edges of the grid are surrounded by
	 * water.
	 *
	 * Find the maximum area of an island in the given 2D array. (If there is no
	 * island, the maximum area is 0.)
	 *
	 *
	 */
	public int maxAreaOfIsland(int[][] grid) {
		int height = grid.length;
		int length = grid[0].length;
		boolean[][] visited = new boolean[height][length];
		int max = 0;
		for (int j = 0; j < height; j++) {
			for (int i = 0; i < length; i++) {
				if (grid[j][i] == 0 || visited[j][i]) {
					continue;
				}
				int area = dfs(grid, visited, i, j);
				max = area > max ? area : max;
			}
		}
		return max;
	}

	public int dfs(int[][] grid, boolean[][] visited, int i, int j) {
		if (i < 0 || i >= grid[0].length)
			return 0;
		if (j < 0 || j >= grid.length)
			return 0;
		if (grid[j][i] == 0 || visited[j][i])
			return 0;
		visited[j][i] = true;
		return 1 + dfs(grid, visited, i + 1, j) + dfs(grid, visited, i - 1, j)
				+ dfs(grid, visited, i, j + 1) + dfs(grid, visited, i, j - 1);
	}
}
