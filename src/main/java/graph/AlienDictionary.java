package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AlienDictionary {

	private StringBuilder sb = new StringBuilder();

	public String alienOrder(String[] words) {
		Map<Character, Set<Character>> graph = new HashMap<>();
		Map<Character, Integer> seen = new HashMap<>();
		// 0 - unvisited
		// 1 - visiting
		// 2 - visited

		for (String word : words) {
			for (char c : word.toCharArray()) {
				graph.putIfAbsent(c, new HashSet<>());
				seen.putIfAbsent(c, 0);
			}
		}

		for (int i = 0; i < words.length - 1; i++) {
			String w1 = words[i], w2 = words[i + 1];
			int minLen = Math.min(w1.length(), w2.length());
			boolean foundDiff = false;

			for (int j = 0; j < minLen; j++) {
				char c1 = w1.charAt(j), c2 = w2.charAt(j);
				if (c1 != c2) {
					if (!graph.get(c2).contains(c1)) {
						graph.get(c2).add(c1);
					}
					foundDiff = true;
					break;
				}
			}

			if (!foundDiff && w1.length() > w2.length())
				return "";

		}

		for (char c : graph.keySet()) {
			if (!dfs(c, graph, seen))
				return "";
		}

		return sb.toString(); // sb.length() == graph.keySet().size() ?
								// sb.toString() : "";
	}

	public boolean dfs(char c, Map<Character, Set<Character>> graph,
			Map<Character, Integer> seen) {
		if (seen.get(c) == 1)
			return false;
		if (seen.get(c) == 2)
			return true;
		seen.put(c, 1);
		Set<Character> parents = graph.get(c);
		for (char next : parents) {
			if (seen.get(next) == 1)
				return false;
			else if (seen.get(next) == 0)
				dfs(next, graph, seen);
		}
		seen.put(c, 2);
		sb.append(c);
		return true;
	}
}
