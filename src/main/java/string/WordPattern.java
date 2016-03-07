package string;

import java.util.HashMap;
import java.util.Map;

/*

 Given a pattern and a string str, find if str follows the same pattern.

 Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.

 Examples:

 1.pattern = "abba", str = "dog cat cat dog" should return true.
 2.pattern = "abba", str = "dog cat cat fish" should return false.
 3.pattern = "aaaa", str = "dog cat cat dog" should return false.
 4.pattern = "abba", str = "dog dog dog dog" should return false.

 Notes:
 You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.

 */

public class WordPattern {
	public boolean wordPattern(String pattern, String str) {
		String[] strs = str.split(" ");
		if (strs.length != pattern.length())
			return false;
		Map<String, Character> map = new HashMap<>();
		boolean[] used = new boolean[26];
		for (int i = 0; i < pattern.length(); i++) {
			if (map.containsKey(strs[i])) {
				if (map.get(strs[i]) == pattern.charAt(i))
					continue;
				else
					return false;
			} else {
				if (used[pattern.charAt(i) - 'a']) {
					return false;
				} else {
					map.put(strs[i], pattern.charAt(i));
					used[pattern.charAt(i) - 'a'] = true;
				}
			}
		}
		return true;
	}
}
