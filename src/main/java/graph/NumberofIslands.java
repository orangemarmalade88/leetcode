package graph;

/*

 Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 You may assume all four edges of the grid are all surrounded by water.

 Example 1:
 11110
 11010
 11000
 00000

 Answer: 1

 Example 2:
 11000
 11000
 00100
 00011

 Answer: 3

 */

public class NumberofIslands {
	public int numIslands(char[][] grid) {
		if (grid.length == 0 || grid[0].length == 0)
			return 0;

		boolean visited[][] = new boolean[grid.length][grid[0].length];
		int count = 0;

		for (int row = 0; row < grid.length; row++) {
			for (int column = 0; column < grid[0].length; column++) {
				if (grid[row][column] == '1' && !visited[row][column]) {
					dfs(grid, row, column, visited);
					count++;
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int row, int column, boolean[][] visited) {
		if (row < 0 || row >= grid.length)
			return;
		if (column < 0 || column >= grid[0].length)
			return;
		if (visited[row][column] || grid[row][column] == '0')
			return;
		visited[row][column] = true;
		dfs(grid, row + 1, column, visited);
		dfs(grid, row - 1, column, visited);
		dfs(grid, row, column + 1, visited);
		dfs(grid, row, column - 1, visited);
	}
}
