package game;

/*OK

 Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 A partially filled sudoku which is valid.

 Note:
 A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

 */

public class ValidSoduku {
	public boolean isValidSudoku(char[][] board) {
		// Check each rows
		for (int i = 0; i < 9; i++) {
			boolean[] visited = new boolean[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					continue;
				else {
					int n = board[i][j] - '1';
					if (visited[n])
						return false;
					else
						visited[n] = true;
				}
			}
		}

		// Check each rows
		for (int j = 0; j < 9; j++) {
			boolean[] visited = new boolean[9];
			for (int i = 0; i < 9; i++) {
				if (board[i][j] == '.')
					continue;
				else {
					int n = board[i][j] - '1';
					if (visited[n])
						return false;
					else
						visited[n] = true;
				}
			}
		}

		// Check each grids
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boolean[] visited = new boolean[9];
				for (int x = 0; x < 3; x++) {
					for (int y = 0; y < 3; y++) {
						if (board[i * 3 + x][j * 3 + y] == '.')
							continue;
						else {
							int n = board[i * 3 + x][j * 3 + y] - '1';
							if (visited[n])
								return false;
							else
								visited[n] = true;
						}
					}
				}

			}
		}
		return true;
	}

}
