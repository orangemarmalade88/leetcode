package string;

public class ConstructKPalindromeStrings {
	/*
	 * 1400. Construct K Palindrome Strings
	 *
	 * Given a string s and an integer k. You should construct k non-empty
	 * palindrome strings using all the characters in s.
	 *
	 * Return True if you can use all the characters in s to construct k
	 * palindrome strings or False otherwise.
	 *
	 */
	public boolean canConstruct(String s, int k) {
		if (s.length() < k)
			return false;
		boolean[] map = new boolean[26];
		int odd_counts = 0;
		for (int i = 0; i < s.length(); i++) {
			if (map[s.charAt(i) - 'a']) {
				map[s.charAt(i) - 'a'] = false;
				odd_counts--;
			} else {
				map[s.charAt(i) - 'a'] = true;
				odd_counts++;
			}

		}
		return odd_counts <= k;
	}
}
