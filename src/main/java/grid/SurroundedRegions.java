package grid;

public class SurroundedRegions {
	int m;
	int n;
	int[][] dirs = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };

	public void solve(char[][] board) {
		m = board.length;
		n = board[0].length;

		for (int i = 0; i < m; i++) {
			dfs(board, i, 0);
			dfs(board, i, n - 1);
		}
		for (int j = 0; j < n; j++) {
			dfs(board, 0, j);
			dfs(board, m - 1, j);
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (board[i][j] == 'R')
					board[i][j] = 'O';
				else if (board[i][j] == 'O')
					board[i][j] = 'X';
			}
		}
	}

	private void dfs(char[][] board, int x, int y) {
		if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != 'O')
			return;
		board[x][y] = 'R';
		for (int[] d : dirs) {
			dfs(board, x + d[0], y + d[1]);
		}
	}
}
