package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class AlienDictionary {
	public String alienOrder(String[] words) {
		Map<Character, Integer> inDegree = new HashMap<>();
		Map<Character, Set<Character>> children = new HashMap<>();
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < words.length; i++) {
			for (int j = 0; j < words[i].length(); j++) {
				inDegree.putIfAbsent(words[i].charAt(j), 0);
				children.putIfAbsent(words[i].charAt(j),
						new HashSet<Character>());
			}
		}

		for (int i = 0; i < words.length; i++) {
			for (int j = i + 1; j < words.length; j++) {
				int n = 0;
				char[] wordA = words[i].toCharArray();
				char[] wordB = words[j].toCharArray();
				int minL = Math.min(wordA.length, wordB.length);
				while (n < minL && wordA[n] == wordB[n]) {
					n++;
				}

				if (n < minL) {
					if (!children.get(wordA[n]).contains(wordB[n])) {
						children.get(wordA[n]).add(wordB[n]);
						inDegree.put(wordB[n], inDegree.get(wordB[n]) + 1);
					}
				}
			}
		}

		Queue<Character> queue = new LinkedList<>();
		for (char c : inDegree.keySet()) {
			if (inDegree.get(c) == 0)
				queue.offer(c);
		}
		while (!queue.isEmpty()) {
			char c = queue.poll();
			sb.append(c);
			Set<Character> childs = children.get(c);
			for (Character d : childs) {
				int oldDegree = inDegree.get(d);
				inDegree.put(d, oldDegree - 1);
				if (oldDegree == 1)
					queue.offer(d);
			}
		}

		if (sb.length() == children.size())
			return sb.toString();
		return "";
	}
}
