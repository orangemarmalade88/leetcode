package graph;

public class ColoringABorder {

	int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	int r = -1;
	int c = -1;

	public int[][] colorBorder(int[][] grid, int row, int col, int color) {
		r = grid.length;
		c = grid[0].length;
		int[][] result = new int[r][c];
		boolean[][] visited = new boolean[r][c];
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++)
				result[i][j] = grid[i][j];
		}
		dfs(grid, row, col, color, result, visited);
		return result;
	}

	public void dfs(int[][] grid, int row, int col, int color, int[][] result,
			boolean[][] visited) {
		if (isBorder(grid, row, col)) {
			result[row][col] = color;
		}
		visited[row][col] = true;
		for (int[] d : directions) {
			int x = row + d[0];
			int y = col + d[1];
			if (x < 0 || x >= r || y < 0 || y >= c)
				continue;
			if (visited[x][y] || grid[row][col] != grid[x][y])
				continue;
			dfs(grid, x, y, color, result, visited);
		}
	}

	public boolean isBorder(int[][] grid, int row, int column) {
		for (int[] d : directions) {
			int x = row + d[0];
			int y = column + d[1];

			if (x < 0 || x >= r || y < 0 || y >= c)
				return true;

			if (grid[x][y] != grid[row][column])
				return true;
		}
		return false;
	}
}
