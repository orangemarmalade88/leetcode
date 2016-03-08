package string;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/*
 Given a string s and a dictionary of words dict, add spaces in s to construct a sentence
 where each word is a valid dictionary word.

 Return all such possible sentences.

 For example, given
 s = "catsanddog",
 dict = ["cat", "cats", "and", "sand", "dog"].

 A solution is ["cats and dog", "cat sand dog"].

 */

public class WordBreakII {

	// Other thoughts: if dict is small, for every word in dict,
	// record if its a pattern in S in a table P
	// then do DFS on table P
	// http://www.programcreek.com/2014/03/leetcode-word-break-ii-java/
	// O(D+ N^2 + 2^N)

	public List<String> wordBreak(String s, Set<String> wordDict) {

		boolean[] valid = new boolean[s.length() + 1];
		valid[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (valid[j] && wordDict.contains(s.substring(j, i))) {
					valid[i] = true;
					break;
				}
			}
		}

		List<String> result = new ArrayList<>();
		if (valid[s.length()])
			dfs(0, new ArrayList<String>(), s, wordDict, result);
		return result;
	}

	private void dfs(int start, List<String> current, String s,
			Set<String> wordDict, List<String> result) {
		if (start >= s.length()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < current.size(); i++) {
				sb.append(current.get(i));
				if (i != current.size() - 1)
					sb.append(" ");
			}
			result.add(sb.toString());
		} else {
			for (int i = start; i < s.length(); i++) {
				String candidate = s.substring(start, i + 1);
				if (wordDict.contains(candidate)) {
					current.add(candidate);
					dfs(i + 1, current, s, wordDict, result);
					current.remove(current.size() - 1);
				}
			}
		}
	}

	// Other solution:
	// Compute DP matrix on the fly
	public List<String> wordBreak2(String s, Set<String> wordDict) {
		List<String> result = new ArrayList<>();
		boolean[] invalid = new boolean[s.length() + 1];
		dfs2(0, new ArrayList<String>(), s, invalid, wordDict, result);
		return result;
	}

	private void dfs2(int start, List<String> current, String s,
			boolean[] invalid, Set<String> wordDict, List<String> result) {
		if (start == s.length()) {
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < current.size(); i++) {
				if (i != 0) {
					sb.append(" ");
				}
				sb.append(current.get(i));
			}
			result.add(sb.toString());
		} else {
			for (int i = start; i < s.length(); i++) {
				String candidate = s.substring(start, i + 1);
				if (wordDict.contains(candidate) && !invalid[i + 1]) {
					current.add(candidate);
					int before = result.size();
					dfs2(i + 1, current, s, invalid, wordDict, result);
					if (result.size() == before)
						invalid[i + 1] = true;
					current.remove(current.size() - 1);
				}

			}
		}
	}
}
