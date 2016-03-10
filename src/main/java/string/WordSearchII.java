package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

 Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 Given words = ["oath","pea","eat","rain"] and board =
 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]

 Return ["eat","oath"].

 Note:
 You may assume that all inputs are consist of lowercase letters a-z.

 */

public class WordSearchII {

	class TrieNode {

		TrieNode[] children;
		int val;

		// Initialize your data structure here.
		public TrieNode() {
			children = new TrieNode[26];
		}
	}

	public class Trie {
		private final TrieNode root;

		public Trie() {
			root = new TrieNode();
		}

		// Inserts a word into the trie.
		public void insert(String word) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				if (current.children[word.charAt(i) - 'a'] == null) {
					current.children[word.charAt(i) - 'a'] = new TrieNode();
				}
				current = current.children[word.charAt(i) - 'a'];
			}
			current.val = 1;
		}

		// Returns if the word is in the trie.
		public boolean search(String word) {
			TrieNode current = root;
			for (int i = 0; i < word.length(); i++) {
				current = current.children[word.charAt(i) - 'a'];
				if (current == null)
					return false;
			}
			return current.val == 1;
		}

		// Returns if there is any word in the trie
		// that starts with the given prefix.
		public boolean startsWith(String prefix) {
			TrieNode current = root;
			for (int i = 0; i < prefix.length(); i++) {
				current = current.children[prefix.charAt(i) - 'a'];
				if (current == null)
					return false;
			}
			return true;
		}
	}

	public List<String> findWords(char[][] board, String[] words) {
		Trie trie = new Trie();
		int max = 0;
		for (String s : words) {
			trie.insert(s);
			max = Math.max(max, s.length());
		}
		return exist(trie, board, max);
	}

	private List<String> exist(Trie trie, char[][] board, int max) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		StringBuilder sb = new StringBuilder();
		Set<String> found = new HashSet<>();
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				dfs(trie, board, visited, sb, found, max, row, column);
			}
		}
		List<String> result = new ArrayList<>(found);
		return result;
	}

	private void dfs(Trie trie, char[][] board, boolean[][] visited,
			StringBuilder current, Set<String> found, int max, int row,
			int column) {
		if (row < 0 || row >= board.length)
			return;
		if (column < 0 || column >= board[0].length)
			return;
		if (visited[row][column])
			return;
		if (current.length() > max)
			return;
		current.append(board[row][column]);
		if (!trie.startsWith(current.toString())) {
			current.deleteCharAt(current.length() - 1);
			return;
		}
		visited[row][column] = true;
		if (trie.search(current.toString()))
			found.add(current.toString());
		dfs(trie, board, visited, current, found, max, row + 1, column);
		dfs(trie, board, visited, current, found, max, row - 1, column);
		dfs(trie, board, visited, current, found, max, row, column + 1);
		dfs(trie, board, visited, current, found, max, row, column - 1);
		visited[row][column] = false;
		current.deleteCharAt(current.length() - 1);
	}

	// Improvement, use TrieNode instead of Trie, so we can search in O(1)
	// instead of O(N)
	public List<String> findWords2(char[][] board, String[] words) {
		Trie trie = new Trie();
		int max = 0;
		for (String s : words) {
			trie.insert(s);
			max = Math.max(max, s.length());
		}
		return exist2(trie.root, board, max);
	}

	private List<String> exist2(TrieNode node, char[][] board, int max) {
		boolean[][] visited = new boolean[board.length][board[0].length];
		StringBuilder sb = new StringBuilder();
		Set<String> found = new HashSet<>();
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				dfs2(node, board, visited, sb, found, max, row, column);
			}
		}
		List<String> result = new ArrayList<>(found);
		return result;
	}

	private void dfs2(TrieNode node, char[][] board, boolean[][] visited,
			StringBuilder current, Set<String> found, int max, int row,
			int column) {
		if (row < 0 || row >= board.length)
			return;
		if (column < 0 || column >= board[0].length)
			return;
		if (visited[row][column])
			return;
		if (current.length() > max)
			return;
		current.append(board[row][column]);
		String candidate = current.toString();
		node = node.children[board[row][column] - 'a'];
		if (node == null) {
			current.deleteCharAt(current.length() - 1);
			return;
		}
		visited[row][column] = true;
		if (node.val == 1)
			found.add(candidate);
		dfs2(node, board, visited, current, found, max, row + 1, column);
		dfs2(node, board, visited, current, found, max, row - 1, column);
		dfs2(node, board, visited, current, found, max, row, column + 1);
		dfs2(node, board, visited, current, found, max, row, column - 1);
		visited[row][column] = false;
		current.deleteCharAt(current.length() - 1);
	}
}
