package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*

 Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty substring in str.

 Examples:

 1.pattern = "abab", str = "redblueredblue" should return true.
 2.pattern = "aaaa", str = "asdasdasdasd" should return true.
 3.pattern = "aabb", str = "xyzabcxzyabc" should return false.


 Notes:
 You may assume both pattern and str contains only lowercase letters.

 */

public class WordPatternII {
	public boolean wordPatternMatch(String pattern, String str) {
		return dfs(pattern, str, 0, 0, new HashMap<Character, String>(),
				new HashSet<String>());
	}

	private boolean dfs(String pattern, String str, int p_index, int s_index,
			Map<Character, String> mapping, Set<String> set) {
		if (p_index == pattern.length() && s_index == str.length())
			return true;
		if (p_index == pattern.length() || s_index == str.length())
			return false;
		if (mapping.containsKey(pattern.charAt(p_index))) {
			String p = mapping.get(pattern.charAt(p_index));
			if (str.length() < s_index + p.length()
					|| !str.substring(s_index, s_index + p.length()).equals(p))
				return false;
			return dfs(pattern, str, p_index + 1, s_index + p.length(),
					mapping, set);
		} else {
			for (int end = s_index + 1; end <= str.length(); end++) {
				String p = str.substring(s_index, end);
				char c = pattern.charAt(p_index);
				if (set.contains(p))
					continue; // Mistake: This is continue here, not return
				mapping.put(c, p);
				set.add(p);
				if (dfs(pattern, str, p_index + 1, end, mapping, set))
					return true;
				mapping.remove(c);
				set.remove(p);
			}
			return false;
		}
	}
}
