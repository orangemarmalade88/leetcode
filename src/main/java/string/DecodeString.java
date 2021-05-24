package string;

public class DecodeString {
	/*
	 * Given an encoded string, return its decoded string.
	 * 
	 * The encoding rule is: k[encoded_string], where the encoded_string inside
	 * the square brackets is being repeated exactly k times. Note that k is
	 * guaranteed to be a positive integer.
	 * 
	 * You may assume that the input string is always valid; No extra white
	 * spaces, square brackets are well-formed, etc.
	 * 
	 * Furthermore, you may assume that the original data does not contain any
	 * digits and that digits are only for those repeat numbers, k. For example,
	 * there won't be input like 3a or 2[4].
	 * 
	 * 
	 */
	public String decodeString(String s) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < s.length(); i++) {
			int num = 0;
			while (Character.isDigit(s.charAt(i))) {
				num = num * 10 + s.charAt(i) - '0';
				i++;
			}
			if (s.charAt(i) == '[') {
				int count = 1;
				int j = i + 1;
				while (count > 0) {
					if (s.charAt(j) == '[')
						count++;
					else if (s.charAt(j) == ']')
						count--;
					j++;
				}
				String sub = s.substring(i + 1, j - 1);
				String decoded = decodeString(sub);
				for (int k = 0; k < num; k++) {
					sb.append(decoded);
				}
				i = j - 1;
			} else
				sb.append(s.charAt(i));
		}
		return sb.toString();
	}
}
