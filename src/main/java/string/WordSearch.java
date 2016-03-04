package string;

/*

 Given a 2D board and a word, find if the word exists in the grid.

 The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring.
 The same letter cell may not be used more than once.

 For example,
 Given board =
 [
 ['A','B','C','E'],
 ['S','F','C','S'],
 ['A','D','E','E']
 ]

 word = "ABCCED", -> returns true,
 word = "SEE", -> returns true,
 word = "ABCB", -> returns false.

 */

public class WordSearch {
	public boolean exist(char[][] board, String word) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		// Important: reuse the same variable! Improves run time a lot!
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				if (dfs(board, visited, word, 0, row, column))
					return true;
			}
		}

		return false;
	}

	private boolean dfs(char[][] board, boolean[][] visited, String word,
			int index, int row, int column) {
		if (row < 0 || row >= board.length)
			return false;
		if (column < 0 || column >= board[0].length)
			return false;
		if (board[row][column] != word.charAt(index))
			return false;
		if (visited[row][column])
			return false;
		if (index == word.length() - 1)
			return true;
		visited[row][column] = true;
		boolean rec = dfs(board, visited, word, index + 1, row + 1, column)
				|| dfs(board, visited, word, index + 1, row - 1, column)
				|| dfs(board, visited, word, index + 1, row, column + 1)
				|| dfs(board, visited, word, index + 1, row, column - 1);
		visited[row][column] = false;
		return rec;
	}
}
