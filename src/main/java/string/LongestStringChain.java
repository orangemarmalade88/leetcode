package string;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
	public int longestStrChain(String[] words) {
		Arrays.sort(words, (a, b) -> a.length() - b.length());

		Map<String, Integer> map = new HashMap<>();
		int global_max = 1;
		for (String s : words) {
			int max = 1;
			for (int i = 0; i < s.length(); i++) {
				StringBuilder sb = new StringBuilder(s);
				sb.deleteCharAt(i);
				String res = sb.toString();
				if (map.containsKey(res)) {
					max = Math.max(max, map.get(res) + 1);
				}
			}
			map.put(s, max);
			global_max = Math.max(max, global_max);

		}
		return global_max;
	}
}
