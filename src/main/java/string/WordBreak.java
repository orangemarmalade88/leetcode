package string;

import java.util.Set;

/*

 Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

 For example, given
 s = "leetcode",
 dict = ["leet", "code"].

 Return true because "leetcode" can be segmented as "leet code".

 */

public class WordBreak {
	// Mistake: This is a 1-D problem!

	public boolean wordBreak(String s, Set<String> wordDict) {
		boolean[] valid = new boolean[s.length()];
		valid[0] = wordDict.contains(s.substring(0, 1));

		for (int i = 1; i < s.length(); i++) {
			// Mistake: Don't forget base condition
			if (wordDict.contains(s.substring(0, i + 1))) {
				valid[i] = true;
				continue;
			}
			for (int j = 0; j < i; j++) {
				if (valid[j] && wordDict.contains(s.substring(j + 1, i + 1))) {
					valid[i] = true;
					break;
				}

			}
		}

		return valid[s.length() - 1];
	}

	public boolean wordBreak2(String s, Set<String> wordDict) {
		boolean[] valid = new boolean[s.length() + 1];
		valid[0] = true;
		// Careful: i means string length = i could be divided
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (valid[j] && wordDict.contains(s.substring(j, i))) {
					valid[i] = true;
					break;
				}
			}
		}
		return valid[s.length()];
	}
}
