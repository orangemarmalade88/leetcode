package grid;

public class NumberofClosedIslands {
	static int m;
	static int n;

	static int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

	public static int closedIsland(int[][] grid) {
		m = grid.length;
		n = grid[0].length;

		for (int j = 0; j < n; j++) {
			if (grid[0][j] == 0) {
				dfs(grid, 0, j, 2); // 2 = corner island
			}
			if (grid[m - 1][j] == 0) {
				dfs(grid, m - 1, j, 2);
			}
		}

		for (int i = 0; i < m; i++) {
			if (grid[i][0] == 0) {
				dfs(grid, i, 0, 2); // 2 = corner island
			}
			if (grid[i][n - 1] == 0) {
				dfs(grid, i, n - 1, 2);
			}
		}

		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == 0) {
					dfs(grid, i, j, 3);
					count++;
				}
			}
		}
		return count;
	}

	public static void dfs(int[][] grid, int i, int j, int state) {
		grid[i][j] = state;
		for (int[] dir : dirs) {
			int x = i + dir[0];
			int y = j + dir[1];
			if (x >= 0 && x < m && y >= 0 && y < m)
				System.out.println(grid[x][y]);

			if (x >= 0 && x < m && y >= 0 && y < m && grid[x][y] == 0) {
				dfs(grid, x, y, state);
			}
		}
	}

	public static void main(String[] args) {
		int[][] input = {
				{ 0, 1, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1 },
				{ 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 0, 1, 0, 1 },
				{ 1, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 0 },
				{ 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0 },
				{ 1, 1, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1 },
				{ 1, 1, 0, 0, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 1 },
				{ 1, 0, 1, 1, 0, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0 },
				{ 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0 },
				{ 1, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 1, 0, 1, 0, 1, 1 },
				{ 1, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0 },
				{ 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1 },
				{ 0, 1, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0 },
				{ 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 1, 0, 1, 0,
						1 } };
		closedIsland(input);
	}

}
