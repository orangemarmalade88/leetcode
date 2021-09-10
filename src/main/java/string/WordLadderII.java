package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class WordLadderII {
	public List<List<String>> findLadders(String src, String des,
			List<String> wordList) {
		int length = src.length();
		List<List<String>> res = new ArrayList<>();
		Queue<List<String>> q = new LinkedList<>();
		q.add(List.of(src));
		Set<String> seen = new HashSet<>();
		seen.add(src);
		Set<String> dict = new HashSet<>();
		for (String s : wordList) {
			dict.add(s);
		}
		boolean r = false;
		while (!q.isEmpty()) {
			int size = q.size();
			Set<String> newSeen = new HashSet<>();
			while (size-- > 0) {
				List<String> list = q.poll();
				String cur = list.get(list.size() - 1);
				if (cur.equals(des)) {
					r = true;
					res.add(list);
				}
				StringBuilder sb = new StringBuilder(cur);
				for (int i = 0; i < length; i++) {
					char original = sb.charAt(i);
					for (char c = 'a'; c <= 'z'; c++) {
						sb.setCharAt(i, c);
						if (dict.contains(sb.toString())
								&& !seen.contains(sb.toString())) {
							List<String> next = new ArrayList<>(list);
							next.add(sb.toString());
							q.add(next);
							newSeen.add(sb.toString());
						}
					}
					sb.setCharAt(i, original);
				}
			}
			seen.addAll(newSeen);
			if (r) {
				return res;
			}
		}
		return res;
	}
}
