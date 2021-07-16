package string;

public class ReverseStringII {
	/*
	 * Given a string s and an integer k, reverse the first k characters for
	 * every 2k characters counting from the start of the string.
	 * 
	 * If there are fewer than k characters left, reverse all of them. If there
	 * are less than 2k but greater than or equal to k characters, then reverse
	 * the first k characters and left the other as original.
	 * 
	 * 
	 * 
	 * 
	 */
	public String reverseStr(String s, int k) {
		StringBuilder res = new StringBuilder();
		boolean reverse = true;
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			sb.append(s.charAt(i));
			if (sb.length() == k) {
				if (reverse)
					sb.reverse();
				res.append(sb);
				sb = new StringBuilder();
				reverse = !reverse;
			}
		}
		if (reverse)
			sb.reverse();
		res.append(sb);
		return res.toString();
	}
}
