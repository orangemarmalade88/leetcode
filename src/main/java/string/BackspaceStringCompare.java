package string;

public class BackspaceStringCompare {
	public boolean backspaceCompare(String s, String t) {
		return shorten(s).equals(shorten(t));
	}

	public String shorten(String s) {
		StringBuilder sb = new StringBuilder(s);
		for (char c : s.toCharArray()) {
			if (c == '#') {
				if (sb.length() > 0) {
					sb.deleteCharAt(sb.length() - 1);
				}
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}
}
