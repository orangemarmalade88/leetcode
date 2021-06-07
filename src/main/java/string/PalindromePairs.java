package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PalindromePairs {
	class Solution {

		// Is the given string a palindrome after index i?
		// Tip: Leave this as a method stub in an interview unless you have time
		// or the interviewer tells you to write it. The Trie itself should be
		// the main focus of your time.
		public boolean hasPalindromeRemaining(String s, int i) {
			int p1 = i;
			int p2 = s.length() - 1;
			while (p1 < p2) {
				if (s.charAt(p1) != s.charAt(p2))
					return false;
				p1++;
				p2--;
			}
			return true;
		}

		public List<List<Integer>> palindromePairs(String[] words) {

			TrieNode trie = new TrieNode();

			// Build the Trie
			for (int wordId = 0; wordId < words.length; wordId++) {
				String word = words[wordId];
				String reversedWord = new StringBuilder(word).reverse()
						.toString();
				TrieNode currentTrieLevel = trie;
				for (int j = 0; j < word.length(); j++) {
					if (hasPalindromeRemaining(reversedWord, j)) {
						currentTrieLevel.palindromePrefix.add(wordId);
					}
					Character c = reversedWord.charAt(j);
					if (!currentTrieLevel.next.containsKey(c)) {
						currentTrieLevel.next.put(c, new TrieNode());
					}
					currentTrieLevel = currentTrieLevel.next.get(c);
				}
				currentTrieLevel.wordEnding = wordId;
			}

			// Find pairs
			List<List<Integer>> pairs = new ArrayList<>();
			for (int wordId = 0; wordId < words.length; wordId++) {
				String word = words[wordId];
				TrieNode currentTrieLevel = trie;
				for (int j = 0; j < word.length(); j++) {
					// Check for pairs of case 3.
					if (currentTrieLevel.wordEnding != -1
							&& hasPalindromeRemaining(word, j)) {
						pairs.add(Arrays.asList(wordId,
								currentTrieLevel.wordEnding));
					}
					// Move down to the next trie level.
					Character c = word.charAt(j);
					currentTrieLevel = currentTrieLevel.next.get(c);
					if (currentTrieLevel == null)
						break;
				}
				if (currentTrieLevel == null)
					continue;
				// Check for pairs of case 1. Note the check to prevent non
				// distinct pairs.
				if (currentTrieLevel.wordEnding != -1
						&& currentTrieLevel.wordEnding != wordId) {
					pairs.add(
							Arrays.asList(wordId, currentTrieLevel.wordEnding));
				}
				// Check for pairs of case 2.
				for (int other : currentTrieLevel.palindromePrefix) {
					pairs.add(Arrays.asList(wordId, other));
				}
			}

			return pairs;
		}
	}

	class TrieNode {
		public int wordEnding = -1;
		public Map<Character, TrieNode> next = new HashMap<>();
		public List<Integer> palindromePrefix = new ArrayList<>();
	}

	public boolean isPalindrome(String s) {
		StringBuilder sb = new StringBuilder(s);
		return s.equals(sb.reverse().toString());
	}

	public List<List<Integer>> palindromePairs(String[] words) {
		List<List<Integer>> res = new ArrayList<>();

		TrieNode root = new TrieNode();
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			StringBuilder sb = new StringBuilder(word);
			String reverse = sb.reverse().toString();
			TrieNode cur = root;
			for (int j = 0; j < reverse.length(); j++) {
				char c = reverse.charAt(j);
				if (!cur.next.containsKey(c)) {
					TrieNode next = new TrieNode();
					cur.next.put(c, next);
				}
				String remaining = reverse.substring(j + 1);
				if (isPalindrome(remaining)) {
					cur.palindromePrefix.add(i);
				}
				cur = cur.next.get(c);
			}
			cur.wordEnding = i;
		}

		// case 1
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			TrieNode cur = root;
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if (cur.next.containsKey(c)) {
					cur = cur.next.get(c);
					if (j == word.length() - 1 && cur.wordEnding != -1
							&& cur.wordEnding != i) {
						res.add(List.of(i, cur.wordEnding));
					}
				} else {
					break;
				}
			}
		}

		// case 2
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			TrieNode cur = root;
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if (cur.next.containsKey(c)) {
					cur = cur.next.get(c);
					if (j == word.length() - 1) {
						for (int k : cur.palindromePrefix) {
							if (i != k)
								res.add(List.of(i, k));
						}
					}
				} else {
					break;
				}
			}
		}

		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			TrieNode cur = root;
			for (int j = 0; j < word.length(); j++) {
				char c = word.charAt(j);
				if (cur.next.containsKey(c)) {
					if (cur.wordEnding != -1 && cur.wordEnding != i
							&& isPalindrome(word.substring(j + 1))) {
						res.add(List.of(i, cur.wordEnding));
					}
				} else {
					break;
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		String[] words = { "a", "" };
		PalindromePairs x = new PalindromePairs();
		PalindromePairs.Solution p = x.new Solution();
		x.palindromePairs(words);
	}
}
