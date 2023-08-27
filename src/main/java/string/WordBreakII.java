package string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakII {
	public List<String> wordBreak(String s, List<String> wordDict) {
		List<List<String>> patterns = new ArrayList<>();
		// patterns[i] = all patterns from i to end

		int n = s.length();
		for (int i = 0; i < n; i++) {
			patterns.add(new ArrayList<>());
		}
		patterns.add(List.of(""));
		Set<String> dict = new HashSet<>(wordDict);
		for (int j = n - 1; j >= 0; j--) {
			for (int k = n; k >= j; k--) {
				if (dict.contains(s.substring(j, k))) {
					for (String q : patterns.get(k)) {
						String next = s.substring(j, k);
						if (!q.isEmpty()) {
							next += " " + q;
						}
						patterns.get(j).add(next);
					}
				}
			}
		}
		return patterns.get(0);
	}
}
