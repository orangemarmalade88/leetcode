package string;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
	public boolean isIsomorphic(String s, String t) {
		if (s.length() != t.length())
			return false;
		Map<Character, Character> map = new HashMap<>();
		Map<Character, Character> reverse = new HashMap<>();

		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if (map.get(a) != null && map.get(a) != b)
				return false;
			if (reverse.get(b) != null && reverse.get(b) != a)
				return false;
			map.put(a, b);
			reverse.put(b, a);
		}
		return true;
	}
}
