package string;

/*

 Given a string S, find the longest palindromic substring in S.
 You may assume that the maximum length of S is 1000,
 and there exists one unique longest palindromic substring.

 */

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		boolean[][] table = new boolean[s.length()][s.length()];
		int max_step = 0;
		String longest_str = "";
		// table[i][j] if s[i] ... s[j] is a palindrome

		if (s.length() > 0) {
			longest_str = s.substring(0, 1);
		}

		for (int i = 0; i < s.length(); i++) {
			table[i][i] = true;
		}

		for (int i = 0; i + 1 < s.length(); i++) {
			boolean isP = s.charAt(i) == s.charAt(i + 1);
			if (isP) {
				table[i][i + 1] = isP;
				if (1 > max_step) {
					max_step = 1;
					longest_str = s.substring(i, i + 2);
				}
			}
		}

		for (int step = 2; step <= s.length() - 1; step++) {
			for (int i = 0; i + step < s.length(); i++) {
				boolean isP = table[i + 1][i + step - 1]
						&& (s.charAt(i) == s.charAt(i + step));
				if (isP) {
					table[i][i + step] = isP;
					if (step > max_step) {
						max_step = step;
						longest_str = s.substring(i, i + step + 1);
					}
				}
			}
		}
		return longest_str;
	}

	// Improvement: Use integer to store starting point, also always update max
	// because we
	// go from step = 1, 2, ....
	public String longestPalindrome2(String s) {
		boolean[][] table = new boolean[s.length()][s.length()];
		int max_length = 0;
		int start = 0;

		for (int i = 0; i < s.length(); i++) {
			table[i][i] = true;
			start = i;
			max_length = 1;
		}

		for (int i = 0; i + 1 < s.length(); i++) {
			if (table[i][i + 1] = s.charAt(i) == s.charAt(i + 1)) {
				start = i;
				max_length = 2;
			}
		}

		// Another loop style is: outer loop end index, inner loop start index
		for (int step = 2; step <= s.length() - 1; step++) {
			for (int i = 0; i + step < s.length(); i++) {
				if (table[i][i + step] = table[i + 1][i + step - 1]
						&& (s.charAt(i) == s.charAt(i + step))) {
					start = i;
					max_length = step + 1;
				}
			}
		}

		return s.substring(start, start + max_length);
	}

	// Alternative solution:
	// 1. search each center O(N^2) time, O(1) space
	// 2. Manacher's Algorithm O(N) time
}