package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*

 Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 1.Only one letter can be changed at a time
 2.Each intermediate word must exist in the word list

 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]


 As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 return its length 5.

 Note:

 -Return 0 if there is no such transformation sequence.
 -All words have the same length.
 -All words contain only lowercase alphabetic characters.

 */

public class WordLadder {
	public int ladderLength(String beginWord, String endWord,
			Set<String> wordList) {
		List<String> current = new ArrayList<>();
		List<String> next = new ArrayList<>();
		current.add(beginWord);
		int l = 2;
		while (!current.isEmpty()) {
			for (String s : current) {
				char[] array = s.toCharArray();
				for (int i = 0; i < s.length(); i++) {
					char temp = array[i];
					for (char r = 'a'; r <= 'z'; r++) {
						array[i] = r;
						String newS = String.valueOf(array);
						if (endWord.equals(newS))
							return l;
						if (wordList.contains(newS)) {
							next.add(newS);
							wordList.remove(newS);
						}
					}
					array[i] = temp;
				}
			}
			current = next;
			next = new ArrayList<>();
			l++;
		}
		return 0;
	}

	public int ladderLength2(String beginWord, String endWord,
			Set<String> wordList) {
		List<String> current = new ArrayList<>();
		List<String> next = new ArrayList<>();
		current.add(beginWord);

		Set<String> r_current = new HashSet<>();
		Set<String> r_next = new HashSet<>();
		r_current.add(endWord);
		Set<String> r_wordList = new HashSet<>(wordList);

		int l = 1;
		while (!current.isEmpty() && !r_current.isEmpty()) {
			for (String s : current) {
				char[] array = s.toCharArray();
				for (int i = 0; i < s.length(); i++) {
					char temp = array[i];
					for (char r = 'a'; r <= 'z'; r++) {
						array[i] = r;
						String newS = String.valueOf(array);
						if (r_current.contains(newS)) {
							return 2 * l;
						}
						if (wordList.contains(newS)) {
							next.add(newS);
							wordList.remove(newS);
						}
					}
					array[i] = temp;
				}
			}

			for (String s : r_current) {
				char[] array = s.toCharArray();
				for (int i = 0; i < s.length(); i++) {
					char temp = array[i];
					for (char r = 'a'; r <= 'z'; r++) {
						array[i] = r;
						String newS = String.valueOf(array);
						if (next.contains(newS)) {
							return 2 * l + 1;
						}
						if (r_wordList.contains(newS)) {
							r_next.add(newS);
							r_wordList.remove(newS);
						}
					}
					array[i] = temp;
				}
			}
			current = next;
			next = new ArrayList<>();
			r_current = r_next;
			r_next = new HashSet<>();
			l++;
		}
		return 0;

	}
}
