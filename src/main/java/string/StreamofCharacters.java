package string;

class StreamChecker {

	class TrieNode {
		TrieNode[] children = new TrieNode[26];
		boolean isLeaf = false;

		void insert(String s) {
			TrieNode cur = root;
			for (int i = s.length() - 1; i >= 0; i--) {
				char c = s.charAt(i);
				int index = c - 'a';
				if (cur.children[index] == null)
					cur.children[index] = new TrieNode();
				cur = cur.children[index];
			}
			cur.isLeaf = true;
		}

	}

	TrieNode root = new TrieNode();
	StringBuilder sb = new StringBuilder();

	public StreamChecker(String[] words) {

		for (String s : words) {
			root.insert(s);
		}
	}

	public boolean query(char letter) {
		sb.append(letter);
		TrieNode cur = root;
		for (int i = sb.length() - 1; i >= 0; i--) {
			char c = sb.charAt(i);
			int index = c - 'a';
			if (cur.children[index] == null)
				return false;
			cur = cur.children[index];
			if (cur.isLeaf)
				return true;
		}
		return false;
	}
}
