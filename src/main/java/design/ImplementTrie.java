package design;

public class ImplementTrie {

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

}
