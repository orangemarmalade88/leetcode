package string.palindrome;

public class LongestPalindromicSubstring {
	public String longestPalindrome(String s) {
		int n = s.length();
		boolean[][] dp = new boolean[n][n + 1];
		for (int i = 0; i < n; i++) {
			dp[i][i] = true;
			dp[i][i + 1] = true;
		}

		int max = 0;
		if (n == 0)
			return "";
		String res = String.valueOf(s.charAt(0));
		for (int size = 2; size <= n; size++) {
			for (int i = 0; i + size <= n; i++) {
				dp[i][i + size] = dp[i + 1][i + size - 1]
						&& s.charAt(i) == s.charAt(i + size - 1);
				if (dp[i][i + size] && size > max) {
					max = size;
					res = s.substring(i, i + size);
				}
			}
		}

		return res;

	}
}
