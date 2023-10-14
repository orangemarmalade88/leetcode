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
				if (map.get(parts[i]) != s.charAt(i)) {
					return false;
				}
				if (!dict[s.charAt(i) - 'a'].equals(parts[i])) {
					return false;
				}
			} else {
				map.put(parts[i], s.charAt(i));
				dict[s.charAt(i) - 'a'] = parts[i];
			}
		}
		return true;
	}
}
