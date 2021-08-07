package grid;

public class NumberofIslands {
	int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
	int m;
	int n;

	public int numIslands(char[][] grid) {
		int res = 0;
		m = grid.length;
		n = grid[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1' && !visited[i][j]) {
					dfs(grid, i, j, visited);
					res++;
				}
			}
		}
		return res;
	}

	private void dfs(char[][] grid, int x, int y, boolean[][] visited) {
		if (x < 0 || y < 0 || x >= m || y >= n || visited[x][y]
				|| grid[x][y] == '0')
			return;
		visited[x][y] = true;
		for (int[] d : dirs) {
			dfs(grid, x + d[0], y + d[1], visited);
		}
	}
}
