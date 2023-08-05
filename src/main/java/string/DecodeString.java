package string;

public class DecodeString {
	public static String decodeString(String s) {
		return decodeStringHelper(s, 0, s.length() - 1);
	}

	public static String decodeStringHelper(String s, int s_index,
			int e_index) {
		StringBuilder sb = new StringBuilder();
		for (int i = s_index; i <= e_index; i++) {
			char c = s.charAt(i);
			if (Character.isLetter(c)) {
				sb.append(c);
			} else if (Character.isDigit(c)) {
				int e = i + 1;
				while (s.charAt(e) != '[') {
					e++;
				}
				int repeats = Integer.parseInt(s.substring(i, e));
				int counts = 1;
				int j = e;
				while (counts > 0) {
					j++;
					char cc = s.charAt(j);
					if (cc == '[')
						counts++;
					else if (cc == ']')
						counts--;
				}
				String content = decodeStringHelper(s, e + 1, j - 1);
				for (int k = 0; k < repeats; k++) {
					sb.append(content);
				}
				i = j;
			}
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		decodeString("3[a]2[bc]");
	}
}
