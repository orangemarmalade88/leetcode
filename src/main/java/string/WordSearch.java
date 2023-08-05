package string;

public class WordSearch {

	int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
	int m;
	int n;

	public boolean exist(char[][] board, String word) {
		m = board.length;
		n = board[0].length;
		boolean[][] visited = new boolean[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (dfs(board, word, 0, i, j, visited))
					return true;
			}
		}
		return false;
	}

	public boolean dfs(char[][] board, String word, int index, int x, int y,
			boolean[][] visited) {
		if (x >= m || x < 0 || y >= n || y < 0)
			return false;
		if (visited[x][y] || board[x][y] != word.charAt(index))
			return false;
		if (index == word.length() - 1)
			return true;
		visited[x][y] = true;
		for (int[] dir : directions) {
			if (dfs(board, word, index + 1, x + dir[0], y + dir[1], visited))
				return true;
		}
		visited[x][y] = false;
		return false;
	}

	public static void main(String[] args) {

	}
}
