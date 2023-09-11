package string;

public class ScoreofParentheses {
	public int scoreOfParentheses(String s) {
		return scoreOfParentheses(s, 0, s.length() - 1);
	}

	public int scoreOfParentheses(String s, int start, int end) {
		if (start == end - 1)
			return 1;
		int pair = findNextPairing(s, start);
		if (pair == end) {
			return 2 * scoreOfParentheses(s, start + 1, end - 1);
		}
		int sum = 0;
		int cur = start;
		while (cur < end) {
			int next = findNextPairing(s, cur);
			sum += scoreOfParentheses(s, cur, next);
			cur = next + 1;
		}
		return sum;
	}

	public int findNextPairing(String s, int start) {
		int count = 1;
		start++;
		while (count != 0) {
			char c = s.charAt(start);
			if (c == '(')
				count++;
			else
				count--;
			start++;
		}
		return start - 1;
	}
}
