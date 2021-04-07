package string;

public class MinimumRemoveToMakeValidParentheses {
	/*
	 * 1249. Minimum Remove to Make Valid Parentheses
	 *
	 * Given a string s of '(' , ')' and lowercase English characters.
	 *
	 * Your task is to remove the minimum number of parentheses ( '(' or ')', in
	 * any positions ) so that the resulting parentheses string is valid and
	 * return any valid string.
	 *
	 * Formally, a parentheses string is valid if and only if:
	 *
	 * It is the empty string, contains only lowercase characters, or It can be
	 * written as AB (A concatenated with B), where A and B are valid strings,
	 * or It can be written as (A), where A is a valid string.
	 */
	public String minRemoveToMakeValid(String s) {
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
				sb.append('(');
			} else if (s.charAt(i) == ')') {
				if (count > 0) {
					count--;
					sb.append(')');
				}
			} else
				sb.append(s.charAt(i));
		}
		StringBuilder sb2 = new StringBuilder();
		count = 0;
		for (int i = sb.length() - 1; i >= 0; i--) {
			if (sb.charAt(i) == ')') {
				count++;
				sb2.append(')');
			} else if (sb.charAt(i) == '(') {
				if (count > 0) {
					count--;
					sb2.append('(');
				}
			} else
				sb2.append(sb.charAt(i));
		}
		return sb2.reverse().toString();
	}
}
