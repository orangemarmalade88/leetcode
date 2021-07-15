package string;

public class ReverseWordsInaStringIII {
	/*
	 * Given a string s, reverse the order of characters in each word within a
	 * sentence while still preserving whitespace and initial word order.
	 * 
	 * 
	 */
	public String reverseWords(String s) {
		String[] parts = s.split(" ");
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < parts.length; i++) {
			StringBuilder b = new StringBuilder();
			b.append(parts[i]);
			sb.append(b.reverse());
			if (i != parts.length - 1)
				sb.append(" ");
		}
		return sb.toString();
	}
}
