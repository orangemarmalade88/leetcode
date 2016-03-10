package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*

 Given two words (beginWord and endWord), and a dictionary's word list, find all shortest transformation sequence(s) from beginWord to endWord, such that:
 1.Only one letter can be changed at a time
 2.Each intermediate word must exist in the word list

 For example,

 Given:
 beginWord = "hit"
 endWord = "cog"
 wordList = ["hot","dot","dog","lot","log"]


 Return

 [
 ["hit","hot","dot","dog","cog"],
 ["hit","hot","lot","log","cog"]
 ]



 Note:

 -All words have the same length.
 -All words contain only lowercase alphabetic characters.

 */

public class WordLadderII {
	public List<List<String>> findLadders(String beginWord, String endWord,
			Set<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		List<List<String>> paths = new ArrayList<>();
		List<List<String>> next = new ArrayList<>();
		boolean foundSolution = false;
		paths.add(Arrays.asList(beginWord));
		while (!paths.isEmpty() && !foundSolution) {
			Set<String> toRemove = new HashSet<>();
			for (List<String> path : paths) {
				String last = path.get(path.size() - 1);
				char[] array = last.toCharArray();
				for (int i = 0; i < last.length(); i++) {
					char temp = array[i];
					for (char c = 'a'; c <= 'z'; c++) {
						array[i] = c;
						String candidate = new String(array);
						if (candidate.equals(endWord)) {
							List<String> n = new ArrayList<>(path);
							n.add(candidate);
							result.add(n);
							foundSolution = true;
						}
						if (wordList.contains(candidate)) {
							List<String> n = new ArrayList<>(path);
							n.add(candidate);
							next.add(n);
							toRemove.add(candidate);
						}
					}
					array[i] = temp;
				}
			}
			paths = next;
			next = new ArrayList<>();
			wordList.removeAll(toRemove);
		}
		return result;
	}

	// Key optimization here: REALLY IMPORTANT
	// suppose you have two paths from ABB->ADD->TARGET, eg: ABB->ADB->ADD;
	// ABB->ABD->ADD
	// are you going to process ADD twice?
	// if you are saving the entire path, then ADD is going to be processed
	// twice.
	// if you save the all the parents of ADD, then the second time you see ADD,
	// you don't need to process it

	private void addToParentMap(String current, String parent,
			Map<String, List<String>> parents) {
		if (parents.containsKey(current)) {
			parents.get(current).add(parent);
		} else {
			// Mistake: Can't do Arrays.asList(parent)
			// Because List create by this call is immutable
			List<String> list = new ArrayList<>();
			list.add(parent);
			parents.put(current, list);
		}
	}

	private void dfs(String currentWord, String target,
			Map<String, List<String>> parents, List<String> current,
			List<List<String>> result) {
		if (currentWord.equals(target)) {
			List<String> temp = new ArrayList<>(current);
			Collections.reverse(temp);
			result.add(temp);
		} else {
			List<String> candidates = parents.get(currentWord);
			for (String s : candidates) {
				current.add(s);
				dfs(s, target, parents, current, result);
				current.remove(current.size() - 1);
			}
		}
	}

	public List<List<String>> findLadders2(String beginWord, String endWord,
			Set<String> wordList) {
		List<List<String>> result = new ArrayList<>();
		List<String> current = new ArrayList<>();
		List<String> next = new ArrayList<>();

		Map<String, List<String>> parents = new HashMap<>();

		boolean foundSolution = false;
		current.add(beginWord);

		// BFS to construct str -> parents map
		while (!current.isEmpty() && !foundSolution) {
			Set<String> toRemove = new HashSet<>();
			for (String cur : current) {
				char[] array = cur.toCharArray();
				for (int i = 0; i < cur.length(); i++) {
					char temp = array[i];
					for (char c = 'a'; c <= 'z'; c++) {
						if (array[i] != c) {
							array[i] = c;
							String candidate = new String(array);
							if (candidate.equals(endWord)) {
								addToParentMap(candidate, cur, parents);
								foundSolution = true;
							} else if (wordList.contains(candidate)) {
								addToParentMap(candidate, cur, parents);
								if (!toRemove.contains(candidate)) {
									next.add(candidate);
									toRemove.add(candidate);
								}
							}
						}
					}
					array[i] = temp;
				}
			}
			current = next;
			next = new ArrayList<>();
			wordList.removeAll(toRemove);
		}

		// DFS to reconstruct path
		if (foundSolution) {
			List<String> list = new ArrayList<>();
			list.add(endWord);
			dfs(endWord, beginWord, parents, list, result);
		}
		return result;
	}
}
