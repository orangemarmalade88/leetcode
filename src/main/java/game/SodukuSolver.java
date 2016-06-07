package game;

public class SodukuSolver {
	public void solveSudoku(char[][] board) {
		int start = findNextOpenPixel(board, 0, 0);
		dfs(board, start / 9, start % 9);
	}

	private boolean dfs(char[][] board, int row, int col) {
		if (row == 9) {
			return true;
		} else {
			int start = findNextOpenPixel(board, row, col + 1);
			for (int i = '1'; i <= '9'; i++) {
				board[row][col] = (char) i;
				if (isValid(board, row, col)) {
					if (dfs(board, start / 9, start % 9))
						return true;
				}
			}
			return false;
		}
	}

	private int findNextOpenPixel(char[][] board, int row, int col) {
		int start = 9 * row + col;
		while (start < 81 && board[start / 9][start % 9] != '.') {
			start++;
		}
		return start;
	}

	private boolean isValid(char[][] board, int row, int col) {
		boolean[] v_c = new boolean[9];
		for (int c = 0; c < 9; c++) {
			if (board[row][c] != '.') {
				int n = board[row][c] - '1';
				if (!v_c[n]) {
					v_c[n] = true;
				} else {
					return false;
				}
			}

		}

		boolean[] v_r = new boolean[9];
		for (int r = 0; r < 9; r++) {
			if (board[r][col] != '.') {
				int n = board[r][col] - '1';
				if (!v_r[n]) {
					v_r[n] = true;
				} else {
					return false;
				}
			}

		}

		boolean[] v_s = new boolean[9];
		int s_x = row / 3;
		int s_y = col / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[s_x * 3 + i][s_y * 3 + j] != '.') {
					int n = board[s_x * 3 + i][s_y * 3 + j] - '1';
					for (int r = 0; r < 9; r++) {
						if (!v_s[n]) {
							v_s[n] = true;
						} else {
							return false;
						}
					}

				}
			}
		}

		return true;
	}
}
