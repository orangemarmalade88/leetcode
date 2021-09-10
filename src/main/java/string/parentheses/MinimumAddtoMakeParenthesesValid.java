package string.parentheses;

public class MinimumAddtoMakeParenthesesValid {
	public int minAddToMakeValid(String s) {
		int ans = 0;
		int count = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				count++;
			} else {
				count--;
				if (count < 0) {
					ans++;
					count++;
				}
			}
		}
		return ans + count;
	}
}
