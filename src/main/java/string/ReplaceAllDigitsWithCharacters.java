package string;

public class ReplaceAllDigitsWithCharacters {
	/*
	 * You are given a 0-indexed string s that has lowercase English letters in
	 * its even indices and digits in its odd indices.
	 * 
	 * There is a function shift(c, x), where c is a character and x is a digit,
	 * that returns the xth character after c.
	 * 
	 * For example, shift('a', 5) = 'f' and shift('x', 0) = 'x'. For every odd
	 * index i, you want to replace the digit s[i] with shift(s[i-1], s[i]).
	 * 
	 * Return s after replacing all digits. It is guaranteed that shift(s[i-1],
	 * s[i]) will never exceed 'z'.
	 * 
	 * 
	 */
	public String replaceDigits(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length();) {
			char cur = s.charAt(i);
			sb.append(cur);
			if (i + 1 < s.length())
				sb.append((char) (cur + s.charAt(i + 1) - '0'));
			i = i + 2;
		}
		return sb.toString();
	}
}
