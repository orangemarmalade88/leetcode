package string.reverse;

public class ReverseWordsinaString {
	public String reverseWords(String s) {
		String[] parts = s.trim().split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = parts.length - 1; i >= 0; i--) {
			String p = parts[i];
			if (!p.isEmpty()) {
				sb.append(p).append(" ");
			}
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
