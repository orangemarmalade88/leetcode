package string.reverse;

public class ReverseWordsinaStringII {
	public void reverseWords(char[] s) {
		reverse(s, 0, s.length - 1);

		int cur = 0;
		while (cur < s.length) {
			int white = findNextWhite(s, cur);

			reverse(s, cur, white - 1);
			cur = white + 1;
		}
	}

	public void reverse(char[] s, int start, int end) {
		while (start < end) {
			char t = s[start];
			s[start] = s[end];
			s[end] = t;
			start++;
			end--;
		}
	}

	public int findNextWhite(char[] s, int cur) {
		int i = cur;
		while (i < s.length) {
			if (s[i] == ' ')
				return i;
			i++;
		}
		return i;
	}
}
