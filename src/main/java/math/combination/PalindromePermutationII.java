package math.combination;

import java.util.ArrayList;
import java.util.List;

/*

 Given a string s, return all the palindromic permutations (without duplicates) of it.
 Return an empty list if no palindromic permutation could be form.

 For example:

 Given s = "aabb", return ["abba", "baab"].

 Given s = "abc", return [].

 */

public class PalindromePermutationII {
	public List<String> generatePalindromes(String s) {
		List<String> result = new ArrayList<>();
		int[] counts = new int[256];
		for (int i = 0; i < s.length(); i++) {
			counts[s.charAt(i)]++;
		}
		int oddIndex = -1;
		for (int j = 0; j < counts.length; j++) {
			if (counts[j] % 2 != 0) {
				if (oddIndex != -1)
					return result;
				else
					oddIndex = j;
			}
		}
		dfs(counts, "", oddIndex, s.length(), result);
		return result;
	}

	private void dfs(int[] counts, String s, int oddIndex, int total,
			List<String> result) {
		if (s.length() == total / 2) {
			String rev = new StringBuilder(s).reverse().toString();
			result.add(s + ((oddIndex == -1) ? "" : (char) oddIndex) + rev);
		} else {
			for (int i = 0; i < counts.length; i++) {
				if (counts[i] >= 2) {
					counts[i] = counts[i] - 2;
					dfs(counts, s + (char) i, oddIndex, total, result);
					counts[i] = counts[i] + 2;
				}
			}
		}
	}
}
