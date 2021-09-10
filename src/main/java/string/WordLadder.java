package string;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class WordLadder {
	public int ladderLength(String src, String des, List<String> wordList) {
		int length = src.length();
		Queue<String> q = new LinkedList<>();
		q.add(src);
		Set<String> seen = new HashSet<>();
		seen.add(src);
		Set<String> dict = new HashSet<>();
		for (String s : wordList) {
			dict.add(s);
		}
		int steps = 1;
		while (!q.isEmpty()) {
			int size = q.size();
			while (size-- > 0) {
				String cur = q.poll();
				if (cur.equals(des))
					return steps;
				StringBuilder sb = new StringBuilder(cur);
				for (int i = 0; i < length; i++) {
					char original = sb.charAt(i);
					for (char c = 'a'; c <= 'z'; c++) {
						sb.setCharAt(i, c);
						if (dict.contains(sb.toString())
								&& !seen.contains(sb.toString())) {
							q.add(sb.toString());
							seen.add(sb.toString());
						}
					}
					sb.setCharAt(i, original);
				}
			}
			steps++;
		}
		return 0;
	}
}
