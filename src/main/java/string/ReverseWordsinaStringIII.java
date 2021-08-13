package string;

public class ReverseWordsinaStringIII {
	public String reverseWords(String s) {
		StringBuilder sb = new StringBuilder();
		for (String parts : s.split(" ")) {
			sb.append(reverse(parts)).append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}

	public StringBuilder reverse(String s) {
		StringBuilder sb = new StringBuilder(s);
		return sb.reverse();
	}
}
