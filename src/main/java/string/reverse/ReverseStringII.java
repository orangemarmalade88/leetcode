package string.reverse;

public class ReverseStringII {
	public String reverseStr(String s, int k) {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		int n = s.length();
		while (i < n) {
			if (i + k <= n) {
				sb.append(reverse(s.substring(i, i + k)));
			} else {
				sb.append(reverse(s.substring(i, n)));
				break;
			}
			i = i + k;
			if (i + k <= n) {
				sb.append(s.substring(i, i + k));
			} else {
				sb.append(s.substring(i, n));
				break;
			}
			i = i + k;
		}
		return sb.toString();
	}

	public StringBuilder reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse();
	}
}
