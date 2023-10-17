package string;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
	public boolean wordPattern(String pattern, String s) {
		String[] parts = s.split(" ");
		Map<String, Character> map = new HashMap<>();
		String[] dict = new String[26];

		if (parts.length != pattern.length())
			return false;

		for (int i = 0; i < parts.length; i++) {
			if (map.containsKey(parts[i])) {
				if (map.get(parts[i]) != pattern.charAt(i)) {
					return false;
				}
				if (!dict[pattern.charAt(i) - 'a'].equals(parts[i])) {
					return false;
				}
			} else {
				if (dict[pattern.charAt(i) - 'a'] != null)
					return false;
				map.put(parts[i], pattern.charAt(i));
				dict[pattern.charAt(i) - 'a'] = parts[i];
			}
		}
		return true;
	}
}
