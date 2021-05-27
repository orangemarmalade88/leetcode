package string;

public class SimiliarStringGroups {
	/*
	 * Two strings X and Y are similar if we can swap two letters (in different
	 * positions) of X, so that it equals Y. Also two strings X and Y are
	 * similar if they are equal.
	 *
	 * For example, "tars" and "rats" are similar (swapping at positions 0 and
	 * 2), and "rats" and "arts" are similar, but "star" is not similar to
	 * "tars", "rats", or "arts".
	 *
	 * Together, these form two connected groups by similarity: {"tars", "rats",
	 * "arts"} and {"star"}. Notice that "tars" and "arts" are in the same group
	 * even though they are not similar. Formally, each group is such that a
	 * word is in the group if and only if it is similar to at least one other
	 * word in the group.
	 *
	 * We are given a list strs of strings where every string in strs is an
	 * anagram of every other string in strs. How many groups are there?
	 *
	 */

	// O(N^2)
	public int numSimilarGroups(String[] strs) {
		boolean[] visited = new boolean[strs.length];
		int res = 0;
		for (int i = 0; i < strs.length; i++) {
			if (!visited[i]) {
				dfs(strs, i, visited);
				res++;
			}
		}
		return res;
	}

	public void dfs(String[] strs, int cur, boolean[] visited) {
		visited[cur] = true;
		for (int i = 0; i < strs.length; i++) {
			if (!visited[i] && isSimilar(strs[i], strs[cur]))
				dfs(strs, i, visited);
		}
	}

	public boolean isSimilar(String a, String b) {
		int count = 0;
		for (int i = 0; i < a.length(); i++) {
			if (a.charAt(i) != b.charAt(i))
				count++;
		}
		return count == 2 || count == 0;
	}
}
