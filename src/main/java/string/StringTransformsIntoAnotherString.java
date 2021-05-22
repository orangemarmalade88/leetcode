package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class StringTransformsIntoAnotherString {
	/*
	 * Given two strings str1 and str2 of the same length, determine whether you
	 * can transform str1 into str2 by doing zero or more conversions.
	 *
	 * In one conversion you can convert all occurrences of one character in
	 * str1 to any other lowercase English character.
	 *
	 * Return true if and only if you can transform str1 into str2.
	 *
	 */

	// O(N)
	public boolean canConvert(String str1, String str2) {
		if (str1.length() != str2.length())
			return false;
		if (str1.equals(str2))
			return true;
		Map<Character, Character> m = new HashMap<>();
		for (int i = 0; i < str1.length(); i++) {
			char c1 = str1.charAt(i);
			char c2 = str2.charAt(i);
			if (!m.containsKey(c1)) {
				m.put(c1, c2);
			} else if (m.get(c1) != c2)
				return false;
		}
		return new HashSet<Character>(m.values()).size() < 26;
	}
}
