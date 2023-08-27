package string;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
	public boolean wordBreak(String s, List<String> wordDict) {
		Set<String> dict = new HashSet<>();
		dict.addAll(wordDict);

		int n = s.length();
		boolean[] dp = new boolean[n + 1]; // substring(i, n) is valid
		dp[n] = true;

		for (int i = n - 1; i >= 0; i--) {
			boolean res = dict.contains(s.substring(i, n));
			for (int j = n; j >= i; j--) {
				res |= dict.contains(s.substring(i, j)) && dp[j];
			}
			dp[i] = res;
		}

		return dp[0];

	}

}
