package string;

import java.util.ArrayList;
import java.util.List;

/*

 Design a data structure that supports the following two operations:
 void addWord(word)
 boolean search(word)

 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:
 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true


 Note:
 You may assume that all words are consist of lowercase letters a-z.

 */

public class AddAndSearchWord {
	public class WordDictionary {

		class TrieNode {
			boolean word;
			TrieNode[] next = new TrieNode[26];
		}

		TrieNode root = new TrieNode();

		// Adds a word into the data structure.
		public void addWord(String word) {
			TrieNode current = root;
			for (char c : word.toCharArray()) {
				int index = c - 'a';
				if (current.next[index] == null) {
					current.next[index] = new TrieNode();
				}
				current = current.next[index];
			}
			current.word = true;
		}

		// Returns if the word is in the data structure. A word could
		// contain the dot character '.' to represent any one letter.
		public boolean search(String word) {
			return dfs(word, root, 0);
		}

		private boolean dfs(String word, TrieNode current, int index) {
			if (current == null)
				return false;
			if (index == word.length())
				return current.word;
			if (word.charAt(index) == '.') {
				List<TrieNode> list = getAllPossible(current);
				boolean result = false;
				for (TrieNode cur : list) {
					result |= dfs(word, cur, index + 1);
				}
				return result;
			}
			return dfs(word, current.next[word.charAt(index) - 'a'], index + 1);
		}

		private List<TrieNode> getAllPossible(TrieNode current) {
			List<TrieNode> list = new ArrayList<>();
			for (TrieNode n : current.next) {
				if (n != null)
					list.add(n);
			}
			return list;
		}
	}

	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
}
